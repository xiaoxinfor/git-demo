package com.javasm.dao;

import com.javasm.bean.MoveBooking;
import com.javasm.bean.PageInfo;

import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/10-20:43
 * @Since:jdk1.8
 * @Description:
 */
public interface MoveBookingDao {
    /**
     * 向数据库中添加预约登记信息
     *
     * @param booking
     * @return
     */
    int insert(MoveBooking booking);

    /**
     * 查询表中所有信息
     *
     * @param <T>
     * @return 集合
     */
    <T> List<T> selectAll();

    /**
     * 分页查询
     *
     * @param pageInfo
     * @param <T>
     * @return
     */
    <T> List<T> selectPage(PageInfo pageInfo,String name);

    /**
     * 数据条数
     *
     * @return
     */
    int selectCount(String name);

    /**
     * 查询
     *
     * @param id
     * @return
     */
    <T> T selectMove(Integer id);

    int updateMove(Integer id,Integer state);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int deleteMove(Integer id);
}
