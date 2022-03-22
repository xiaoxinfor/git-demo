package com.javasm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javasm.bean.Deliver;
import com.javasm.dao.DeliverDao;
import com.javasm.service.DeliverService;
import com.javasm.utils.DataConvert;
import com.javasm.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/20-16:21
 * @Since:jdk1.8
 * @Description:
 */
public class DeliverServiceImpl implements DeliverService {
    private SqlSession sqlSession = MyBatisUtils.getSqlSession();
    private DeliverDao deliverDao = sqlSession.getMapper(DeliverDao.class);
    @Override
    public PageInfo<Deliver> selectDel(String pageNumS,String pageSizeS) {
        Integer pageNum = DataConvert.stringConvertInteger(pageNumS);
        Integer pageSize = DataConvert.stringConvertInteger(pageSizeS);
        PageHelper.startPage(pageNum,pageSize);
        List<Deliver> objects = deliverDao.selectDel();
        PageInfo pageInfo = new PageInfo(objects);
        return pageInfo;
    }
}
