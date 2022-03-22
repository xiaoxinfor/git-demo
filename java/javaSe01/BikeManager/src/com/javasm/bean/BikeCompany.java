package com.javasm.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/13-15:58
 * @Since:jdk1.8
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BikeCompany {
    private String  bikeCompany;//公司名称
    private Integer companyId;//公司ID
    private Bike[] bikes;//公司持有单车
    private Integer sum;//公司单车总量
    private Integer count;//单车借出次数
}
