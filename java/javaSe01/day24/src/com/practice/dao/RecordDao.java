package com.practice.dao;

import com.practice.bean.Emp;
import com.practice.bean.Record;

import java.util.Date;
import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/20-12:34
 * @Since:jdk1.8
 * @Description:
 */
public interface RecordDao {
    /**
     * 添加打卡信息
     *
     * @param
     * @return
     */
    int addRecord(Record record);

    /**
     * 添加打卡状态
     *
     * @param record
     * @return
     */
    int updateRecord(Record record);

    /**
     * 查看新增打卡信息
     *
     * @param <T>
     * @return
     */
    <T> T selectRecord();

    /**
     * 显示打卡信息
     *
     * @param emp
     * @param <T>
     * @return
     */
    <T> List<T> showRecord(Emp emp);
}
