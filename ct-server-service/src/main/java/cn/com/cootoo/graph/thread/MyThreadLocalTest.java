package cn.com.cootoo.graph.thread;

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

    public static void main1(String[] args) {
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


    /**
     * 在子进程中访问父进程变量
     */
    public static void main(String[] args) {
        Integer requestId = new Integer(5);
        // 在子进程中访问父进程变量
        InheritableThreadLocal<Integer> requestIdThreadLocal = new InheritableThreadLocal<>();
        requestIdThreadLocal.set(requestId);
        System.out.println("Thread:" + Thread.currentThread().getId() + ", 首先打印requestId:" + requestIdThreadLocal.get());
        (new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程启动");
                System.out.println("Thread:" + Thread.currentThread().getId() + ",在子线程中访问requestId:" + requestIdThreadLocal.get());
            }
        })).start();
    }
}
