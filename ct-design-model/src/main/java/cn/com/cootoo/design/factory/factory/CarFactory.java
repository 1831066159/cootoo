package cn.com.cootoo.design.factory.factory;

import cn.com.cootoo.design.factory.AbstractFactory;
import cn.com.cootoo.design.factory.Product;
import cn.com.cootoo.design.factory.product.Car;

/**
 * 具体工厂
 * Created by zhaoxiang
 * Date 2020/1/16 11:27 上午
 * Description
 */
public class CarFactory implements AbstractFactory {
    @Override
    public Product newPorduct() {
        return new Car();
    }
}
