package com.practice2.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/15-21:16
 * @Since:jdk1.8
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Poker {
    //花色，大小王
    private String colors;
    //牌面
    private String valus;
}
