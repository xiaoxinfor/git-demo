package com.javasm.dao;

import com.javasm.bean.Vip;

import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/22-16:02
 * @Since:jdk1.8
 * @Description:
 */
public interface VipDao {
    /**
     * 根据会员号查询信息
     *
     * @param cardNumber
     * @param <T>
     * @return
     */
    <T> T selectVipByCardNum(int cardNumber);

    /**
     * 查询所有会员信息
     *
     * @param <T>
     * @return
     */
    <T> List<T> selectVip();

    /**
     * 添加会员
     *
     * @param vip
     * @return
     */
    int addVip(Vip vip);

    /**
     * 修改会员
     *
     * @param vip
     * @return
     */
    int reviseVip(Vip vip);

    /**
     * 修改积分
     *
     * @param jifen
     * @return
     */
    int reviseVip(int jifen,int cardnumber);

    /**
     * 给会员余额充值
     *
     * @param cardnumber
     * @return
     */
    int chargeVip(double money, int cardnumber);

    /**
     * 删除会员
     *
     * @param cardNumber
     * @return
     */
    int deleteVip(int cardNumber);
}
