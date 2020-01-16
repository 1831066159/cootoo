package cn.com.cootoo.design.factory.product;

import cn.com.cootoo.design.factory.Product;

/**
 * 具体产品
 * Created by zhaoxiang
 * Date 2020/1/16 11:26 上午
 * Description
 */
public class Train implements Product {
    @Override
    public String showProductName() {
        System.out.println("火车");
        return "火车";
    }
}
