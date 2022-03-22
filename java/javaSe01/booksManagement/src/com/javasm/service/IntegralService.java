package com.javasm.service;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/7-16:01
 * @Since:jdk1.8
 * @Description:
 */
public interface IntegralService {
    void show();

    /**
     * 验证会员号
     * @param memberId
     * @return
     */
    boolean yanZheng(int memberId);

    void getGift(int giftId,int memberId);
}
