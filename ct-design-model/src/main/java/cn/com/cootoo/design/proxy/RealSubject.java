package cn.com.cootoo.design.proxy;

/**
 * Created by zhaoxiang
 * Date 2020/1/17 4:11 下午
 * Description
 */
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("do real subject ");
    }
}
