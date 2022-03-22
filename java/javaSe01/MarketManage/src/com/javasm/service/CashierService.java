package com.javasm.service;

import cn.hutool.core.lang.ConsoleTable;
import com.javasm.bean.*;
import com.javasm.constants.CashierConstants;
import com.javasm.constants.Price;
import com.javasm.dao.*;
import com.javasm.dao.impl.*;
import com.javasm.utils.JDBCUtils;
import com.javasm.utils.StateUtils;
import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/22-15:42
 * @Since:jdk1.8
 * @Description:
 */
public class CashierService {
    private Scanner scanner = new Scanner(System.in);
    private ProductDao productDao = new ProductDaoImpl();
    private ShopCarDao shopCarDao = new ShopCarDaoImpl();
    private VipDao vipDao = new VipDaoImpl();
    private OrderinfoDao orderinfoDao = new OrderinfoDaoImpl();
    private OrderdetailsDao orderdetailsDao = new OrderdetailsDaoImpl();

    /**
     * 登录成功后的操作
     */
    public void cashierOperate() {
        while (true) {
            System.out.println("超市管理系统>>>收银员操作界面");
            System.out.println("1.购买管理");
            System.out.println("2.订单查询");
            System.out.println("3.排行统计");
            System.out.println("0.返回上一级");
            switch (scanner.nextInt()) {
                case 1:
                    buyManager();
                    break;
                case 2:
                    selectOrder();
                    break;
                case 3:
                    rank();
                    break;
                case 0:
                    System.out.println("返回成功");
                    return;
            }
        }
    }

    public void buyManager() {
        while (true) {
            System.out.println("超市管理系统>>>收银员操作界面>>>购买管理");
            System.out.println("1.添加商品");
            System.out.println("2.修改商品数量");
            System.out.println("3.删除购物车中的商品");
            System.out.println("4.展示购物车商品列表");
            System.out.println("5.购买");
            System.out.println("0.返回上一级");
            switch (scanner.nextInt()) {
                case 1:
                    addGoods();
                    break;
                case 2:
                    reGoodsNum();
                    break;
                case 3:
                    deleteGoods();
                    break;
                case 4:
                    showCar();
                    break;
                case 5:
                    buy();
                    break;
                case 0:
                    shopCarDao.deleteCar();//退出时清空购物车
                    System.out.println("返回成功");
                    return;
            }
        }
    }


    /**
     * 给购物车中添加商品
     */
    private void addGoods() {
        System.out.println("超市管理系统>>>收银员操作界面>>>购买管理>>>添加到购物车");
        //根据商品名字迷糊查询
        List<Product> list = mohuSelectPro();
        //展示
        ConsoleTable consoleTable = new ConsoleTable();
        consoleTable.addHeader("商品ID", "商品名称", "商品价格", "库存", "折扣");
        for (Product product : list) {
            consoleTable.addBody(product.getId().toString(), product.getProductName(), product.getPrice().toString(),
                    product.getNum().toString(), product.getDiscount().toString());
        }
        consoleTable.print();
        System.out.println("请输入要添加的商品ID");
        int productId = scanner.nextInt();
        Product product = productDao.getProductById(productId);
        if (product == null) {//判断超市中有没有该商品
            System.out.println("该商品不存在，请重新选择");
            return;
        }
        //只有商品状态为上架时才能加入购物车
        if (product.getState() != 1) {
            System.out.println("该商品未上架，请选择其他商品");
            return;
        }
        //判断该商品是否早就在购物车中
        ShopCar shopCar1 = shopCarDao.selectByProId(productId);
        if (shopCar1 == null) {//首次添加该商品
            boolean b = true;
            while (b) {
                System.out.println("请输入购买的数量：");
                int buyNum = scanner.nextInt();
                if (buyNum > product.getNum()) {
                    System.out.println("数量不足，请重新选择数量");
                } else {
                    //计算小计（原价*折扣*数量）
                    double prices = product.getPrice() * ((double) product.getDiscount() / 10) * buyNum;
                    //将该商品加入到购物车
                    ShopCar shopCar = new ShopCar();
                    shopCar.setProductid(productId);    //商品ID
                    shopCar.setProductName(product.getProductName());
                    shopCar.setPrice(product.getPrice()); //商品价格
                    shopCar.setDiscount(product.getDiscount());//商品折扣
                    shopCar.setNum(buyNum);//商品数量
                    shopCar.setPrices(prices);//商品价格小计
                    int i = shopCarDao.addGoods(shopCar);
                    if (i > 0) {
                        System.out.println("加入成功");
                    } else System.out.println("加入失败");
                    b = false;
                }
            }
        } else {//非首次添加
            //拿到原购物车中的数量
            int oldNum = shopCar1.getNum();
            boolean b = true;
            while (b) {
                System.out.println("请输入购买的数量：");
                int buyNum = scanner.nextInt();
                if ((buyNum + oldNum) > product.getNum()) {
                    System.out.println("数量不足，请重新选择数量:");
                } else {
                    //修改购物车中该商品的数量
                    int num = buyNum + oldNum;
                    //价格小计（原价*折扣*数量）
                    double prices = shopCar1.getPrice() * ((double) shopCar1.getDiscount() / 10) * num;
                    int i = shopCarDao.reviseNum(num, prices, shopCar1.getProductid());
                    if (i > 0) {
                        System.out.println("添加成功");
                    } else {
                        System.out.println("添加失败");
                    }
                    b = false;
                }
            }
        }


    }

