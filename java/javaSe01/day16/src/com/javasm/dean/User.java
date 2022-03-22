package com.javasm.dean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/17-15:01
 * @Since:jdk1.8
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Comparable<User>{
    private Integer id;
    private String name;




    @Override
    public int compareTo(User o) {
        return (this.getId() < o.getId()) ? -1 : ((this.getId() == o.getId()) ? 0 : 1);
    }
}
