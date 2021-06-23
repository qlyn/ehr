package com.sql.ehr.util;

public class StringUtils {
    //判断字符串是否为空
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }
    //判断字符
    public static boolean isBlank(String str) {
        int strLen;
        if (str != null && (strLen = str.length()) != 0) {
            for(int i = 0; i < strLen; ++i) {
                // 判断字符是否为空格、制表符、tab
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return true;
        }
    }
}
