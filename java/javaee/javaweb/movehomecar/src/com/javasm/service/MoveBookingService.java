package com.javasm.service;

import com.javasm.bean.MoveBooking;
import com.javasm.bean.PageInfo;

import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/10-20:44
 * @Since:jdk1.8
 * @Description:
 */
public interface MoveBookingService {
    /**
     * 预约登记
     *
     * @param booking
     * @return
     */
    int addMove(MoveBooking booking);

    /**
     * 查询所有预约信息
     *
     * @return
     */
    List<MoveBooking> selectAllMove();



    /**
     * 分页查询（封装）
     *
     * @param nowPage
     * @param pageSize
     * @param name
     * @return
     */
    PageInfo<MoveBooking> selectPageMove(String nowPage,String pageSize,String name);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    MoveBooking getMove(Integer id);

    /**
     * 根据id修改数据
     *
     * @param id
     * @return
     */
    int change(Integer id,Integer state);

    /**
     * 根据id删除数据
     *
     * @param id
     * @return
     */
    int delete(Integer id);
}
