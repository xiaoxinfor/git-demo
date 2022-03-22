package com.practice.dao.Impl;

import com.javasm.utils.JDBCUtils;
import com.practice.bean.Emp;
import com.practice.dao.EmpDao;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/19-22:52
 * @Since:jdk1.8
 * @Description:
 */
public class EmpDaoImpl implements EmpDao {
    @Override
    public int addEmp(Emp emp) {
        String sql = "insert into tb_emp values (null,?,null,?,?,?,now());";
        return JDBCUtils.executeUpdate(sql,emp.getEmpName(),emp.getEmpPwd(),emp.getDeptId(),emp.getEmpSex());
    }

    @Override
    public <T> T newEmp() {
        String sql = "select * from tb_emp order by empId desc limit 1;";
        return JDBCUtils.get(sql,Emp.class);
    }

    @Override
    public <T> T selectEmp(Emp emp) {
        String sql = "select * from tb_emp where empAct = ? and empPwd = ?;";
        return JDBCUtils.get(sql,Emp.class,emp.getEmpAct(),emp.getEmpPwd());
    }

    @Override
    public int updateEmp(Emp emp) {
        String sql = "update tb_emp set empName = ?,empPwd = ?,deptId = ? where empId = ?;";
        return JDBCUtils.executeUpdate(sql,emp.getEmpName(),emp.getEmpPwd(),emp.getDeptId(),emp.getEmpId());
    }

    @Override
    public int addAct(Emp emp) {
        String sql = "update tb_emp set empAct = ? where empId = ?;";
        return JDBCUtils.executeUpdate(sql,emp.getEmpAct(),emp.getEmpId());
    }
}
