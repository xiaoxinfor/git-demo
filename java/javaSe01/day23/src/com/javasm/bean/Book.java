package com.javasm.bean;

import lombok.*;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/17-17:00
 * @Since:jdk1.8
 * @Description:
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {
    int id;
    String bookname;
    int nums;
    int price;
}
