package com.javasm.dao.impl;

import com.javasm.bean.Emp;
import com.javasm.dao.EmpDao;
import com.javasm.utils.JDBCUtils;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/21-11:20
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
    public <T> T selectEmp(String empAct, int empPwd) {
        String sql = "select * from tb_emp where empAct = ? and empPwd = ?;";
        return JDBCUtils.get(sql,Emp.class,empAct,empPwd);
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
