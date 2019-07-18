package cn.com.cootoo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadLocal与线程池使用的问题
 * <p>
 * threadlocal 内部有一个ThreadLocalMap<Thread,T>,
 * ThreadLocalMap维护了Entry环形数组，数组中元素Entry的逻辑上的key为某个ThreadLocal对象（实际上是指向该ThreadLocal对象的弱引用），value为代码中该线程往该ThreadLoacl变量实际塞入的值。
 * <p>
 * 而线程池是对线程进行复用的，如果没有及时的清理，那么之前对该线程的使用，就会影响到后面的线程了，造成数据不准确。
 *
 * @author zhaoxiang
 * @create 2019/7/18
 **/
public class MyThreadLocalTest {


    /**
     * jdk8 的语法
     */
    private static ThreadLocal<Integer> variableLocal = ThreadLocal.withInitial(() -> 0);

    public static int get() {
        return variableLocal.get();
    }

    public static void remove() {
        variableLocal.remove();
    }

    public static void increment() {
        variableLocal.set(variableLocal.get() + 1);
    }

    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(2, 2, 0, TimeUnit.SECONDS, new LinkedBlockingDeque<>(12));

        for (int i = 0; i < 5; i++) {
            executorService.execute(() -> {
                try {
                    long threadId = Thread.currentThread().getId();

                    int before = get();
                    increment();
                    int after = get();
                    System.out.println("threadid " + threadId + "  before " + before + ", after " + after);
                } finally {
                    // 需要remove,必免数据不准确
                    remove();
                }
            });
        }

        executorService.shutdown();
    }

}
