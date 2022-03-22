package com.javasm.service.impl;

import com.javasm.bean.MoveBooking;
import com.javasm.bean.PageInfo;
import com.javasm.dao.MoveBookingDao;
import com.javasm.dao.impl.MoveBookingDaoImpl;
import com.javasm.service.MoveBookingService;

import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/10-20:44
 * @Since:jdk1.8
 * @Description:
 */
public class MoveBookingServiceImpl implements MoveBookingService {
    private MoveBookingDao bookingDao = new MoveBookingDaoImpl();
    @Override
    public int addMove(MoveBooking booking) {
        return bookingDao.insert(booking);
    }

    @Override
    public List<MoveBooking> selectAllMove() {
        return bookingDao.selectAll();
    }


    @Override
    public PageInfo<MoveBooking> selectPageMove(String nowPageStr, String pageSizeStr, String name) {
        //将当前页转为整数型
        Integer nowPage = nowPageStr !=null ? Integer.valueOf(nowPageStr) : 1;
        Integer pageSize = pageSizeStr != null ? Integer.valueOf(pageSizeStr) : 3;
        //获取数据数量
        Integer count = bookingDao.selectCount(name);
        //创建PageInfo对象
        PageInfo pageInfo = new PageInfo(nowPage,pageSize,count);
        //分页查询信息
        List<MoveBooking> list = bookingDao.selectPage(pageInfo,name);
        pageInfo.setDataList(list);
        return pageInfo;
    }

    @Override
    public MoveBooking getMove(Integer id) {
        return bookingDao.selectMove(id);
    }

    @Override
    public int change(Integer id,Integer state) {
        return bookingDao.updateMove(id,state);
    }

    @Override
    public int delete(Integer id) {
        return bookingDao.deleteMove(id);
    }
}
