package com.cooperation.utils.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 实现描述：标准接口的JSON数据返回值
 *
 * @author Alex isidea@outlook.com
 * @version v1.0.0
 * @since 2018年5月29日11:23:36
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HttpResult implements Serializable {

    private static final long   serialVersionUID = 1L;

    public static final String  CORRECT_STATUS   = "OK";
    public static final String  ERROR_STATUS     = "FAILED";
    public static final String  ERROR_OVERTIME   = "OVERTIME";
    public static final String  DENY = "DENY";

    public static final String  STATUS_KEY       = "status";
    public static final String  CODE_KEY         = "errcode";
    public static final String  MSG_KEY          = "errmsg";

    private static final String DEFAULT_ERR_CODE = "0";

    /** 表示调用是否成功，成功为OK，失败为FAILED */
    private String              status;

    /** 业务数据 */
    private Object              data;

    /** 错误码，当调用出错时，此字段才会出现 */
    private String              errcode;

    /** 错误信息，输出出错码对应的出错信息 */
    private String              errmsg;

    /**
     * 生成一个标准的正确返回对象，{"ret": true}
     *
     * @return 标准正确返回对象，不带data值
     */
    public static HttpResult newCorrectResult() {
        HttpResult correctJsonObject = new HttpResult();
        correctJsonObject.setStatus(HttpResult.CORRECT_STATUS);
        return correctJsonObject;
    }

    /**
     * 生成一个标准的正确返回DTO，{"ret": true, "data": {JsonStringOfObject}}
     *
     * @param object 业务信息<Map>
     * @return
     */
    public static HttpResult newCorrectResult(Object object) {
        HttpResult correctJsonObject = HttpResult.newCorrectResult();
        correctJsonObject.setData(object);
        return correctJsonObject;
    }

    /**
     * 生成一个标准的错误返回DTO
     *
     * @param resultCode 错误码
     * @return HttpResult
     */
    public static HttpResult newErrorResult(ResultCode resultCode) {
        String errMsg = resultCode.canView() ? resultCode.getMessage()
            : DefaultResultCode.SYSTEM_EXCEPTION.getMessage();
        return newErrorResult(resultCode.getCode(), errMsg);
    }

    /**
     * 生成一个标准的错误返回DTO，{"ret": false,"errcode": code,"errmsg" : "msg"}
     *
     * @param code
     * @param msg
     * @return
     */
    public static HttpResult newErrorResult(String code, String msg) {
        HttpResult errorReturnObject = new HttpResult();
        errorReturnObject.setStatus(HttpResult.ERROR_STATUS);
        errorReturnObject.setErrcode(code);
        errorReturnObject.setErrmsg(msg);
        return errorReturnObject;
    }
    /**
     * 生成一个标准的错误返回DTO，{"ret": false,"errcode": code,"errmsg" : "msg"}
     *
     * @param code
     * @param msg
     * @return
     */
    public static HttpResult newErrorResult_(String code, String msg) {
    	HttpResult errorReturnObject = new HttpResult();
    	errorReturnObject.setStatus(HttpResult.ERROR_OVERTIME);
    	errorReturnObject.setErrcode(code);
    	errorReturnObject.setErrmsg(msg);
    	return errorReturnObject;
    }

    /**
     * 生成一个标准的错误返回DTO，{"ret": false,"errmsg" : "msg"}
     *
     * @param msg
     * @return
     */
    public static HttpResult newErrorResult(String msg) {
        return HttpResult.newErrorResult(HttpResult.DEFAULT_ERR_CODE, msg);
    }

    /**
     * 添加 Key—Value 条目到 data 里，data 如果不是 map 结构则出错
     *
     * @param key
     * @param value
     * @return
     */
    public HttpResult putEntry(String key, Object value) {
        if (StringUtils.isBlank(key)) {
            return this;
        }

        if (this.data == null) {
            this.data = new HashMap<String, Object>();
        }

        boolean isMapStructure = (this.data instanceof Map);
        if (!isMapStructure) {
            throw new RuntimeException("Can't put k-v into not-map data");
        }

        ((Map<String, Object>) data).put(key, value);
        return this;
    }

    public static void main(String[] args) {
        HttpResult httpResult = HttpResult.newErrorResult("406","【保存约单失败】:");
        System.out.println(httpResult);
    }

    /** -----------------setter/getter--------------------- **/
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /** -----------------equals/hashCode--------------------- **/

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
