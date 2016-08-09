package com.common.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;


public class NumberUtils {
	
	 /**
     * 此方法遇到到5 舍去
     * @param d
     * @return
     */
    public static BigDecimal format2(BigDecimal big) {
        // 四舍六入五考虑，五后非零就进一，五后皆零看奇偶，五前为偶应舍去，五前为奇要进一
        big = big.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        return big;
    }
    
    /**
     * 此方法遇到到5 舍去
     * @param d
     * @return
     */
    public static double format2(double d) {
        // 四舍六入五考虑，五后非零就进一，五后皆零看奇偶，五前为偶应舍去，五前为奇要进一
        BigDecimal big = BigDecimal.valueOf(d);
        big = big.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        return big.doubleValue();
    }
    
    /**
     * 此方法遇到到5 舍去
     * @param d
     * @return
     */
    public static BigDecimal formatBigDecimal2(double d) {
        // 四舍六入五考虑，五后非零就进一，五后皆零看奇偶，五前为偶应舍去，五前为奇要进一
        BigDecimal big = BigDecimal.valueOf(d);
        big = big.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        return big;
    }
    
    /**
     * 此方法遇到到5 舍去
     * @param d
     * @return
     */
    public static double formatTo2(double d) {
        DecimalFormat df = new DecimalFormat("0.00");
        String ds = df.format(d);
        return Double.parseDouble(ds);
    }
    
    /**
     * 此方法遇到到5入
     * @param d
     * @return
     */
    public static double formatup2(double d) {
        BigDecimal big = BigDecimal.valueOf(d);
        big = big.setScale(2, BigDecimal.ROUND_HALF_UP);
        return big.doubleValue();
    }
    
    /**
     * 此方法遇到保留两位，直接入,没有舍
     * @param d
     * @return
     */
    public static double getDoubleFormat2Up(double d) {
        BigDecimal big = BigDecimal.valueOf(d);
        big = big.setScale(2, BigDecimal.ROUND_HALF_UP);
        return big.doubleValue();
    }

    public static String format0Str(double d) {
        DecimalFormat df = new DecimalFormat("0");
        String ds = df.format(d);
        return ds;
    }
    
    public static String format2Str(double d) {
        DecimalFormat df = new DecimalFormat("0.00");
        String ds = df.format(d);
        return ds;
    }
    
   /**
    * 保留两位小数
    * @param d
    * @return
    */
   public static String format2Str(BigDecimal d) {
	    if(d == null){
	    	return "0.00";
	    }
        DecimalFormat df = new DecimalFormat("0.00");
        String ds = df.format(d);
        return ds;
    }
    public static String format3Str(double d) {
        DecimalFormat df = new DecimalFormat("0.000");
        String ds = df.format(d);
        return ds;
    }

    public static double format4(double d) {
        DecimalFormat df = new DecimalFormat("0.0000");
        String ds = df.format(d);
        return Double.parseDouble(ds);
    }

    public static double format6(double d) {
        DecimalFormat df = new DecimalFormat("0.000000");
        String ds = df.format(d);
        return Double.parseDouble(ds);
    }


    public static double getNormalDouble(String str) {
        if (str == null || str.equals(""))
            return 0.0;
        double ret = 0.0;
        try {
            ret = Double.parseDouble(str);
        } catch (NumberFormatException e) {
            ret = 0.0;
        }
        return ret;
    }
    

