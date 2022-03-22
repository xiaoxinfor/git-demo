package com.practice.dao.Impl;

import com.javasm.utils.JDBCUtils;
import com.practice.bean.Emp;
import com.practice.bean.Record;
import com.practice.dao.RecordDao;

import javax.sql.rowset.JdbcRowSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/20-13:19
 * @Since:jdk1.8
 * @Description:
 */
public class RecordDaoImpl implements RecordDao {
    @Override
    public int addRecord(Record record) {
        String sql = "insert into tb_record values(null,?,?,null);";
        return JDBCUtils.executeUpdate(sql,record.getEmpId(),record.getSignTime());
    }

    @Override
    public int updateRecord(Record record) {
        Date date = record.getSignTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String late = sdf.format(date) + " 08:00:00";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int i = 0;
        try {
            Date date1 = sdf1.parse(late);
            if (date.before(date1)){//正常打卡
                String sql = "update tb_record set isSign = 1 where id = ?";
                i = JDBCUtils.executeUpdate(sql,record.getId());
            }else {
                String sql = "update tb_record set isSign = 0 where id = ?";
                i = JDBCUtils.executeUpdate(sql,record.getId());
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public <T> T selectRecord() {
        String sql = "select * from tb_record order by id desc limit 1";
        return JDBCUtils.get(sql,Record.class);
    }

    @Override
    public <T> List<T> showRecord(Emp emp) {
        String sql = "select r.id,d.deptName,e.empName,e.empSex,e.joinTime,r.signTime,r.isSign from tb_emp e" +
                " left join tb_dept d on e.deptId = d.deptId " +
                "left join tb_record r on e.empId = r.empId " +
                "where e.empId = ?";
        return JDBCUtils.find(sql,Emp.class,emp.getEmpId());
    }
}
