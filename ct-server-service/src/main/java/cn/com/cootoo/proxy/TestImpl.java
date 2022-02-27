package cn.com.cootoo.proxy;

/**
 * @author system
 * @create 2019/8/9
 **/
public class TestImpl implements ITest {
    @Override
    public int show(int i) {
        return i + 1;
    }
}
