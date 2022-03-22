package com.javasm.bean;

import lombok.*;

import java.util.Date;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/21-19:42
 * @Since:jdk1.8
 * @Description:商品类型表
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductType {
    Integer id;
    Integer parentId;//父级Id，0为没有父级Id
    String typeName;//类型名称
    Integer flagParent;// 是否为父级Id，1为是  0为不是
    Date createTime;
    Date updateTime;
}
