package com.javapractice.service.impl;

import com.javapractice.bean.Area;
import com.javapractice.dao.SelectCityDao;
import com.javapractice.dao.impl.SelectCityDaoImpl;
import com.javapractice.service.ProvinceService;

import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/14-19:46
 * @Since:jdk1.8
 * @Description:
 */
public class ProvinceServiceImpl implements ProvinceService {
    private SelectCityDao selectCityDao = new SelectCityDaoImpl();
    @Override
    public List<Area> allProvince() {
        return selectCityDao.allProvince();
    }

    @Override
    public List<Area> cityByparentId(int parentId) {
        return selectCityDao.getCityById(parentId);
    }

}
