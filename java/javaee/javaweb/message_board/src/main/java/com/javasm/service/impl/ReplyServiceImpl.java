package com.javasm.service.impl;

import com.javasm.bean.Reply;
import com.javasm.dao.ReplyDao;
import com.javasm.service.ReplyService;
import com.javasm.utils.DataConvert;
import com.javasm.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/21-20:15
 * @Since:jdk1.8
 * @Description:
 */
public class ReplyServiceImpl implements ReplyService {
    SqlSession sqlSession = MyBatisUtils.getSqlSession();
    private ReplyDao replyDao = sqlSession.getMapper(ReplyDao.class);
    @Override
    public Integer addReply(String dIds, String rContent, String uIds) {
        Integer dId = DataConvert.stringConvertInteger(dIds);
        Integer uId = DataConvert.stringConvertInteger(uIds);
        Integer integer = replyDao.addReply(dId, rContent, uId);
        sqlSession.commit();
        return integer;
    }

    @Override
    public List<Reply> selectSomeReply(String dIdStr) {
        Integer dId = DataConvert.stringConvertInteger(dIdStr);
        List<Reply> reply = replyDao.selectSomeReply(dId);
        return reply;
    }
}
