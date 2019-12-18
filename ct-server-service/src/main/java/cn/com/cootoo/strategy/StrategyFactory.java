package cn.com.cootoo.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 策略工厂
 * Created by zhaoxiang
 * Date 2019/12/18 4:31 下午
 * Description
 */
public class StrategyFactory {

    private Map<Integer, IStrategy> map;

    public StrategyFactory() {
        List<IStrategy> strategies = new ArrayList<>();
        strategies.add(new StrategyA());
        strategies.add(new StrategyB());
        strategies.add(new StrategyC());
        // java8 stream 方式
        strategies.stream().collect(Collectors.toMap(IStrategy::getType, strategy -> strategy));
    }

    public static class Holder {
        public static StrategyFactory instance = new StrategyFactory();
    }

    public static StrategyFactory getInstance() {
        return Holder.instance;
    }

    public IStrategy get(Integer type) {
        return map.get(type);
    }
}
