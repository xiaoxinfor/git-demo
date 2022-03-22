package com.javasm.bean;

import lombok.*;

import java.util.Date;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/21-19:52
 * @Since:jdk1.8
 * @Description:订单信息表
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Orderinfo {
    Integer id;//订单序号
    Integer vipid;// 会员id{非会员：1000}
    double allPrice;//订单合计
    Date orderdate;//支付时间
    Integer paytype;//订单支付方式，1：现金，2：卡内余额
}
