package com.javasm.service;

import com.github.pagehelper.PageInfo;
import com.javasm.bean.Hero;
import com.javasm.bean.HeroType;
import com.javasm.bean.vo.HeroTypeInfo;

import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/19-11:04
 * @Since:jdk1.8
 * @Description:
 */
public interface HeroService {
    /**
     * 分页查询
     * @param nowPage
     * @param pageSize
     * @return
     */
    PageInfo<HeroTypeInfo> selectHeroByPage(String nowPage, String pageSize,String heroName,String beginDate,String endDate);

    /**
     * 查询英雄类型
     *
     * @return
     */
    List<HeroType> selectHeroType();

    /**
     * 增加英雄
     *
     * @return
     */
    Integer addHero(Hero hero);

    /**
     * 修改英雄信息
     *
     * @param hero
     * @return
     */
    int updateHero(Hero hero);

    /**
     * 删除英雄
     *
     * @param heroId
     * @return
     */
    int deleteHero(Integer heroId);
}
