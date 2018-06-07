package com.cooperation.utils.response;

/**
 * 返回码定义枚举类
 * @author Alex isidea@outlook.com
 * @version 2018年5月29日11:27:41
 */
public interface ResultCode {

    /**
     * 获取结果码code
     * @return 结果码
     */
    String getCode();

    void setCode(String errCode);

    /**
     * 获取描述信息
     * @return 描述信息
     */
    String getMessage();

    /**
     * 错误信息是否能透出到页面展示
     * @return boolean
     */
    boolean canView();

    void setMessage(String errMsg);
}