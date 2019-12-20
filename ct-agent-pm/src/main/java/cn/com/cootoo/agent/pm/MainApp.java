package cn.com.cootoo.agent.pm;

/**
 * java agent 测试
 * Created by zhaoxiang
 * Date 2019/12/20 11:22 上午
 * Description
 */
public class MainApp {


    public static void main(String[] args) {
        System.out.println("执行main方法");
    }

    public static void sayHello1() {
        try {
            Thread.sleep(2000);
            System.out.println("hello world!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sayHello2(String hello) {
        try {
            Thread.sleep(1000);
            System.out.println(hello);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
