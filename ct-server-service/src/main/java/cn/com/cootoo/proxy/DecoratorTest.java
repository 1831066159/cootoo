package cn.com.cootoo.proxy;

/**
 * 装饰器
 * @author system
 * @create 2019/8/9
 **/
public class DecoratorTest implements ITest {

    private ITest target;

    public DecoratorTest(ITest target) {
        this.target = target;
    }

    @Override
    public int show(int i) {
        return target.show(i);
    }
}
