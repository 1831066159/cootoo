package cn.com.cootoo.design.signlten;

/**
 * 饿汉模式
 * 该模式的特点是类一旦加载就创建一个单例，保证在调用 getInstance 方法之前单例已经存在了
 * Created by system
 * Date 2020/1/16 10:16 上午
 * Description
 */
public class HungrySignlten {

    private static final HungrySignlten instance = new HungrySignlten();

    private HungrySignlten() {
    }

    public static HungrySignlten getInstance() {
        return instance;
    }
}
