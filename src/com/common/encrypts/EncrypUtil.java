package com.common.encrypts;

import java.util.List;
import java.util.Map;

public class EncrypUtil {

	public final static String ENCRYPT_METHOD_DES = "des";

	private static String KEY1 = "";
	private static String KEY2 = "";

	public static String genCheckValue(String method,
			Map<String, String> params, List<String> checkFields)
			throws Exception {
		Encrypt e = EncryptFactory.createEncrypt(method,
				DesEncrypt.TYPE_3DES_CBC, KEY1, KEY2);
		return e.encrypt(genCheckString(params, checkFields)).trim();
	}

	public static String genCheckString(Map<String, String> params,
			List<String> checkFields) {
		StringBuffer sb = new StringBuffer();
		if (null != checkFields && !checkFields.isEmpty()) {
			for (String checkField : checkFields) {
				String fieldValue = params.get(checkField);
				sb.append(fieldValue);
			}
		}
		return sb.toString();
	}

}
