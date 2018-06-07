package com.cooperation.utils;

import org.apache.commons.lang3.StringUtils;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Base64加密，解密工具类
 *
 * @Author: Alex isidea@outlook.com
 * @Date: Created in 11:28 2018/6/7
 */
public class Base64Utils {

    private Base64Utils() {
    }

    /**
     * 加密
     * @param str
     * @return
     */
    public static String encryption(String str){
        try {
            if (StringUtils.isBlank(str)) {
                return null;
            }
            return Base64.getEncoder().encodeToString(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密
     * @return
     */
    public static String decryption(String str){
        try {
            if (StringUtils.isBlank(str)) {
                return null;
            }
            byte[] decode = Base64.getDecoder().decode(str);
            return new String(decode,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
