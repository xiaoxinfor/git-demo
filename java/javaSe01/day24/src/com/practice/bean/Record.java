package com.practice.bean;

import lombok.*;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/19-22:34
 * @Since:jdk1.8
 * @Description:
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Record {
    private Integer id;
    private Integer empId;
    private Date signTime;
    private Integer isSign;
}
