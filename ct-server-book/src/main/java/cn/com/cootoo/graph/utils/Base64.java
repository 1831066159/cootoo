package cn.com.cootoo.graph.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

public class Base64     
{     
    /**    
     * BASE64解密   
     */
    public static byte[] decryptBASE64(String key) throws IOException {
        return (new BASE64Decoder()).decodeBuffer(key);               
    }                             
    /**         
     * BASE64加密   
     */
    public static String encodeBase64String(byte[] key) {
        return (new BASE64Encoder()).encodeBuffer(key);               
    }       
}    
