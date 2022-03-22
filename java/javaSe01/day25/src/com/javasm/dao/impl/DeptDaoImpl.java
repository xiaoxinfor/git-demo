package com.javasm.dao.impl;

import com.javasm.bean.Dept;
import com.javasm.dao.DeptDao;
import com.javasm.utils.JDBCUtils;

import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/21-11:20
 * @Since:jdk1.8
 * @Description:
 */
public class DeptDaoImpl implements DeptDao {
    @Override
    public <T> List<T> selectDept() {
        String sql = "select * from tb_dept order by deptId";
        return JDBCUtils.executeQuery(sql,Dept.class);
    }
}
