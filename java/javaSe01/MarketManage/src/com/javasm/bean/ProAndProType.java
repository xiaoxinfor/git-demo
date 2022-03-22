package com.javasm.bean;

import lombok.*;

import java.util.Date;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/22-12:34
 * @Since:jdk1.8
 * @Description:
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProAndProType {
    Integer id;// 商品编号
    String productName;//商品名称
    Double price;//商品价格
    Integer num;//商品数量
    Integer discount;//商品折扣 1~10之间
    Integer typeid;//类型ID（外键）
    Integer state;//1为上架，2为下架，3为删除

    Integer parentId;//父级Id，0为没有父级Id
    String typeName;//类型名称
    Integer flagParent;// 是否为父级Id，1为是  0为不是
    Date createTime;
    Date updateTime;
}