    public static Long[] getLongs(String[] str) {

        if (str == null || str.length < 1)
            return new Long[] { 0L };
        Long[] ret = new Long[str.length];
        for (int i = 0; i < str.length; i++) {
            ret[i] = getLong(str[i]);
        }
        return ret;
    }
    //v1.8.0.4_u4  TGPROJECT-353  qinjun  2014-07-03   start
    public static Double[] getDoubles(String[] str) {
        if (str == null || str.length < 1)
            return new Double[] { 0d };
        Double[] ret = new Double[str.length];
        for (int i = 0; i < str.length; i++) {
            ret[i] = getDouble(str[i]);
        }
        return ret;
    }
    //v1.8.0.4_u4  TGPROJECT-353  qinjun  2014-07-03   start
    public static int[] getInts(String[] str) {

        if (str == null || str.length < 1)
            return new int[] { 0 };
        int[] ret = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            ret[i] = getInt(str[i]);
        }
        return ret;
    }

    public static Integer[] getIntegers(String[] str) {

        if (str == null || str.length < 1)
            return new Integer[] { 0 };
        Integer[] ret = new Integer[str.length];
        for (int i = 0; i < str.length; i++) {
            ret[i] = getInt(str[i]);
        }
        return ret;
    }

    public static int compare(double x, double y) {
        BigDecimal val1 = new BigDecimal(x);
        BigDecimal val2 = new BigDecimal(y);
        return val1.compareTo(val2);
    }

    /**
     * @param d
     * @param len
     * @return
     */
    public static double ceil(double d, int len) {
        String str = Double.toString(d);
        int a = str.indexOf(".");
        if (a + 3 > str.length()) {
            a = str.length();
        } else {
            a = a + 3;
        }
        str = str.substring(0, a);
        return Double.parseDouble(str);
    }

    public static double ceil(double d) {
        return ceil(d, 2);
    }

    public static long getRandom(int len) {
        double r = Math.random();
        for (int i = 0; i < len; i++) {
            r = r * 10;
        }
        long ret = (long) r;
        return ret;
    }

    /**
     * 用于两个小数相减，使用bigdecimai计算，避免出现误差
     * 
     * @param num1
     * @param num2
     * @return
     */
    public static double subtract(double num1, double num2) {

        BigDecimal numa = new BigDecimal(num1 * 100000);
        BigDecimal numb = new BigDecimal(num2 * 100000);
        double result = numa.subtract(numb).doubleValue() / 100000;
        return result;
    }

    public static double add(double num1, double num2) {

        BigDecimal numa = new BigDecimal(num1 * 100000);
        BigDecimal numb = new BigDecimal(num2 * 100000);
        double result = numa.add(numb).doubleValue() / 100000;
        return result;
    }

    public static double getDouble2(String numStr) {
        double num = NumberUtils.getDouble(numStr);
        return format2(num);
    }
    
    public static BigDecimal getBigDecimal2(String numStr) {
        double num = NumberUtils.getDouble(numStr);
        return formatBigDecimal2(num);
    }
    
    //v1.8.0.4_u4  TGPROJECT-353  qinjun  2014-07-03   start
    /**
     * 小数点后有则进1
     * @param num
     * @return
     */
    public static int getIntWithDouble(double num){
        long num2 =getLong(String.valueOf(num).replaceAll("\\d+\\.", ""));
        if(num2>0){
             return (int)num+1;
        }
        return getInt((int)num+"");
    }
    //v1.8.0.4_u4  TGPROJECT-353  qinjun  2014-07-03   end
    
    public static String formatThousandSep(Double num1) {
        DecimalFormat df = null;
        if(num1!=null && num1!=0){
            df = new DecimalFormat("#,###.00");
        }else{
            df = new DecimalFormat("#,###");
        }
        String result = df.format(num1);
        return result;
    }
    
    public static String formatThousandSep(Long num1) {
        DecimalFormat df = new DecimalFormat("#,###");
        String result = df.format(num1);
        return result;
    }
    
    public static String formatThousandSep(Integer num1) {
        DecimalFormat df = new DecimalFormat("#,###");
        String result = df.format(num1);
        return result;
    }
    
    /**
     * 
     * 方法说明: 判断字符串是否是数值
     * @param value
     * @return
     */
    public static boolean isNumber(String value){
        if(value == null){
            return false;
        }
        try{
            Double.parseDouble(value);
        } catch (Exception e){
            return false;
        }
        return true;
    }
    
    /**
     * 
     * 方法说明: 判断字符串是否是整形数值
     * @param value
     * @return
     */
    public static boolean isIntegerNumber(String value){
    	if(value == null){
    		return false;
    	}
    	try{
    		Integer.parseInt(value);
    	} catch (Exception e){
    		return false;
    	}
    	return true;
    }
    
    /**
     * 
     * 方法说明: 返回两位小数
     * @param num
     * @return
     */
    public static Double get2DecimalPalces(Double num){
        if(num == null){
            return new Double(0);
        }
        DecimalFormat df=new DecimalFormat(".##");
        return Double.parseDouble(df.format(num));
    }
    
    public static void main(String[] args) {
        System.out.println(format2Str(1000));
    }
    
    /**
     * 计算投标进度百分比 保留整数位
     * @param accountYes 已投金额
     * @param account 标总额
     * @return 整数百分比
     */
    public static BigDecimal getScale(BigDecimal accountYes, BigDecimal account){
        BigDecimal scale = null;
        try {
            scale = accountYes.multiply(new BigDecimal(100))
                    .divideToIntegralValue(account);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scale;
    }
    
    /**
     * 方法说明: 格式化转换double型数值
     * @param d
     * @param format
     * @return
     */
    public static double format(double d, String format) {
        DecimalFormat df = new DecimalFormat(format);
        String ds = df.format(d);
        return Double.parseDouble(ds);
    }

    /**
     * 方法说明: 将字符串转换为double型数值
     * @param str
     * @return
     */
    public static double getDouble(String str) {
        if (str == null || str.equals(""))
            return 0.0;
        double ret = 0.0;
        try {
            ret = Double.parseDouble(str);
        } catch (NumberFormatException e) {
            ret = 0.0;
        }
        return ret;
    }
    
    /**
     * 方法说明: 将字符串转换为Long型数值
     * @param str
     * @return
     */
    public static long getLong(String str) {
        if (str == null || str.equals(""))
            return 0L;
        long ret = 0;
        try {
            ret = Long.parseLong(str);
        } catch (NumberFormatException e) {
            ret = 0;
        }
        return ret;
    }

    /**
     * 方法说明: 将字符串转换为int型数值
     * @param str
     * @return
     */
    public static int getInt(String str) {
        if (str == null || str.equals(""))
            return 0;
        int ret = 0;
        try {
            ret = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            ret = 0;
        }
        return ret;
    }
    
    public static int getInt(Object obj) {
        if (obj == null || obj.toString().equals(""))
            return 0;
        int ret = 0;
        try {
            ret = Integer.parseInt(obj.toString());
        } catch (NumberFormatException e) {
            ret = 0;
        }
        return ret;
    }
    
    public static int getIntNullToMinusOne(Object obj) {
        if (obj == null || obj.toString().equals(""))
            return -1;
        int ret = 0;
        try {
            ret = Integer.parseInt(obj.toString());
        } catch (NumberFormatException e) {
            ret = -1;
        }
        return ret;
    }
    
    /**
     * 方法说明: 判断输入的数值是否为空或者0
     * @param num
     * @return
     */
    public static boolean isNullOrZero(Integer num){
        if(num==null || num==0){
            return true;
        }else{
            return false;
        }
    }

    /** 
    * @Title: isNullOrZero 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param bdec
    * @param @return    设定文件 
    * @return boolean    返回类型 
    * @throws 
    */
    public static boolean isNullOrZero(BigDecimal bdec) {
        if (null == bdec) {
            return true;
        }
        return bdec.compareTo(new BigDecimal(0))==0;
    }
    
    /**
     * 
    * @Title: getTenThousand 
    * @Description: 将一个数值转换为已万为单位显示,四舍五入保留两位小数
    * @param obj
    * @return
     */
    public static double getTenThousand(Object obj){
    	double num = 0;
    	if(obj == null){
    		return 0;
    	}
    	try{
    		num = Double.parseDouble(obj.toString());
    	} catch (Exception e){
    		return 0;
    	}
		return formatup2(num/10000);
    }

}
