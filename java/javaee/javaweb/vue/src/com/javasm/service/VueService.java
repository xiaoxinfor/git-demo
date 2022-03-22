package com.javasm.service;

import com.javasm.bean.VueTb;

import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/15-19:40
 * @Since:jdk1.8
 * @Description:
 */
public interface VueService {
    /**
     * 查找所有
     *
     * @return
     */
    List<VueTb> selectAll();

    /**
     * 添加
     *
     * @param vueTb
     * @return
     */
    int addVue(VueTb vueTb);
}
