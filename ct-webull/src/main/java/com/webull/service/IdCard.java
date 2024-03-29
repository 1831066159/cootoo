package com.webull.service;

/**
 * 身份证实体类
 *
 * @author wangxw
 * @version 1.0
 * @date Jul 11, 2014 10:46:54 AM
 */
public class IdCard {

    // 身份证号码
    private String idCard;

    // 出生日期
    private String born;

    // 性别
    private String sex;

    // 所在地区
    private String att;

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAtt() {
        return att;
    }

    public void setAtt(String att) {
        this.att = att;
    }
}
