package cn.com.cootoo.design.proxy;

/**
 * Created by zhaoxiang
 * Date 2020/1/17 4:11 下午
 * Description
 */
public class Proxy implements Subject {

    private RealSubject realSubject;

    @Override
    public void request() {
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        pre();
        realSubject.request();
        end();
    }

    private void pre() {
        System.out.println("proxy之前执行");
    }

    private void end() {
        System.out.println("proxy之后执行");
    }
}
