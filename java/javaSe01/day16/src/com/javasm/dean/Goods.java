package com.javasm.dean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/17-17:31
 * @Since:jdk1.8
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {
    private Integer id;//商品编号
    private String name;//商品名称
    private Integer price;//价格
    private Integer count;//库存


}
