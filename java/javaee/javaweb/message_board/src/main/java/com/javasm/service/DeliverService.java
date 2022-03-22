package com.javasm.service;

import com.github.pagehelper.PageInfo;
import com.javasm.bean.Deliver;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/20-16:21
 * @Since:jdk1.8
 * @Description:
 */
public interface DeliverService {
    /**
     * 查询所有帖子
     * @return
     */
    PageInfo<Deliver> selectDel(String pageNumS,String pageSizeS);
}
