package com.javasm.bean;

import lombok.*;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/22-17:45
 * @Since:jdk1.8
 * @Description:
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ShopCar {
    Integer productid;//商品ID [引用商品表]
    String productName;//商品名称
    Double price;// 商品原价
    Integer discount;// 折扣
    Integer num;// 商品购买数量
    Double prices;//小计（原价*折扣*数量）
}
