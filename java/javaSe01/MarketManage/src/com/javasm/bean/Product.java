package com.javasm.bean;

import lombok.*;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/21-19:47
 * @Since:jdk1.8
 * @Description:商品表
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
    Integer id;// 商品编号
    String productName;//商品名称
    Double price;//商品价格
    Integer num;//商品数量
    Integer discount;//商品折扣 1~10之间
    Integer typeid;//类型ID（外键）
    Integer state;//1为上架，2为下架，3为删除
}