    /**
     * 修改购物车中的商品数量
     */
    private void reGoodsNum() {
        System.out.println("超市管理系统>>>收银员操作界面>>>购买管理>>>修改购物车商品数量");
        System.out.println("请输入要修改数量商品的ID");
        int shopCarId = scanner.nextInt();
        //首先查询购物车中有没有该商品ID
        ShopCar shopCar = shopCarDao.selectByProId(shopCarId);
        if (shopCar == null) {
            System.out.println("抱歉，未查询到该商品，不能修改");
            return;
        }
        Product product = productDao.getProductById(shopCarId);
        boolean b = true;
        while (b) {
            System.out.println("请输入要修改成的数量:");
            int reNum = scanner.nextInt();
            //修改数量不能超过库存量
            if (reNum > product.getNum()) {
                System.out.println("数量不足，请重新选择数量");
            } else {
                //价格小计要重新计算（原价*折扣*数量）
                double prices = product.getPrice() * ((double) product.getDiscount() / 10) * reNum;
                int i = shopCarDao.reviseNum(reNum, prices, shopCarId);
                if (i > 0) {
                    System.out.println("修改成功");
                } else {
                    System.out.println("修改失败");
                }
                b = false;
            }
        }
    }

    /**
     * 删除购物车中的商品
     */
    public void deleteGoods() {
        System.out.println("超市管理系统>>>收银员操作界面>>>购买管理>>>删除购物车商品");
        System.out.println("请输入要删除的商品ID");
        int shopCarId = scanner.nextInt();
        //首先查询购物车中有没有该商品ID
        ShopCar shopCar = shopCarDao.selectByProId(shopCarId);
        if (shopCar == null) {
            System.out.println("抱歉，未查询到该商品，不能删除");
            return;
        }
        int i = shopCarDao.deleteGoods(shopCarId);
        if (i > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    /**
     * 显示购物车列表
     */
    public void showCar() {
        System.out.println("显示购物车商品列表");
        List<ShopCar> list = shopCarDao.showCar();
        if (list == null || list.size() == 0) {
            System.out.println("未查询到任何信息");
            return;
        }
        ConsoleTable consoleTable = new ConsoleTable();
        consoleTable.addHeader("商品ID", "商品名称", "商品单价", "商品折扣", "商品数量", "价格小计");
        for (ShopCar shopCar : list) {
            consoleTable.addBody(shopCar.getProductid().toString(), shopCar.getProductName(), shopCar.getPrice().toString(), shopCar.getDiscount().toString(),
                    shopCar.getNum().toString(), shopCar.getPrices().toString());
        }
        consoleTable.print();
    }

    /**
     * 购买结算
     *
     * @return
     */
    public void buy() {
        System.out.println("超市管理系统>>>收银员操作界面>>>购买管理>>>结算");
        //计算购物车中的价格小计
        double prices = 0.0;
        prices = shopCarDao.countPrices();
        if (prices == 0.0) {
            System.out.println("抱歉，您的购物车中没有商品，您可以选择购买商品");
            return;
        }
        System.out.println("您需要支付" + prices + "元");
        //获取连接对象
        Connection con = JDBCUtils.getConnection();

        try {
            //开启事务
            con.setAutoCommit(false);

            //判断是否是会员，是会员有两种支付方法,是会员输入会员号，非会员输入1000；
            System.out.println("请输入会员号(非会员输入1000)：");
            int vipCard = scanner.nextInt();
            int payType = -1;
            if (vipCard != 1000) {
                System.out.println("请选择支付方式：");
                System.out.println("1.会员余额支付");
                System.out.println("2.其他支付方式");
                payType = scanner.nextInt();
                switch (payType) {
                    case 1:
                        //更改会员余额，会员积分，商品库存量
                        //计算积分，10元一个积分，不满十元没有积分
                        int jifen = (int) prices / 10;
                        //拿到该会员号的原余额以及原积分
                        Vip vip = vipDao.selectVipByCardNum(vipCard);
                        double oldPrice = vip.getMoney();
                        if (oldPrice < prices) {
                            System.out.println("会员余额不足，请选择其他方式支付");
                            return;
                        }
                        //余额充足
                        int oldJifen = vip.getJifen();
                        double newPrice = oldPrice - prices;
                        int newJifen = oldJifen + jifen;
                        int i = shopCarDao.reviseVip(con, vipCard, newJifen, newPrice);
                        if (i > 0) {
                            System.out.println("更改会员余额，会员积分成功");

                        }

                        break;
                    case 2:
                        //更改会员积分，商品库存量
                        int jifen1 = (int) prices / 10;
                        //拿到该会员号的原积分
                        Vip vip1 = vipDao.selectVipByCardNum(vipCard);
                        int oldJifen1 = vip1.getJifen();
                        int newJifen1 = oldJifen1 + jifen1;
                        int i1 = shopCarDao.reviseVip(con, vipCard, newJifen1);
                        if (i1 > 0) {
                            System.out.println("更改会员积分成功");
                        }
                        break;
                }

            } else {
                //非会员不能用会员余额支付，只涉及更改商品库存
                payType = 2;
                System.out.println("您需支付" + prices + "现金");
                System.out.println("1.确定购买     2.我在想想");
                int choose = scanner.nextInt();
                if (choose == 2) {
                    System.out.println("购买失败");
                    return;
                }
            }

            //更改商品库存,根据商品ID
            //先取出购物车中所有的商品id及数量
            int count = shopCarDao.count();
            List<ShopCar> list = shopCarDao.showCar();
            int i = 0;
            for (ShopCar car : list) {
                //拿到原库存数
                Product product = productDao.getProductById(car.getProductid());
                int oldNum = product.getNum();
                int newNum = oldNum - car.getNum();
                //修改库存
                int a = productDao.reviseProduct(con, car.getProductid(), newNum);
                if (a > 0) {
                    i++;
                }
            }
            if (i == count) {
                //生成简要订单记录
                createOrderInfo(con, vipCard, prices, payType);
                //生成订单详情表
                int inFoId = 0;//订单ID
                Orderinfo orderinfo = orderinfoDao.selectInfo();//拿到原订单记录表中最后一条的信息
                if (orderinfo == null) {
                    //如果订单记录表中还没有数据，则订单ID从1开始
                    inFoId = 1;
                } else {
                    inFoId = orderinfo.getId() + 1;
                }
                int a = 0;
                for (ShopCar car : list) {
                    //往订单详情表添加数据
                    int b = orderdetailsDao.addTalis(con, inFoId, car);
                    if (b > 0) {
                        a++;
                    }
                }
                if (a == count) {
                    System.out.println("购买成功");
                    //清空购物车
                    shopCarDao.deleteCar();
                    //提交事务
                    DbUtils.commitAndClose(con);
                    return;
                }
            } else {
                System.out.println("购买失败");
                //回滚事务
                DbUtils.rollbackAndClose(con);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                DbUtils.rollbackAndClose(con);//回滚事务
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

    }

    /**
     * 生成简要订单记录
     *
     * @param con
     * @param vipId
     * @param prices
     * @param payType
     */
    public void createOrderInfo(Connection con, int vipId, double prices, int payType) {
        Date date = new Date();
        //为了保证订单记录ID的连续性,防止删除一条信息后主键ID出现断层的情况
        Orderinfo orderinfo = orderinfoDao.selectInfo();//拿到原订单记录表中最后一条的信息
        int newId = 1;
        if (orderinfo != null) {
            int oldId = orderinfo.getId();
            newId = oldId + 1;
        }
        orderinfoDao.addOrdInfo(con, newId, vipId, prices, date, payType);
    }

    /**
     * 订单查询
     */
    public void selectOrder() {
        System.out.println("超市管理系统>>>收银员操作界面>>>订单查询");
        scanner.nextLine();
        System.out.println("请输入您要查询订单的商品编号:");
        int orderId = 0;
        String oid = scanner.nextLine();
        if (!oid.equals("")) {
            orderId = Integer.parseInt(oid);
        }
        System.out.println("请输入您要查询订单的会员编号:");
        int vipId = 0;
        String vid = scanner.nextLine();
        if (!vid.equals("")) {
            vipId = Integer.parseInt(vid);
        }
        if (orderId == 0 && vipId == 0) {
            System.out.println("您未输入查询条件，默认查询所有订单信息");
        }
        List<Order> orderList = orderdetailsDao.selectOrder(orderId, vipId);
        //分页对象
        PageInfo pageInfo = new PageInfo();
//        pageInfo.setAllCount(orderdetailsDao.count());  //总条数
        pageInfo.setAllCount(orderList.size());  //总条数
        pageInfo.setCount(5);  //每页显示的条数
        pageInfo.setAllPage();  //总页数
        pageInfo.setPage(0);  //第一页
        for (Integer i = 0; i < pageInfo.getAllPage(); ) {
            pageInfo.setPage(i);  //第几页
            System.out.println("一共" + pageInfo.getAllPage() + "页，当前是第" + (pageInfo.getPage() + 1) + "页！");
            List<Order> list = orderdetailsDao.selectOrder(orderId, vipId, pageInfo);
            if (list != null && list.size() > 0) {
                ConsoleTable ct = new ConsoleTable();
                ct.addHeader("订单编号", "商品名称", "单价", "折扣", "购买数量", "购买时间", "支付方式", "总价");
                for (Order order : list) {
                    ct.addBody(order.getOrderid().toString(), order.getProductName(), order.getPrice().toString(),
                            order.getDiscount().toString(), order.getNum().toString(), order.getOrderdate().toString(),
                            StateUtils.payType(order.getPaytype()), order.getPrices().toString());
                }
                ct.print();
            }
            System.out.println("1、下一页 2、上一页 0、退出");
            int choose = scanner.nextInt();
            if (choose == 1) {
                if (i == (pageInfo.getAllPage() - 1)) {
                    System.out.println("当前已经是最后一页！");
                } else {
                    i++;
                }
            } else if (choose == 2) {
                if (i == 0) {
                    System.out.println("当前已经是第一页！");
                } else {
                    i--;
                }
            } else if (choose == 0) {
                System.out.println("退出成功");
                return;
            } else {
                System.out.println("无效选择");
            }
        }
    }

    /**
     * 排行统计
     */
    public void rank() {
        System.out.println("超市管理系统>>>收银员操作界面>>>排行统计");
        System.out.println("请输入要统计的月份:");
        scanner.nextLine();
        String mon = scanner.nextLine();
        int month = 0;
        if (!mon.equals("")){
            month = Integer.parseInt(mon);
        }
        List<Rank> list = new ArrayList<>();
        list = orderdetailsDao.rank(month);
        if (month == 0){//查询全部排行
            list = orderdetailsDao.rank();
            if (list == null || list.size() == 0) {
                System.out.println("未查询到任何信息");
                return;
            }
            ConsoleTable ct = new ConsoleTable();
            ct.addHeader("商品名称", "销量", "商品类型");
            for (Rank rank : list) {
                ct.addBody(rank.getName(), rank.getNums().toString(), rank.getType());
            }
            ct.print();
            return;
        }
        if (list == null || list.size() == 0) {
            System.out.println("未查询到任何信息");
            return;
        }
        ConsoleTable ct = new ConsoleTable();
        ct.addHeader("商品名称", "销量", "商品类型", "月份");
        for (Rank rank : list) {
            ct.addBody(rank.getName(), rank.getNums().toString(), rank.getType(), rank.getDate1().toString());
        }
        ct.print();
    }

    /**
     * 模糊查询商品
     *
     * @return
     */
    public List<Product> mohuSelectPro() {
        System.out.println("请输入商品名称(可输入关键字)");
        String name = scanner.next();
        List<Product> list = productDao.getProductBySomeName(name);
        return list;
    }


}
