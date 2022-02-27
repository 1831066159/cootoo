package cn.com.cootoo.design.factory.product;

import cn.com.cootoo.design.factory.Product;

/**
 * 具体产品
 * Created by system
 * Date 2020/1/16 11:26 上午
 * Description
 */
public class Car implements Product {
    @Override
    public String showProductName() {
        System.out.println("小汽车");
        return "小汽车";
    }
}
