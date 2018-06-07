package com.cooperation.utils;

import java.math.BigDecimal;


public class MathUtil {
    /**
     * 1 计算两个数字字符串相加
     *
     * @param strFirst
     * @param StrSecond
     * @return
     */
    public static String addTwoNumStr(String strFirst, String StrSecond) {
        if (strFirst.equalsIgnoreCase("")) {
            strFirst = "0";
        }
        if (StrSecond.equalsIgnoreCase("")) {
            strFirst = "0";
        }
        // 通过BigDecimal将字符串转化成类型数值
        BigDecimal obj = new BigDecimal(strFirst);
        BigDecimal obj1 = new BigDecimal(StrSecond);
        return (obj.add(obj1).toString());
    }


    /**
     * 2 计算两个数字字符串相加,以传入参数的形式返回结果字符串
     *
     * @param strFirst
     * @param StrSecond
     * @param numinitial
     * @return
     */
    public static String addTwoNumStr(String strFirst, String StrSecond,
                                      String numinitial) {
        if (strFirst.equalsIgnoreCase("")) {
            strFirst = "0";
        }
        if (StrSecond.equalsIgnoreCase("")) {
            strFirst = "0";
        }
        // 通过BigDecimal将字符串转化成类型数值
        BigDecimal obj = new BigDecimal(strFirst);
        BigDecimal obj1 = new BigDecimal(StrSecond);
        String result = obj.add(obj1).toString();
        return (NumberUtil.formatStr(result, numinitial));
    }


    /**
     * 3 得到某个数的相反数
     *
     * @param numStr
     * @return
     */
    public static String strSign(String numStr) {
        if (!NumberUtil.isValide(numStr)) {
            numStr = "0";
        }
        BigDecimal obj1 = new BigDecimal(numStr);
        return (obj1.negate().toString());
    }


    /**
     * 4
     *  得到某个数的绝对值(得到某个BigDecimal实例的绝对值)
     *
     * @param numStr
     * @return
     */
    public static String strAbs(String numStr) {
        if (!NumberUtil.isValide(numStr)) {
            numStr = "0";
        }
        BigDecimal obj1 = new BigDecimal(numStr);
        return (obj1.abs().toString());
    }
    /**
     * 9
     * 两个数值字符串相乘，返回结果字符串
     *
     * @param numStr
     * @return
     */
    public static String multTwoNumStr(String numStr1,String numStr2) {
        BigDecimal obj1 = new BigDecimal(numStr1);
        BigDecimal obj2 = new BigDecimal(numStr2);
        BigDecimal result = obj1.multiply(obj2);
        return result.toString();
    }


    /**
     * 5 判断两个数是否相等：如果相等返回0，不相等返回-1
     *
     * @param strFirst
     * @param StrSecond
     * @return
     */
    public static int equals(String strFirst, String StrSecond) {
        BigDecimal obj = new BigDecimal(strFirst);
        BigDecimal obj1 = new BigDecimal(StrSecond);
        return obj.compareTo(obj1);
    }


    /**
     * 57 判断两个数是否相等：如果相等返回true，不相等返回false
     *
     * @param strFirst
     * @param StrSecond
     * @return
     */
    public static boolean isNumberEquals(String strFirst, String StrSecond) {
        BigDecimal obj = new BigDecimal(strFirst);
        BigDecimal obj1 = new BigDecimal(StrSecond);
        int res = obj.compareTo(obj1);
        if (res == 0) {
            return true;
        }
        if (res == -1) {
            return false;
        }
        return false;
    }


    /**
     * 6 数组数据求和
     *
     * @param number
     * @return
     */
    public static String sumNumberArrStr(String[] number) {
        BigDecimal sum = new BigDecimal("0.000");
        if (number != null) {
            for (int i = 0; i < number.length; i++) {
                sum = sum.add(new BigDecimal(number[i]));
            }
        }
        return sum.toString();
    }
    /**
     * 8
     * 比较两个字符串的大小，返回结果是较小的字符串，如果比较不出来返回第一个字符串
     * @param args
     */
    public static String compareTwoStrSmall(String firstStr, String secondStr) {
        if (firstStr.equals("")) {
            return secondStr;
        }
        if (secondStr.equals("")) {
            return firstStr;
        } else {
            BigDecimal obj1 = new BigDecimal(firstStr);
            BigDecimal obj2 = new BigDecimal(secondStr);
            int reti = obj1.compareTo(obj2);
            if (reti == -1) {
                return firstStr;
            } else if (reti == 0) {
                return firstStr;
            } else if (reti == 1) {
                return secondStr;
            } else {
                return firstStr;
            }


        }


    }

    /**
     * 10
     * 两个数字字符串相除，返回结果字符串，按照scale精度要求四舍五入
     * @param numStr1
     * @param numStr2
     * @param scale
     * @return
     */
    public static String divTwoNumStr(String numStr1,String numStr2,int scale) {
        BigDecimal obj1 = new BigDecimal(numStr1);
        BigDecimal obj2 = new BigDecimal(numStr2);
        //如果除数或被除数是0，结果返回是0
        if(!NumberUtil.isValide(numStr1)||!NumberUtil.isValide(numStr2)){
            return "0";
        }
        //如果除数是0，结果返回是0
        if(Double.parseDouble(numStr2)==0){
            return "0";
        }
        BigDecimal result = obj1.divide(obj2,scale,4);
        return result.toString();
    }




    public static void main(String[] args) {
        // 1
        System.out.println(addTwoNumStr("2", "4"));
        // 2
        System.out.println(addTwoNumStr("2", "44", "0.000000"));
        // 3
        System.out.println(strSign("20"));
        // 4
        System.out.println(strAbs("-20"));
        // 5
        System.out.println(equals("1", "1"));
        // 6
        System.out.println(sumNumberArrStr(new String[] { "1", "2", "3" }));
        // 7
        System.out.println(isNumberEquals("1", "2"));
        //8
        System.out.println(compareTwoStrSmall("11111","22222"));
        //9
        System.out.println(multTwoNumStr("11","11"));
        //10
        System.out.println(divTwoNumStr("20","4",2));
    }
}