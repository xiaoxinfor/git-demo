package com.javasm.bean;

import lombok.*;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/21-19:55
 * @Since:jdk1.8
 * @Description:订单详情表（小票）
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Orderdetails {
    Integer id;//序号
    Integer orderid;//订单ID [引用订单表]
    Integer productid;//商品ID [引用商品表]
    Double price;//商品原价
    Integer discount;//折扣
    Integer num;//商品购买数量
    Double prices;//小计（原价*折扣*数量）
}
