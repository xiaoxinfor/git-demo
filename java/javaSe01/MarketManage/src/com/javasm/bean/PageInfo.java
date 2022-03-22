package com.javasm.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/21-21:31
 * @Since:jdk1.8
 * @Description:
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PageInfo {
    //总条数
    private Integer allCount;
    //总页数
    private Integer allPage;
    //每页显示条数
    private Integer count;
    //当前页
    private Integer page;

    //计算总页数
    public void setAllPage() {
        this.allPage = (allCount % count) != 0 ? (allCount / count + 1) : (allCount / count);
    }
}
