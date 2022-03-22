package com.javasm;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javasm.bean.Hero;
import com.javasm.bean.HeroType;
import com.javasm.bean.vo.HeroTypeInfo;
import com.javasm.dao.HeroDao;
import com.javasm.service.HeroService;
import com.javasm.service.impl.HeroServiceImpl;
import com.javasm.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/18-22:49
 * @Since:jdk1.8
 * @Description:
 */
public class TestMybatis {
    private HeroService heroService = new HeroServiceImpl();
    SqlSession sqlSession = MyBatisUtils.getSqlSession();
    HeroDao heroDao = sqlSession.getMapper(HeroDao.class);
    @Test
    public void testHero(){
        int i = heroService.deleteHero(13);
        System.out.println(i);
    }
    @Test
    public void setHeroService(){
        PageInfo<HeroTypeInfo> byPage = heroService.selectHeroByPage("1", "3", "", "2021-02-01", "2021-03-01");
        System.out.println(byPage);
    }
}
