package com.webull.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.regex.Pattern;

/**
 * @Author: Zhaoxiang
 * @Date: 2021/4/19
 */
public class ParseAddr {

    public static String  getAddDetail(String result) {
        JSONArray jsonArray = JSON.parseArray(result);
        if (jsonArray.size() > 1) {
            String[] adds = jsonArray.get(1).toString().split(",");
            int n = 0;
            int max = 0;
            for (int i = 0; i < adds.length; i++) {
                if (max < adds[i].length()) {
                    max = adds[i].length();
                    n = i;
                }
            }
            String res=filtration(adds[n]);
            System.out.println(res);
            return res;
        }
        return null;
    }

    public static final String regEx = "[`~!@#$%^&*()+=|{}:;\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？']";
    public static Pattern pattern = Pattern.compile(regEx);

    public static String filtration(String str) {
        str = pattern.matcher(str).replaceAll("").trim();
        System.out.println("str ======" + str + ".");
        return str;
    }

}
