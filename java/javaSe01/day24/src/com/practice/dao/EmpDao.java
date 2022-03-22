package com.practice.dao;

import com.practice.bean.Emp;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/19-22:51
 * @Since:jdk1.8
 * @Description:
 */
public interface EmpDao {
    /**
     * 用户注册(增加)
     *
     * @param emp
     * @return
     */
    int addEmp(Emp emp);

    /**
     * 拿到刚注册的人的信息
     *
     * @param <T>
     * @return
     */
    <T> T newEmp();

    /**
     * 用户登录（查询）
     *
     * @param emp
     * @param <T>
     * @return
     */
    <T> T selectEmp(Emp emp);


    /**
     * 修改自己的个人信息
     *
     * @param emp
     * @return
     */
    int updateEmp(Emp emp);

    /**
     * 生成账号
     *
     * @param emp
     * @return
     */
    int addAct(Emp emp);

}
