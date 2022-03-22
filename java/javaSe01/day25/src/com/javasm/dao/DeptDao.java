package com.javasm.dao;

import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/21-11:19
 * @Since:jdk1.8
 * @Description:
 */
public interface DeptDao {
    /**
     * 查询部门信息
     *
     * @param <T>
     * @return
     */
    <T> List<T> selectDept();
}
