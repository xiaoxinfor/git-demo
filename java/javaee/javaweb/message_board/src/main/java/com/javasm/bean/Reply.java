package com.javasm.bean;

import lombok.Data;

import java.util.Date;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/21-19:24
 * @Since:jdk1.8
 * @Description:
 */
@Data
public class Reply {
    Integer rId;
    Integer dId;
    String rContent;
    Date rTime;
    Integer uId;
    String uName;
}
