package com.javayx;

import com.javayx.dao.ServiceDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/22-14:37
 * @Since:jdk1.8
 * @Description:
 */
public class MyTest {
    @Test
    public void forTest(){
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        ServiceDao service = (ServiceDao) ac.getBean("service");
        service.doSome();
    }
}
