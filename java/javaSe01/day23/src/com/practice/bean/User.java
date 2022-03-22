package com.practice.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/17-20:03
 * @Since:jdk1.8
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String uName;
    private String sex;
    private String phone;
    private String address;
    private String createTime;
}
