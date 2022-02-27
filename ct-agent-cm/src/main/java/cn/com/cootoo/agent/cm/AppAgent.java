package cn.com.cootoo.agent.cm;

import cn.com.cootoo.agent.cm.transform.AppTransform;

import java.lang.instrument.Instrumentation;

/**
 * Created by system
 * Date 2019/12/20 9:39 上午
 * Description
 */
public class AppAgent {


    /**
     * 该方法在main方法之前运行，与main方法运行在同一个JVM中
     * 并被同一个System ClassLoader装载
     * 被统一的安全策略(security policy)和上下文(context)管理
     *
     * @param agentOps
     * @param inst
     */
    public static void premain(String agentOps, Instrumentation inst) {
        System.out.println("====Agent代理1执行");
        System.out.println(agentOps);
        // 添加Transformer
        inst.addTransformer(new AppTransform());
        System.out.println("Transform end");
    }


    /**
     * 如果不存在 premain(String agentOps, Instrumentation inst)
     * 则会执行 premain(String agentOps)
     *
     * @param agentOps
     */
    public static void premain(String agentOps) {
        System.out.println("====Agent代理2执行");
        System.out.println(agentOps);
    }

}
