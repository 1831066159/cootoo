package cn.com.cootoo.strategy;

/**
 * 策略接口
 * Created by zhaoxiang
 * Date 2019/12/18 4:27 下午
 * Description
 */
public interface IStrategy {

    long computer(long value);

    /**
     * 策略类型,每个策略要指定
     * @return
     */
    int getType();
}
