package com.javasm.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/13-16:00
 * @Since:jdk1.8
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bike {
    private Integer bikeId;//单车编号
    private String bikeName;//单车名称--》ofo 摩拜 哈罗
    private Integer status;//单车状态：0已借出  1可借状态
    private String borrowTime;//单车借出时间
    private String returnTime;//单车归还时间

}
