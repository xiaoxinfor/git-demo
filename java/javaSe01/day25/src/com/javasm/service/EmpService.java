package com.javasm.service;

import cn.hutool.core.lang.ConsoleTable;
import com.javasm.bean.Dept;
import com.javasm.bean.Emp;
import com.javasm.dao.DeptDao;
import com.javasm.dao.EmpDao;
import com.javasm.dao.impl.DeptDaoImpl;
import com.javasm.dao.impl.EmpDaoImpl;

import java.util.List;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/21-11:21
 * @Since:jdk1.8
 * @Description:
 */
public class EmpService {
    private Scanner scanner = new Scanner(System.in);
    private EmpDao empDao = new EmpDaoImpl();
    private DeptDao deptDao = new DeptDaoImpl();

    /**
     * 注册
     */
    public void reg() {
        Emp emp = new Emp();
        System.out.println("请输入姓名：");
        String empName = scanner.next();
        emp.setEmpName(empName);
        System.out.println("请输入密码：");
        emp.setEmpPwd(scanner.nextInt());
        System.out.println("请输入性别：");
        emp.setEmpSex(scanner.next());
        System.out.println("请选择部门：");
        List<Dept> list = deptDao.selectDept();
        ConsoleTable consoleTable = new ConsoleTable();
        consoleTable.addHeader("部门ID", "部门名称");
        for (Dept dept : list) {
            consoleTable.addBody(dept.getDeptId().toString(), dept.getDeptName());
        }
        consoleTable.print();
        while (true) {
            int deptId = scanner.nextInt();
            for (Dept dept : list) {
                if (deptId == dept.getDeptId()) {
                    emp.setDeptId(deptId);
                    //将数据添加到数据库
                    empDao.addEmp(emp);
                    //生成账号(编号+姓名）
                    Emp emp1 = empDao.newEmp();
                    String empAct = emp1.getEmpId() + empName;
                    emp1.setEmpAct(empAct);
                    //将账号加入数据中
                    empDao.addAct(emp1);
                    System.out.println("您的账号为：" + empAct);
                    return;
                }
            }
            System.out.println("没有该部门，请重新输入");
        }
    }

    /**
     * 登录
     *
     * @return
     */
    public Emp log() {
        System.out.println("请输入你的登录账号：");
        String empAct = scanner.next();
        System.out.println("请输入你的登录密码：");
        int empPWd = scanner.nextInt();
        Emp emp = empDao.selectEmp(empAct, empPWd);
        return emp;
    }

    /**
     * 修改个人信息
     *
     * @param emp
     */
    public void changeEmp(Emp emp) {
        System.out.println("请输入修改后的姓名");
        String empName = scanner.next();
        emp.setEmpName(empName);
        System.out.println("请输入修改后的密码");
        emp.setEmpPwd(scanner.nextInt());
        System.out.println("请输入修改后的部门编号");
        List<Dept> list = deptDao.selectDept();
        ConsoleTable consoleTable = new ConsoleTable();
        consoleTable.addHeader("部门ID", "部门名称");
        for (Dept dept : list) {
            consoleTable.addBody(dept.getDeptId().toString(), dept.getDeptName());
        }
        consoleTable.print();
        emp.setDeptId(scanner.nextInt());
        System.out.println("请输入修改后的性别");
        emp.setEmpSex(scanner.next());
        empDao.updateEmp(emp);
        //重新生成账号(编号+姓名）
        String empAct = emp.getEmpId() + empName;
        emp.setEmpAct(empAct);
        //将账号加入数据中
        empDao.addAct(emp);
    }

}
