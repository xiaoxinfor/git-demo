package com.javasm.dao;

import com.github.pagehelper.PageInfo;
import com.javasm.bean.Hero;
import com.javasm.bean.vo.HeroTypeInfo;
import org.apache.ibatis.annotations.Param;


import java.util.Date;
import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/16-17:56
 * @Since:jdk1.8
 * @Description:
 */
public interface HeroDao {
    /**
     * 查询
     * @param <T>
     * @return
     */
    <T> List<T> selectHero(@Param("heroName") String heroName, @Param("beginDate") String beginDate,@Param("endDate") String endDate);

    /**
     * 查询英雄类型
     *
     * @param <T>
     * @return
     */
    <T> List<T> selectHeroType();

    /**
     * 添加英雄信息
     *
     * @param hero
     * @return
     */
    Integer addHero(Hero hero);

    /**
     * 修改英雄信息
     *
     * @param hero
     * @return
     */
    Integer updateHero(Hero hero);

    /**
     * 删除英雄
     *
     * @param heroId
     * @return
     */
    int deleteHero(@Param("heroId") Integer heroId);
}
