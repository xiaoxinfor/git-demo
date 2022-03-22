package com.practice.dao.Impl;

import com.javasm.utils.JDBCUtils;
import com.practice.bean.Dept;
import com.practice.dao.DeptDao;

import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/20-12:52
 * @Since:jdk1.8
 * @Description:
 */
public class DeptDaoImpl implements DeptDao {

    @Override
    public <T> List<T> selectDept() {
        String sql = "select * from tb_dept order by deptId";
        return JDBCUtils.find(sql,Dept.class);
    }
}
