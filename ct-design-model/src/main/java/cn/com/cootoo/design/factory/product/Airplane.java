package cn.com.cootoo.design.factory.product;

import cn.com.cootoo.design.factory.Product;

/**
 * 具体产品
 * Created by system
 * Date 2020/1/16 11:25 上午
 * Description
 */
public class Airplane implements Product {
    @Override
    public String showProductName() {
        System.out.println("飞机");
        return "飞机";
    }
}
