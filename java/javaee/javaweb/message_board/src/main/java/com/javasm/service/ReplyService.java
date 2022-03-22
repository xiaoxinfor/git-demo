package com.javasm.service;

import com.javasm.bean.Reply;

import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/21-20:14
 * @Since:jdk1.8
 * @Description:
 */
public interface ReplyService {
    /**
     * 添加回复
     *
     * @param dIds
     * @param rContent
     * @param uIds
     * @return
     */
    Integer addReply(String dIds,String rContent,String uIds);

    /**
     * 查询回复
     *
     * @param dIdStr
     * @return
     */
    List<Reply> selectSomeReply(String dIdStr);

}
