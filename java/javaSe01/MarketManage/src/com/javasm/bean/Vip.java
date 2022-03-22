package com.javasm.bean;

import lombok.*;

import java.util.Date;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/21-19:50
 * @Since:jdk1.8
 * @Description:会员
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Vip {
    Integer id;// 会员编号
    Integer cardnumber;//会员卡号
    String vipname;//会员姓名
    String iphone;//会员号码
    Integer jifen;// 会员积分
    Double money;//会员余额
    Date createTime;
    Date updateTime;
    Integer pwd;//会员密码
}
