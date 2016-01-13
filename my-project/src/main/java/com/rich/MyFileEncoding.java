package com.rich;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by hanwang206326 on 16/1/13.
 */
public class MyFileEncoding {
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println(System.getProperty("file.encoding"));
        String testStr = "测试字符串";
        System.out.println(testStr.getBytes());
        System.out.println(testStr.getBytes("GBK"));
        String result = new String(testStr.getBytes("GBK"), "GBK");
        System.out.println(result);
        //%E6%B5%8B%E8%AF%95%E5%AD%97%E7%AC%A6%E4%B8%B2
        System.out.println(URLEncoder.encode(testStr, "UTF-8"));
        //%B2%E2%CA%D4%D7%D6%B7%FB%B4%AE
        System.out.println(URLEncoder.encode(testStr, "GBK"));
    }
}
