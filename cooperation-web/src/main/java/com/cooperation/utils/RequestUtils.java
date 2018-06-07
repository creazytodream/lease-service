package com.cooperation.utils;


import com.google.common.base.Strings;


import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


/**
 * Created by zhangzw on 2015/12/1.
 */
public class RequestUtils {


    /**
     * 获取request参数，封装到map中，并按key值排序
     * @param request
     * @return
     */
    public static TreeMap<String, String> getParameterMap(HttpServletRequest request){
        TreeMap<String, String> map = new TreeMap<String, String>();
        Enumeration<String> en = request.getParameterNames();
        while (en.hasMoreElements()) {
            String param = en.nextElement();
            String value = request.getParameter(param.toString());
            map.put(param, value);
        }
        return map;
    }


    /**
     * 解析queryString
     * @param queryString 请求参数字符串
     * @param enc		     编码
     * @return
     */
    public static Map<String, String> getParamsMap(String queryString, String enc) {
        Map<String, String> paramsMap = new TreeMap<String, String>();
        if (queryString != null && queryString.length() > 0) {
            int ampersandIndex, lastAmpersandIndex = 0, tmpIndex = 0;
            String subStr, param, value;
            do {
                ampersandIndex = queryString.indexOf('&', lastAmpersandIndex) + 1;
                if (ampersandIndex > 0) {
                    subStr = queryString.substring(lastAmpersandIndex, ampersandIndex - 1);
                    lastAmpersandIndex = ampersandIndex;
                } else {
                    subStr = queryString.substring(lastAmpersandIndex);
                }

                tmpIndex = subStr.indexOf('=');
                param = subStr.substring(0,tmpIndex);
                value = subStr.substring(tmpIndex+1);
                try {
                    value = URLDecoder.decode(value, enc);
                } catch (UnsupportedEncodingException ignored) {
                }
//                if (paramsMap.containsKey(param)) {
//                    values = (String[])paramsMap.get(param);
//                    int len = values.length;
//                    newValues = new String[len + 1];
//                    System.arraycopy(values, 0, newValues, 0, len);
//                    newValues[len] = value;
//                } else {
//                    newValues = new String[] { value };
//                }
                if(!"".equals(param))
                    paramsMap.put(param, value);
            } while (ampersandIndex > 0);
        }
        return paramsMap;
    }



    public static Map<String, String> getRequestMap(HttpServletRequest request){
        Map<String, String> paramsMap = new TreeMap<String, String>();
        paramsMap = getParameterMap(request);
        String queryString = request.getQueryString();
        if(!Strings.isNullOrEmpty(queryString)){
            paramsMap.putAll(getParamsMap(queryString, "utf-8"));
        }
        return paramsMap;
    }


    /**
     * 获取当前使用者ip
     *
     * @return
     */
    public static String getIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (null != ip && !"".equals(ip)) {
            String[] ips = ip.split(",");
            for (String s : ips) {
                if (!"unknown".equals(s)) {
                    ip = s;
                    break;
                }
            }
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip == null ? "" : ip;
    }





}
