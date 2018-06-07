package com.cooperation.utils.response;

/**
 * 缺省的返回码定义实现
 * @author Alex isidea@outlook.com
 * @version 2018年5月29日11:30:20
 */
public enum DefaultResultCode implements ResultCode {

    /**
     * 系统相关
     */
    EMPTY_PARAMS("COM001","参数错误",true),
    SYSTEM_EXCEPTION("COM500","SYSTEM_EXCEPTION",false),

    /**
     * 用户相关
     */
    USER_NULL("COM404","用户不存在",true),
    USER_ERROE("COM400","用户密码错误",true),
    USER_ACTIVATION("COM500","用户状态不可用",true),
    ;

    /** 错误码code*/
    private String code;
    /** 错误码描述*/
    private String message;

    /** 是否能透出到页面展示 */
    private Boolean canView;

    /**
     * @param code 错误码
     * @param message 描述信息
     */
    private DefaultResultCode(String code, String message, boolean canView) {
        this.code = code;
        this.message = message;
        this.canView = canView;
    }

    /**
     * Setter method for property <tt>code</tt>.
     *
     * @param code value to be assigned to property code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Setter method for property <tt>desc</tt>.
     *
     * @param message value to be assigned to property message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @see ResultCode#getCode()
     */
    public String getCode() {
        return this.code;
    }

    /**
     * @see ResultCode#getMessage()
     */
    public String getMessage() {
        return this.message;
    }

    public boolean canView(){
        return canView;
    }

    public void setCanView(){
        this.canView = canView;
    }
}