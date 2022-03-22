package com.javasm;

import com.github.pagehelper.PageInfo;
import com.javasm.bean.Deliver;
import com.javasm.bean.Reply;
import com.javasm.bean.User;
import com.javasm.service.DeliverService;
import com.javasm.service.ReplyService;
import com.javasm.service.UserService;
import com.javasm.service.impl.DeliverServiceImpl;
import com.javasm.service.impl.ReplyServiceImpl;
import com.javasm.service.impl.UserServiceImpl;
import org.junit.Test;

import java.util.List;


/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/20-14:27
 * @Since:jdk1.8
 * @Description:
 */
public class TestSer {
    private UserService userService = new UserServiceImpl();
    private DeliverService deliverService = new DeliverServiceImpl();
    private ReplyService replyService = new ReplyServiceImpl();
    @Test
    public void setUserService(){
        List<Reply> reply = replyService.selectSomeReply("1");
        System.out.println(reply);
    }
    @Test
    public void setDelService(){
        Integer integer = replyService.addReply("2", "fffafasf", "3");
        System.out.println(integer);
    }
}
