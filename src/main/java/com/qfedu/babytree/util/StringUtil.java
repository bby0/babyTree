package com.qfedu.babytree.util;

/**
 *@Author feri
 *@Date Created in 2018/11/29 17:23
 */
public class StringUtil {
    public static boolean checkEmpty(String... values){
        boolean r=false;
        for(String v:values){
            if(!(v!=null && v.length()>0)){
                r=true;
            }
        }
        return r;
    }
    public static boolean checkNoEmpty(String... values){
        boolean r=true;
        for(String v:values){
            if(!(v!=null && v.length()>0)){
                r=false;
            }
        }
        return r;
    }
}
