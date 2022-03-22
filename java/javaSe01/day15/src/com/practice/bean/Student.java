package com.practice.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/15-19:24
 * @Since:jdk1.8
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String stuId;//学号
    private String stuName;//姓名
    private Integer stuAge;//年龄
    private String stuSex;//性别
    private String stuPhoneNum;//联系电话
}
