package cn.com.cootoo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk动态代理
 *
 * @author zhaoxiang
 * @create 2019/8/9
 **/
public class DynamicProxyTest implements InvocationHandler {
    private ITest target;

    private DynamicProxyTest(ITest target) {
        this.target = target;
    }

    public static ITest newProxyInstance(ITest target) {
        return (ITest) Proxy.newProxyInstance(DynamicProxyTest.class.getClassLoader(),
                new Class<?>[]{ITest.class},
                new DynamicProxyTest(target));

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        return method.invoke(target, args);
    }
}
