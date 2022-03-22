package com.javapractice.service;

import com.javapractice.bean.Area;

import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/14-19:43
 * @Since:jdk1.8
 * @Description:
 */
public interface ProvinceService {
    /**
     * 查询所有省份
     *
     * @return
     */
    List<Area> allProvince();

    /**
     * 查询省份下的市
     * @return
     */
    List<Area> cityByparentId(int parentId);

}
