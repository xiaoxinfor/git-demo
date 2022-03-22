package com.javasm.bean;

import lombok.*;

import java.util.Date;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/23-15:12
 * @Since:jdk1.8
 * @Description:
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {

    Integer vipid;// 会员id{非会员：1000}
    Double allPrice;//订单合计
    Date orderdate;//支付时间
    Integer paytype;//订单支付方式，1：现金，2：卡内余额

    String productName;

    Integer orderid;//订单ID [引用订单表]
    Integer productid;//商品ID [引用商品表]
    Double price;//商品原价
    Integer discount;//折扣
    Integer num;//商品购买数量
    Double prices;//小计（原价*折扣*数量）
}
