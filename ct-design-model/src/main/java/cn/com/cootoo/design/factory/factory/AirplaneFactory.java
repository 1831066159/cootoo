package cn.com.cootoo.design.factory.factory;

import cn.com.cootoo.design.factory.AbstractFactory;
import cn.com.cootoo.design.factory.Product;
import cn.com.cootoo.design.factory.product.Airplane;

/**
 * 具体工厂
 * Created by zhaoxiang
 * Date 2020/1/16 11:31 上午
 * Description
 */
public class AirplaneFactory implements AbstractFactory {
    @Override
    public Product newPorduct() {
        return new Airplane();
    }
}
