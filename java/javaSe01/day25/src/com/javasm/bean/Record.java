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
public class Record {
    private Integer id;
    private Integer empId;
    private Date signTime;
    private Integer isSign;
}
