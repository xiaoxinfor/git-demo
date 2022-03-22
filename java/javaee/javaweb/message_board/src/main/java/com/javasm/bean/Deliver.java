package com.javasm.bean;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/20-16:07
 * @Since:jdk1.8
 * @Description:
 */
@Data
public class Deliver {
    Integer dId;
    String dTitle;
    String dContent;
    Date dTime;
    Integer uId;
}
