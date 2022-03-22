package com.practice.practice1;

import com.javasm.dean.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/17-21:02
 * @Since:jdk1.8
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Comparable<Student>{
    private Integer id;
    private Integer score;

    @Override
    public int compareTo(Student o) {
        return (this.getScore() < o.getScore()) ? -1 : ((this.getScore() == o.getScore()) ? 0 : 1);
    }
}
