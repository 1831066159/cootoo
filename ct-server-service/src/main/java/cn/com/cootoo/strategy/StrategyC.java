package cn.com.cootoo.strategy;

/**
 * Created by zhaoxiang
 * Date 2019/12/18 4:30 下午
 * Description
 */
public class StrategyC implements IStrategy {

    @Override
    public long computer(long value) {
        return 100 + value;
    }

    @Override
    public int getType() {
        return 2;
    }
}
