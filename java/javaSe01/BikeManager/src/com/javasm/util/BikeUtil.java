package com.javasm.util;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/13-19:28
 * @Since:jdk1.8
 * @Description:
 */
public class BikeUtil {
    /**
     * 根据单车状态获取相应的文本
     *
     * @param state
     * @return
     */
    public static String getBikeStateStr(int state) {
        return state == 0 ? "已借出" : "可借出";
    }

    /**
     * 根据借出或归还的时间获取显示的信息
     *
     * @param time
     * @return
     */
    public static String getTimeStr(String time){
        return time == null ? "" : time;
    }
}
