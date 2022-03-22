package com.javasm.util;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/13-22:59
 * @Since:jdk1.8
 * @Description:
 */
public class BookUtil {
    public static String getBookStateStr(int state) {
        return state == 1 ? "已借出" : "未借出";
    }
}
