package com.common.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;


/**
 * 字符串相关方法
 * 
 */
public class StringUtil {
	/**
	 * @Title: IntList
	 * @Description: 将以逗号分隔的字符串转换成字符串数组
	 * @param valStr
	 * @return Integer[] 返回类型
	 * @throws
	 */
	public static Integer[] IntList(String valStr) {
		String[] s = valStr.split(",");
		Integer[] a = new Integer[s.length];
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.valueOf(s[i]);
		}
		return a;
	}

	/**
	 * @Title: firstCharUpperCase
	 * @Description: 首字母大写
	 * @param s
	 *            需要改变的字符串
	 * @return String 返回类型
	 * @throws
	 */
	public static String firstCharUpperCase(String s) {
		StringBuffer sb = new StringBuffer(s.substring(0, 1).toUpperCase());
		sb.append(s.substring(1, s.length()));
		return sb.toString();
	}

	/**
	 * @Title: firstCharLowerCase
	 * @Description: 首字母小写
	 * @param s
	 *            需要改变的字符串
	 * @return String 返回类型
	 * @throws
	 */
	public static String firstCharLowerCase(String s) {
		StringBuffer sb = new StringBuffer(s.substring(0, 1).toLowerCase());
		sb.append(s.substring(1, s.length()));
		return sb.toString();
	}

	/**
	 * @Title: getBase64
	 * @Description: Base64加密
	 * @param str
	 * @return String
	 * @throws
	 */
	public static String getBase64(String str) {
		byte[] b = null;
		String s = null;
		try {
			b = str.getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (b != null) {
			s = new BASE64Encoder().encode(b);
		}
		return s;
	}

	// 解密
	/**
	 * @Title: getFromBase64
	 * @Description: Base64解密
	 * @param s
	 * @return String 返回类型
	 * @throws
	 */
	public static String getFromBase64(String s) {
		byte[] b = null;
		String result = null;
		if (s != null) {
			BASE64Decoder decoder = new BASE64Decoder();
			try {
				b = decoder.decodeBuffer(s);
				result = new String(b, "utf-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * @Title: SHA1
	 * @Description: sha1 加密
	 * @param decript
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public static String SHA1(String decript) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest digest = java.security.MessageDigest.getInstance("SHA-1");
		digest.reset();
		digest.update(decript.getBytes("UTF-8"));
		byte messageDigest[] = digest.digest();
		// Create Hex String
		String signature = byteToHex(messageDigest);
		return signature;

	}

	private static String byteToHex(final byte[] hash) {
		Formatter formatter = new Formatter();
		for (byte b : hash) {
			formatter.format("%02x", b);
		}
		String result = formatter.toString();
		formatter.close();
		return result;
	}

	/**
	 * @Fields key0 : 对称加密秘钥
	 */
	private static final String key0 = "FECOI()*&<MNCXZPKL";

	/**
	 * @Title: DeEnCodeEncode
	 * @Description: 对称加密
	 * @param enc
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String DeEnCodeEncode(String enc) throws UnsupportedEncodingException {
		byte[] keyBytes = key0.getBytes("UTF-8");
		byte[] b = enc.getBytes("UTF-8");
		for (int i = 0, size = b.length; i < size; i++) {
			for (byte keyBytes0 : keyBytes) {
				b[i] = (byte) (b[i] ^ keyBytes0);
			}
		}
		return new String(b);
	}

	/**
	 * @Title: DeEnCodeDecode
	 * @Description: 对称解密
	 * @param dec
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String DeEnCodeDecode(String dec) throws UnsupportedEncodingException {
		byte[] keyBytes = key0.getBytes("UTF-8");
		byte[] e = dec.getBytes("UTF-8");
		byte[] dee = e;
		for (int i = 0, size = e.length; i < size; i++) {
			for (byte keyBytes0 : keyBytes) {
				e[i] = (byte) (dee[i] ^ keyBytes0);
			}
		}
		return new String(e);
	}
	
	/** 
	* @Title: UrlEncoder 
	* @Description: 字符串编码
	* @param sStr
	* @return  
	*/
	public final static String UrlEncoder(String sStr, String sEnc){
		String sReturnCode = "";
		try{
			sReturnCode = URLEncoder.encode(sStr, sEnc);
		}catch (Exception ex){
		}
		return sReturnCode;
	}
	
	/** 
	* @Title: UrlDecoder 
	* @Description: 字符串解码 
	* @param sStr
	* @return  
	*/
	public static String UrlDecoder(String sStr){
        if(isEmpty(sStr)){
        	return "";
        }else{
        	String sReturnCode = sStr;
        	try {
                sReturnCode = URLDecoder.decode(sStr, "utf-8");
            } catch (Exception e) {
            }
            return sReturnCode;
        }
    }
	
	/**
	 * 判断字符串是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (str == null || "".equals(str)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 判断字符串是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(Object obj) {
		if (obj == null || "".equals(obj.toString())) {
			return true;
		}
		return false;
	}
	    
	    
	/**
	 * 判断字符串是否不为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		if (str == null || "".equals(str)) {
			return false;
		}
		return true;
	}
	
	/**
	 * 方法说明: 对输入的字符串进行转换，如果非空，去除前后空格，如果为空，返回空字符串
	 * @param str
	 * @return
	 */
	public static String isNull(String str) {
		if (str == null) {
			return "";
		}
		return str.trim();
	}
	

	/**
	 * 方法说明：对身份证号处理(保留前5位，后4位，中间用4个*代替)
	 * @param cardId
	 * @return
	 */
	public static String dealCardIdInfo(String cardId){
		if(isNotEmpty(cardId)){
			StringBuffer strBuffer = new StringBuffer();
			strBuffer.append(cardId.substring(0,5));
			strBuffer.append("****");
			strBuffer.append(cardId.substring(cardId.length()-4,cardId.length()));
			return strBuffer.toString();
		}else{
			return "";
		}
	}
	
	/**
	 * 方法说明: 判断输入的字符是否为11位纯数字
	 * @param phone
	 * @return
	 */
	public static boolean isElevenNums(String phone) {
		phone = isNull(phone);
		Pattern isIDCard1=Pattern.compile("\\d{11}$"); 
		Matcher matcher= isIDCard1.matcher(phone);
		return matcher.matches();
	}
	

	
	public static String isNull(Object o) {
		if (o == null) {
			return "";
		}
		String str="";
		if(o instanceof String){
			str=(String)o;
		}else{
			str=o.toString();
		}
		return str;
	}
	
	/**
	 * 
	 * 方法说明: 将按照一定分隔符分隔的字符串转成List<String>
	 * @param str 目标字符串
	 * @param separator 分隔符，如道号、分号、问号等等
	 * @return
	 */
	public static List<String> getListFromStr(String str, String separator){
		List<String> list = new ArrayList<String>();
		if(str == null || "".equals(str)){
			return list;
		}
		if(separator == null || "".equals(separator)){
			list.add(str);
			return list;
		}
		String[] strs = str.split(separator);
		for (String string : strs) {
			list.add(string);
		}
		return list;
	}
	
	/**
	 * 
	* @Title: getStr 
	* @Description: 获取对象的字符串，如果对象为空则返回空字符串
	* @param obj
	* @return
	 */
	public static String getStr(Object obj){
		if(obj == null || "".equals(obj.toString())){
			return "";
		} else {
			return obj.toString();
		}
	}
	
	/** 
	* @Title: makeOldRemarkClean 
	* @Description: 将老的 log 记录中的remark链接去除掉 
	* @param @param oldRemark
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	public static String cleanOldRemark(String oldRemark) {
	    final Pattern pattern = Pattern.compile("<a[^>]*>");
	    Matcher matcher = pattern.matcher(oldRemark);
	    return matcher.replaceAll("").replaceAll("</a>", "");
	}

    /** 
    * @Title: compare 
    * @Description: 比较两个字符串 
    * @param @param l
    * @param @param r
    * @param @return    设定文件 
    * @return boolean    返回类型 
    * @throws 
    */
    public static boolean isEqual(String l, String r) {
        if (l == r) {
            return true;
        }

        return (null!=l?l:r).equals(null!=l?r:l);
    }
    
    public static List<Integer> getIntList(String str){
    	List<Integer> list = new ArrayList<>();
    	if(str == null || "".equals(str)){
    		return list;
    	}
    	String[] strs = str.split(",");
    	for (String s : strs) {
    		if(!"".equals(s)){
    			list.add(Integer.parseInt(s));
    		}
			
		}
		return list;
    }
    
    public static void main(String[] args) {
		String s = ",11,17";
		getIntList(s);
	}

    public static String madeAgreementNo(String type,String date,int numb,int endNum){
        if (numb<10) {
            return type+date+"000"+numb+endNum;
        }else if(numb<100){
            return type+date+"00"+numb+endNum;
        }else if (numb<1000) {
            return type+date+"0"+numb+endNum;
        }else{
            return type+date+numb+endNum;
        }
    }

}
