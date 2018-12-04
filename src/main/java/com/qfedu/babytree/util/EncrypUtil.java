package com.qfedu.babytree.util;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.crypto.hash.SimpleHash;

import java.security.Key;

/**
 *@Author feri
 *@Date Created in 2018/7/9 14:31
 */
public class EncrypUtil {
    public static String salt="laoxing";
    //encBase64
    public static String encBase64(byte[] value){
        return Base64.encodeToString(value);
    }
    //decBase64
    public static String decBase64(String value){
        return Base64.decodeToString(value.getBytes());
    }
    public static byte[] decBase64Arr(String value){
        return Base64.decode(value.getBytes());
    }

    //md5摘要
    public static String md5(String pass,String salt,int count){
        SimpleHash hash=new SimpleHash("md5",pass,salt,count);
        return hash.toString();
    }
    //md5摘要
    public static String md5Pass(String pass){
        SimpleHash hash=new SimpleHash("md5",pass,salt,128);
        return hash.toString();
    }
    //md5摘要
    public static String md5Pass(String s,String pass){
        SimpleHash hash=new SimpleHash("md5",pass,s,128);
        return hash.toString();
    }
    //aes
    public static Key getAesKey(){
        AesCipherService service=new AesCipherService();
        service.setKeySize(128);
        return service.generateNewKey();
    }
    //秘钥采用Base64转换
    public static String createAesKey(){
        AesCipherService service=new AesCipherService();
        service.setKeySize(128);
        return encBase64(service.generateNewKey().getEncoded());
    }
    //aes 加密
    public static String encAesStr(String key,String value){
        return new AesCipherService().encrypt(value.getBytes(),decBase64Arr(key)).toBase64();
    }
    //aes 解密
    public static String decAesStr(String key,String value) {
        return new String(new AesCipherService().decrypt(Base64.decode(value),decBase64Arr(key)).getBytes());
    }
    //aes 加密
    public static String encAes(Key key,String value){
        return new AesCipherService().encrypt(value.getBytes(),key.getEncoded()).toBase64();
    }
    //aes 解密
    public static String decAes(Key key,String value) {
        return new String(new AesCipherService().decrypt(Base64.decode(value), key.getEncoded()).getBytes());
    }
}
