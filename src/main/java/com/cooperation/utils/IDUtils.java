package com.cooperation.utils;

import com.google.common.base.Function;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.UUID;

/**
 * @Author: Alex isidea@outlook.com
 * @Date: Created in 14:57 2018/6/7
 */
public class IDUtils {

    /**
     * 生成用户ID
     * @return
     */
    public static java.lang.String getID(){
        UUID uuid = UUID.nameUUIDFromBytes(UUID.randomUUID().toString().getBytes());
        int i = uuid.hashCode();
        java.lang.String s = java.lang.String.valueOf(i);
        int length = s.length();
        java.lang.String substring = s.substring(length - 6);
        return substring;

    }

}
