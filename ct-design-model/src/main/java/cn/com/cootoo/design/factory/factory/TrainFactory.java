package cn.com.cootoo.design.factory.factory;

import cn.com.cootoo.design.factory.AbstractFactory;
import cn.com.cootoo.design.factory.Product;
import cn.com.cootoo.design.factory.product.Train;

/**
 * 具体工厂
 * Created by system
 * Date 2020/1/16 11:31 上午
 * Description
 */
public class TrainFactory implements AbstractFactory {
    @Override
    public Product newPorduct() {
        return new Train();
    }
}
