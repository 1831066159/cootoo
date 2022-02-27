package cn.com.cootoo.proxy;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 测试main
 *
 * @author system
 * @create 2019/8/9
 **/
public class ProxyPerfMainTester {

    public static void main(String[] args) {
        //创建测试对象；
        ITest nativeTest = new TestImpl();
        ITest decorator = new DecoratorTest(nativeTest);
        ITest dynamicProxy = DynamicProxyTest.newProxyInstance(nativeTest);
        ITest cglibProxy = CglibProxyTest.newProxyInstance(TestImpl.class);

        //预热一下；
        int preRunCount = 10000;
        runWithoutMonitor(nativeTest, preRunCount);
        runWithoutMonitor(decorator, preRunCount);
        runWithoutMonitor(cglibProxy, preRunCount);
        runWithoutMonitor(dynamicProxy, preRunCount);

        //执行测试；
        Map<String, ITest> tests = new LinkedHashMap<String, ITest>();
        tests.put("Native   ", nativeTest);
        tests.put("Decorator", decorator);
        tests.put("Dynamic  ", dynamicProxy);
        tests.put("Cglib    ", cglibProxy);
        int repeatCount = 3;
        int runCount = 1000000;
        runTest(repeatCount, runCount, tests);
        runCount = 50000000;
        runTest(repeatCount, runCount, tests);
    }

    private static void runTest(int repeatCount, int runCount, Map<String, ITest> tests) {
        System.out.println(String.format("\n==================== run test : [repeatCount=%s] [runCount=%s] [java.version=%s] ====================", repeatCount, runCount, System.getProperty("java.version")));
        for (int i = 0; i < repeatCount; i++) {
            System.out.println(String.format("\n--------- test : [%s] ---------", (i + 1)));
            for (String key : tests.keySet()) {
                runWithMonitor(tests.get(key), runCount, key);
            }
        }
    }

    private static void runWithoutMonitor(ITest test, int runCount) {
        for (int i = 0; i < runCount; i++) {
            test.show(i);
        }
    }

    private static void runWithMonitor(ITest test, int runCount, String tag) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < runCount; i++) {
            test.show(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("[" + tag + "] Elapsed Time:" + (end - start) + "ms");
    }
}
