package com.javasm.service;

import cn.hutool.core.lang.ConsoleTable;
import com.javasm.bean.Emp;
import com.javasm.bean.Record;
import com.javasm.dao.RecordDao;
import com.javasm.dao.impl.RecordDaoImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/21-11:22
 * @Since:jdk1.8
 * @Description:
 */
public class RecordService {
    RecordDao recordDao = new RecordDaoImpl();
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
     * 显示打卡记录
     */
    public void show(Emp emp){
        List<Emp> list = recordDao.showRecord(emp);

        ConsoleTable consoleTable = new ConsoleTable();
        consoleTable.addHeader("编号","部门名称","员工姓名","员工性别","入职时间","打卡时间","打卡状态");
        for (Emp emp1 : list) {
            if (emp1.getId() == null){
                System.out.println("该员工打卡信息为空");
                return;
            }
            consoleTable.addBody(emp1.getId().toString(),emp1.getDeptName(),emp1.getEmpName(),emp1.getEmpSex(),emp1.getJoinTime().toString(),emp1.getSignTime().toString(),emp1.getIsSign()==0 ? "迟到打卡" : "正常打卡");
        }
        consoleTable.print();
    }


}
