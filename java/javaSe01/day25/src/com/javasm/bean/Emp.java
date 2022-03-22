package com.javasm.bean;

import lombok.*;

import java.util.Date;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/21-10:18
 * @Since:jdk1.8
 * @Description:
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Emp {
    private Integer empId;
    private String empName;
    private String empAct;
    private Integer empPwd;
    private Integer deptId;
    private String empSex;
    private Date joinTime;

    //部门名称
    private String deptName;
    //打卡表编号，打卡时间，打卡状态
    private Integer id;
    private Date signTime;
    private Integer isSign;
}
