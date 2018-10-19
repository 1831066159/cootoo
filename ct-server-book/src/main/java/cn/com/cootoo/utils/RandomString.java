package cn.com.cootoo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @Description:
 * @Author: lixiaodong@souyidai.com
 * @CreateDate: 2016/5/24
 */
public class RandomString {

    /**
     * 按照当前日期生成20位随机字符串
     * @return
     */
    public static String generateId() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
        String sysDate = sf.format(new Date());
        String randomStr = randomString(6);
        return sysDate + randomStr;
    }

    /**
     * 生成随机字符串
     * @param length
     * @return
     */
    public static String randomString(int length) {
        Random randGen = null;
        char[] numbersAndLetters = null;
        if (length < 1) {
            return "";
        }
        randGen = new Random();
        numbersAndLetters = ("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
        char[] randBuffer = new char[length];
        for (int i = 0; i < randBuffer.length; i++) {
            randBuffer[i] = numbersAndLetters[randGen.nextInt(51)];
        }
        return new String(randBuffer);
    }
}
