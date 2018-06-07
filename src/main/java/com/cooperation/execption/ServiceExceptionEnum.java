package com.cooperation.execption;

/**
 * 异常抽象接口
 *
 * @Author: Alex isidea@outlook.com
 * @Date: Created in 14:04 2018/6/7
 */
public interface ServiceExceptionEnum {

    /**
     * 获取异常编码
     */
    Integer getCode();

    /**
     * 获取异常信息
     */
    String getMessage();

}
