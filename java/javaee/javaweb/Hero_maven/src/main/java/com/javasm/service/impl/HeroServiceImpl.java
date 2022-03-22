package com.javasm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javasm.bean.Hero;
import com.javasm.bean.HeroType;
import com.javasm.bean.vo.HeroTypeInfo;
import com.javasm.dao.HeroDao;
import com.javasm.service.HeroService;
import com.javasm.utils.DataConvert;
import com.javasm.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/19-11:04
 * @Since:jdk1.8
 * @Description:
 */
public class HeroServiceImpl implements HeroService {
    private SqlSession sqlSession = MyBatisUtils.getSqlSession();
    private HeroDao heroDao = sqlSession.getMapper(HeroDao.class);

    @Override
    public PageInfo<HeroTypeInfo> selectHeroByPage(String nowPageStr, String pageSizeStr,String heroName,String beginDate,String endDate) {
        Integer pageNum = DataConvert.stringConvertInteger(nowPageStr);
        Integer pageSize = DataConvert.stringConvertInteger(pageSizeStr);

        //加入PageHelper方法
        PageHelper.startPage(pageNum,pageSize);
        List<HeroTypeInfo> list = heroDao.selectHero(heroName,beginDate,endDate);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public List<HeroType> selectHeroType() {
        return heroDao.selectHeroType();
    }

    @Override
    public Integer addHero(Hero hero) {
        Integer integer = heroDao.addHero(hero);
        sqlSession.commit();
        return integer;
    }

    @Override
    public int updateHero(Hero hero) {
        Integer integer = heroDao.updateHero(hero);
        sqlSession.commit();
        return integer;
    }

    @Override
    public int deleteHero(Integer heroId) {
        int i = heroDao.deleteHero(heroId);
        sqlSession.commit();
        return i;
    }
}
