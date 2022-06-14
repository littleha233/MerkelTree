package com.utils;

import java.io.UnsupportedEncodingException;

/**
 * String 和 byte[] 互相转换的工具类
 */
public class String2ByteArr {

    /**
     * String转byte数组
     * @param str 字符串类型
     * @return
     * @throws UnsupportedEncodingException
     */
    public static byte[] String2BytesArr(String str) throws UnsupportedEncodingException {
        return str.getBytes("UTF-8");
    }

    /**
     * byte数组转String
     * @param bytes byte[]数组类型
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String BytesArr2String(byte[] bytes) throws UnsupportedEncodingException {
        return new String(bytes,"UTF-8");
    }

}
