package cn.com.cootoo.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 *
 * cglib 代理
 *
 * @author zhaoxiang
 * @create 2019/8/9
 **/
public class CglibProxyTest implements MethodInterceptor {

    private CglibProxyTest() {
    }

    public static <T extends ITest> ITest newProxyInstance(Class<T> targetInstanceClazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetInstanceClazz);
        enhancer.setCallback(new CglibProxyTest());
        return (ITest) enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args,
                            MethodProxy proxy) throws Throwable {
        return proxy.invokeSuper(obj, args);
    }

}
