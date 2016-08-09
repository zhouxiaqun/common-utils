package com.common.encrypt;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;


public class Des3 {
	
	 // �ӽ���ͳһʹ�õı��뷽ʽ
    private final static String encoding = "utf-8";

    /**
     * 3DES����
     * 
     * @param plainText
     *            ��ͨ�ı�
     * @return
     * @throws Exception
     */
    public static String encode(String plainText, String appkey, String secret) throws Exception {
        Key deskey = null;
        DESedeKeySpec spec = new DESedeKeySpec(appkey.getBytes());
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
        deskey = keyfactory.generateSecret(spec);

        Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
        IvParameterSpec ips = new IvParameterSpec(secret.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);
        byte[] encryptData = cipher.doFinal(plainText.getBytes(encoding));
        return Base64.encode(encryptData);
    }

    /**
     * 3DES����
     * 
     * @param encryptText
     *            �����ı�
     * @return
     * @throws Exception
     */
    public static String decode(String encryptText, String appkey, String secret) throws Exception {
        Key deskey = null;
        DESedeKeySpec spec = new DESedeKeySpec(appkey.getBytes());
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
        deskey = keyfactory.generateSecret(spec);
        Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
        IvParameterSpec ips = new IvParameterSpec(secret.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, deskey, ips);

        byte[] decryptData = cipher.doFinal(Base64.decode(encryptText));

        return new String(decryptData, encoding);
    }

}
