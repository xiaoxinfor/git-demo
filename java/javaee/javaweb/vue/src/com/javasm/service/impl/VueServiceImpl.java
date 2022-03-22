package com.javasm.service.impl;

import com.javasm.bean.VueTb;
import com.javasm.dao.VueDao;
import com.javasm.dao.impl.VueDaoImpl;
import com.javasm.service.VueService;

import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/15-19:42
 * @Since:jdk1.8
 * @Description:
 */
public class VueServiceImpl implements VueService {
    private VueDao vueDao = new VueDaoImpl();
    @Override
    public List<VueTb> selectAll() {
        return vueDao.selectAllVue();
    }

    @Override
    public int addVue(VueTb vueTb) {
        return vueDao.add(vueTb);
    }
}
