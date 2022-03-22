package com.javasm.practice.practice5.bean;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.date.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/13-10:35
 * @Since:jdk1.8
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    //用户编号
    private Integer id;
    //用户密码
    private String pwd;
    //密码加密版
    private String encoderPwd;
    //身份证号
    private String idCard;
    //身份证号加密
    private String encodIdCard;
    //注册时间
    private String regTime;
    //自动增长
    public static int indentityId = 1000;

    public User(String name,String pwd, String idCard){
        this.id = indentityId++;
        this.name = name;
        this.pwd = pwd;
        this.encoderPwd = Base64.encode(pwd);//加密密码
        this.idCard = idCard;
        this.encodIdCard = Base64.encode(idCard);//加密身份证
        this.regTime = DateUtil.now();
    }
}
