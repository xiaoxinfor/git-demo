package com.javasm.utils;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/23-16:55
 * @Since:jdk1.8
 * @Description:
 */
public class StateUtils {
    public static String zhuan(int state){
        if (state == 1){
            return "上架";
        }
        if (state == 2){
            return "下架";
        }
        return "删除";
    }

    public static String payType(int pay){
        if (pay == 1){
            return "现金支付";
        }
        if (pay == 2){
            return "会员余额支付";
        }
        return "积分兑换抽奖";
    }
}
