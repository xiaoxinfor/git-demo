package com.practice.service;

import cn.hutool.core.lang.ConsoleTable;
import com.practice.bean.Dept;
import com.practice.bean.Emp;
import com.practice.bean.Record;
import com.practice.dao.DeptDao;
import com.practice.dao.EmpDao;
import com.practice.dao.Impl.DeptDaoImpl;
import com.practice.dao.Impl.EmpDaoImpl;
import com.practice.dao.Impl.RecordDaoImpl;
import com.practice.dao.RecordDao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/20-13:23
 * @Since:jdk1.8
 * @Description:
 */
public class EmpService {
    private Scanner scanner = new Scanner(System.in);
    private DeptDao deptDao = new DeptDaoImpl();
    private EmpDao empDao = new EmpDaoImpl();
    private RecordDao recordDao = new RecordDaoImpl();

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
        emp.setDeptId(scanner.nextInt());
        //将数据添加到数据库
        empDao.addEmp(emp);
        //生成账号(编号+姓名）
        Emp emp1 = empDao.newEmp();
        String empAct = emp1.getEmpId() + empName;
        emp1.setEmpAct(empAct);
        //将账号加入数据中
        empDao.addAct(emp1);
        System.out.println("您的账号为：" + empAct);
    }

    /**
     * 登录
     *
     * @return
     */
    public Emp log() {
        Emp emp = new Emp();
        System.out.println("请输入你的登录账号：");
        emp.setEmpAct(scanner.next());
        System.out.println("请输入你的登录密码：");
        emp.setEmpPwd(scanner.nextInt());
        Emp emp1 = empDao.selectEmp(emp);
        return emp1;
    }

    /**
     * 打卡
     */
    public void addRecord(Emp emp) {
        Record record = new Record();
        record.setEmpId(emp.getEmpId());
        //获取系统当前时间
        Date date = new Date();
        record.setSignTime(date);
        recordDao.addRecord(record);
        //判断是否打卡成功
        Record record1 = recordDao.selectRecord();
        int i = recordDao.updateRecord(record1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Record record2 = recordDao.selectRecord();
        int a = record2.getIsSign();//拿到打卡状态
        if (i > 0) {
            if (a == 1) {
                System.out.println("打卡成功，您的打卡时间：" + sdf.format(date));
            }else if (a == 0){
                System.out.println("迟到打卡，您的打卡时间：" + sdf.format(date));
            }
        } else {
            System.out.println("打卡失败");
        }
    }

    /**
     * 修改个人信息
     */
    public void changeEmp(Emp emp){
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

    /**
     * 显示打卡记录
     */
    public void show(Emp emp){
        List<Emp> list = recordDao.showRecord(emp);
        ConsoleTable consoleTable = new ConsoleTable();
        consoleTable.addHeader("编号","部门名称","员工姓名","员工性别","入职时间","打卡时间","打卡状态");
        for (Emp emp1 : list) {
            consoleTable.addBody(emp1.getId().toString(),emp1.getDeptName(),emp1.getEmpName(),emp1.getEmpSex(),emp1.getJoinTime().toString(),emp1.getSignTime().toString(),emp1.getIsSign()==0 ? "迟到打卡" : "正常打卡");
        }
        consoleTable.print();
    }
}
