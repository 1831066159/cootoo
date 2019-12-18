package cn.com.cootoo.strategy;

/**
 * Created by zhaoxiang
 * Date 2019/12/18 4:29 下午
 * Description
 */
public class StrategyB implements IStrategy {


    @Override
    public long computer(long value) {

        return 2*value;
    }

    @Override
    public int getType() {
        return 1;
    }
}
