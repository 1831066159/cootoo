package cn.com.cootoo.design.factory;

import cn.com.cootoo.design.factory.factory.AirplaneFactory;
import cn.com.cootoo.design.factory.factory.CarFactory;
import cn.com.cootoo.design.factory.factory.TrainFactory;

/**
 * Created by zhaoxiang
 * Date 2020/1/16 11:32 上午
 * Description
 */
public class MainTest {

    public static void main(String[] args) {

        Product product;
        AbstractFactory factory;

        factory = new CarFactory();
        product = factory.newPorduct();
        product.showProductName();

        factory = new TrainFactory();
        product = factory.newPorduct();
        product.showProductName();

        factory = new AirplaneFactory();
        product = factory.newPorduct();
        product.showProductName();

    }
}
