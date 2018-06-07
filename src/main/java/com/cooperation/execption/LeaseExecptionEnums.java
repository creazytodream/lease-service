package com.cooperation.execption;

/**
 * 异常枚举
 *
 * @Author: Alex isidea@outlook.com
 * @Date: Created in 14:04 2018/6/7
 */
public enum LeaseExecptionEnums implements ServiceExceptionEnum {

    /**
     * 其他
     */
    WRITE_ERROR(500,"渲染界面错误"),

    /**
     * 错误的请求
     */
    REQUEST_NULL(400, "请求有错误"),
    SERVER_ERROR(500, "服务器异常");

    ;

    private Integer code;

    private String message;

    LeaseExecptionEnums(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
