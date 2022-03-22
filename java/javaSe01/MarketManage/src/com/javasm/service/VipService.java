package com.javasm.service;

import cn.hutool.core.lang.ConsoleTable;
import com.javasm.bean.*;
import com.javasm.dao.*;
import com.javasm.dao.impl.*;
import com.javasm.utils.JDBCUtils;
import com.javasm.utils.StateUtils;
import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/23-19:52
 * @Since:jdk1.8
 * @Description:
 */
public class VipService {
    private VipDao vipDao = new VipDaoImpl();
    private GiftDao giftDao = new GiftDaoImpl();
    private OrderdetailsDao orderdetailsDao = new OrderdetailsDaoImpl();
    private Scanner scanner = new Scanner(System.in);
    /**
     * 登录成功后的相关操作
     */
    public void vipOperate(int cardNumber) {
        while (true) {
            System.out.println("超市管理系统>>>会员操作");
            System.out.println("1.查询积分");
            System.out.println("2.积分兑换");
            System.out.println("3.积分抽奖");
            System.out.println("4.签到(获得10积分)");
            System.out.println("5.查看订单");
            System.out.println("0.返回上一级");
            System.out.println("请选择");
            switch (scanner.nextInt()) {
                case 1:
                    selectJifen(cardNumber);
                    break;
                case 2:
                    getGift(cardNumber);
                    break;
                case 3:
                    checkGift(cardNumber);
                    break;
                case 4:
                    sign(cardNumber);
                    break;
                case 5:
                    selectOrder(cardNumber);
                    break;
                case 0:
                    System.out.println("返回成功");
                    return;
            }
        }
    }

    /**
     * 查看订单
     *
     * @param cardNumber
     */
    private void selectOrder(int cardNumber) {
        List<Order> list = orderdetailsDao.selectOrder(0,cardNumber);
        if (list == null || list.size() == 0) {
            System.out.println("未查询到任何信息");
            return;
        }
        ConsoleTable ct = new ConsoleTable();
        ct.addHeader("订单编号", "商品名称", "单价", "折扣", "购买数量", "购买时间", "支付方式","总价");
        for (Order order : list) {
            ct.addBody(order.getOrderid().toString(), order.getProductName(), order.getPrice().toString(),
                    order.getDiscount().toString(), order.getNum().toString(), order.getOrderdate().toString(),
                    StateUtils.payType(order.getPaytype()),order.getPrices().toString());
        }
        ct.print();


    }

    /**
     * 签到
     *
     * @param cardNumber
     */
    private void sign(int cardNumber) {
        //给该账户增加10个积分
        int jifen = selectJifen(cardNumber);//拿到该账户积分
        int newJifen = jifen + 10;
        int i = vipDao.reviseVip(newJifen,cardNumber);
        if (i>0){
            System.out.println("签到成功");
        }
    }

    /**
     * 积分抽奖
     *
     * @param cardNumber
     */
    private void checkGift(int cardNumber) {
        System.out.println("10积分抽一次");
        boolean b = true;
        while(b){
            //判断积分是否足够
            int jifen = selectJifen(cardNumber);//拿到该账户积分
            if (jifen<10){
                System.out.println("积分不足，不能参与抽奖");
                return;
            }
            //进行抽奖
            int i = (int)(Math.random()*100+1);//随机生成一个1-100的数字
            List<Gift> list = giftDao.selectGift();//得到抽奖物品
            int a = 0;//未抽到
            for (Gift gift : list) {
                if (i == gift.getId()){
                    System.out.println("恭喜您，抽到奖品：" + gift.getName());
                    // 加入订单
                    addOrder(cardNumber,gift.getName());
                    a = 1;//抽到
                }
            }
            if (a == 0){
                System.out.println("抱歉，未抽到奖品");
            }
            //减少该账户10个积分
            int newJifen = jifen -10;
            vipDao.reviseVip(newJifen,cardNumber);
            System.out.println("在抽一次（y/n）");
            String isNext = scanner.next();
            if (isNext.toLowerCase().equals("n")){
                return;
            }
        }
    }

    /**
     * 积分兑换奖品
     */
    private void getGift(int cardNumber) {
        //显示奖品
        List<Gift> list = giftDao.selectGift();
        ConsoleTable consoleTable = new ConsoleTable();
        consoleTable.addHeader("编号","奖品名称","所需积分");
        for (Gift gift : list) {
            consoleTable.addBody(gift.getId().toString(),gift.getName(),gift.getJifen().toString());
        }
        consoleTable.print();
        int i = selectJifen(cardNumber);//该会员有的积分
        System.out.println("请选择您想兑换的奖品编号");
        int id = scanner.nextInt();
        for (Gift gift : list) {
            if (gift.getId() == id){
                //判断积分是否足够兑换
                if (i<gift.getJifen()){
                    System.out.println("抱歉，您的积分不足,请选择其他奖品");
                    return;
                }
                //兑换成功，该会员账号减去对应的积分
                int newJifen = i - gift.getJifen();
                int a = vipDao.reviseVip(newJifen,cardNumber);
                if (a > 0){
                    System.out.println("兑换成功");
                    // 加入订单
                    addOrder(cardNumber,gift.getName());
                    return;
                }
            }
        }
        System.out.println("兑换失败");
    }

    /**
     * 查询积分
     *
     * @param cardNumber
     */
    public int selectJifen(int cardNumber) {
        Vip vip = vipDao.selectVipByCardNum(cardNumber);
        int i = vip.getJifen();
        System.out.println("您的积分为：" + i);
        return i;
    }

    /**
     * 抽奖或者积分兑换得到的奖品也要放到订单信息中
     */
    public void addOrder(int cardNumber,String giftName){
        OrderinfoDao orderinfoDao = new OrderinfoDaoImpl();
        //生成简要订单记录
        Connection con = JDBCUtils.getConnection();

        try {
            //更改事务提交方式
            con.setAutoCommit(false);
            new CashierService().createOrderInfo(con,cardNumber,0,3);
            //生成订单详情表
            int inFoId = 0;//订单ID
            Orderinfo orderinfo = orderinfoDao.selectInfo();//拿到原订单记录表中最后一条的信息
            if (orderinfo == null) {
                //如果订单记录表中还没有数据，则订单ID从1开始
                inFoId = 1;
            } else {
                inFoId = orderinfo.getId() + 1;
            }
            //往订单详情表添加数据
            //拿到该奖品在商品表中的ID
            ProductDao productDao = new ProductDaoImpl();
            Product product = productDao.getProductByName(giftName);
            int giftIdInPro = product.getId();
            int b = orderdetailsDao.addTalis(con, inFoId, giftIdInPro);
            if (b>0){
                System.out.println("添加成功");
                DbUtils.commitAndClose(con);//提交事务，关闭资源
            }else {
                DbUtils.rollbackAndClose(con); //事务回滚
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
