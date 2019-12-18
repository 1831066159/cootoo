package cn.com.cootoo.strategy;

/**
 * 策略
 * Created by zhaoxiang
 * Date 2019/12/18 4:37 下午
 * Description
 */
public class MainApp {


    private static double getResult(long money, int type) {
        if (money < 1000) {
            return money;
        }

        IStrategy strategy = StrategyFactory.getInstance().get(type);

        if (strategy == null) {
            throw new IllegalArgumentException("please input right type");
        }

        return strategy.computer(money);
    }


    public static void main(String[] args) {

        double res = getResult(6, 1);
        System.out.println(res);
    }

}
