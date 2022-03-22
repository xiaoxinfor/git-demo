package com.javasm.service;

import cn.hutool.core.lang.ConsoleTable;
import com.javasm.bean.*;
import com.javasm.constants.AdminConstants;
import com.javasm.dao.ProductDao;
import com.javasm.dao.ProductTypeDao;
import com.javasm.dao.VipDao;
import com.javasm.dao.impl.ProductDaoImpl;
import com.javasm.dao.impl.ProductTypeDaoImpl;
import com.javasm.dao.impl.VipDaoImpl;
import com.javasm.utils.StateUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/21-20:18
 * @Since:jdk1.8
 * @Description:管理员相关操作
 */
public class AdminService {
    private Scanner scanner = new Scanner(System.in);
    private ProductDao productDao = new ProductDaoImpl();
    private ProductTypeDao productTypeDao = new ProductTypeDaoImpl();
    private VipDao vipDao = new VipDaoImpl();

    /**
     * 登录成功后的相关操作
     */
    public void adminOperate() {
        while (true) {
            System.out.println("超市管理系统>>>管理员操作界面");
            System.out.println("1.商品类型管理");
            System.out.println("2.商品管理");
            System.out.println("3.会员管理");
            System.out.println("0.返回上一级");
            System.out.println("请选择");
            switch (scanner.nextInt()) {
                case 1:
                    productTypeManager();
                    break;
                case 2:
                    productManager();
                    break;
                case 3:
                    vipManager();
                    break;
                case 0:
                    System.out.println("返回成功");
                    return;
            }
        }
    }

    /**
     * 商品类型管理
     */
    public void productTypeManager() {
        while (true) {
            System.out.println("超市管理系统>>>管理员操作界面>>>商品类型管理");
            System.out.println("1.添加商品类型信息");
            System.out.println("2.修改商品类型信息");
            System.out.println("3.查询商品类型信息");
            System.out.println("4.删除商品类型信息");
            System.out.println("0.返回上一级");
            switch (scanner.nextInt()) {
                case 1:
                    addProType();
                    break;
                case 2:
                    reviseProType();
                    break;
                case 3:
                    queryProType();
                    break;
                case 4:
                    deleteProType();
                    break;
                case 0:
                    System.out.println("返回成功");
                    return;
            }
        }
    }

    /**
     * 商品管理
     */
    public void productManager() {
        while (true) {
            System.out.println("超市管理系统>>>管理员操作界面>>>商品管理");
            System.out.println("1.添加商品信息");
            System.out.println("2.修改商品信息");
            System.out.println("3.查询商品信息");
            System.out.println("4.删除商品信息");
            System.out.println("0.返回上一级");
            switch (scanner.nextInt()) {
                case 1:
                    addPro();
                    break;
                case 2:
                    revisePro();
                    break;
                case 3:
                    queryPro();
                    break;
                case 4:
                    deletePro();
                    break;
                case 0:
                    System.out.println("返回成功");
                    return;
            }
        }
    }

    /**
     * 会员管理
     */
    public void vipManager() {
        while (true) {
            System.out.println("超市管理系统>>>管理员操作界面>>>会员管理");
            System.out.println("1.添加会员信息");
            System.out.println("2.修改会员信息");
            System.out.println("3.查询会员信息");
            System.out.println("4.删除会员信息");
            System.out.println("5.会员余额充值");
            System.out.println("0.返回上一级");
            switch (scanner.nextInt()) {
                case 1:
                    addVip();
                    break;
                case 2:
                    reviseVip();
                    break;
                case 3:
                    selectVip();
                    break;
                case 4:
                    deleteVip();
                    break;
                case 5:
                    charge();
                    break;
                case 0:
                    System.out.println("返回成功");
                    return;
            }
        }
    }

    /**
     * 添加商品类型信息
     */
    public void addProType() {
        ProductType productType = new ProductType();
        System.out.println("1.添加大类");
        System.out.println("2.添加小类");
        System.out.println("请选择");
        switch (scanner.nextInt()) {
            case 1:
                System.out.println("请添加大类名称：");
                String name1 = scanner.next();
                //查询商品类型表中是否已有该类型名称，如果有，就不能添加
                ProductType productType1 = productTypeDao.getTypeByName(name1);
                if (productType1 != null) {
                    System.out.println("该类型已存在，不能重复添加");
                    return;
                }
                productType.setTypeName(name1);
                //时间
                Date date = new Date();
                productType.setCreateTime(date);
                int i = productTypeDao.addType(productType);
                if (i > 0) {
                    System.out.println("添加成功");
                } else System.out.println("添加失败");
                break;
            case 2:
                List<ProductType> list = new ArrayList<>();
                System.out.println("请添加子类型名称：");
                String name = scanner.next();
                //查询商品类型表中是否已有该类型名称，如果有，就不能添加
                ProductType productType2 = productTypeDao.getTypeByName(name);
                if (productType2 != null) {
                    System.out.println("该类型已存在，不能重复添加");
                    return;
                }
                Date date1 = new Date();
                System.out.println("请选择该类型所属的大类ID");
                showType(1);
                list = productTypeDao.queryType(1);
                int id = scanner.nextInt();
                for (ProductType type : list) {
                    if (id == type.getId()) {
                        //添加
                        int a = productTypeDao.addType(id, name, date1);
                        if (a > 0) {
                            System.out.println("添加成功");
                        } else {
                            System.out.println("添加失败");
                        }
                        return;
                    }
                }
                System.out.println("没有该大类ID，请重新选择");
                break;
        }
    }

    /**
     * 修改商品类型信息
     */
    public void reviseProType() {
        System.out.println("1.修改大类");
        System.out.println("2.修改小类");
        System.out.println("请选择");
        switch (scanner.nextInt()) {
            case 1:
                System.out.println("请输入要修改的大类ID");
                showType(1);
                int id = scanner.nextInt();
                //判断该ID是否在类型表中
                ProductType productType = productTypeDao.getTypeById(id);
                if (productType == null) {
                    System.out.println("未查询到该类型");
                    return;
                }
                if (productType.getFlagParent() == 0) {
                    System.out.println("该类型是小类，请选择修改小类");
                    return;
                }
                System.out.println("需要将该大类修改为小类吗？(y/n)");
                String answer = scanner.next();
                int parentId = -1;
                int flagParent = -1;
                if ("y".equals(answer.toLowerCase())) {
                    //查询该大类下有没有小类，存在小类则不能修改为小类
                    ProductType typeByFID = productTypeDao.getTypeByFID(id);
                    if (typeByFID != null) {
                        System.out.println("该类型下存在小类，不能修改为小类");
                        return;
                    }
                    //能修改为小类
                    System.out.println("请输入修改为小类后所归属的大类ID");
                    parentId = scanner.nextInt();
                    ProductType daoTypeById = productTypeDao.getTypeById(parentId);
                    if (daoTypeById == null) {
                        System.out.println("没有该ID");
                        return;
                    }
                    if (daoTypeById.getFlagParent() == 0) {
                        System.out.println("该ID不是大类");
                        return;
                    }
                    flagParent = 0;
                }
                scanner.nextLine();
                System.out.println("请输入修改后的类型名称");
                String nameP = scanner.nextLine();
                int i = productTypeDao.rereviseType(parentId, nameP, flagParent, id);
                if (i > 0) {
                    System.out.println("修改成功");
                } else System.out.println("修改失败");
                break;
            case 2:
                System.out.println("请输入要修改的小类ID");
                showType(0);
                int id1 = scanner.nextInt();
                ProductType productType1 = productTypeDao.getTypeById(id1);
                if (productType1 == null) {
                    System.out.println("未查询到该类型");
                    return;
                }
                if (productType1.getFlagParent() == 1) {
                    System.out.println("该类型是大类，请选择修改大类");
                    return;
                }
                System.out.println("需要将该小类修改为大类吗？(y/n)");
                String answer1 = scanner.next();
                scanner.nextLine();
                int parentId1 = -1;
                int flagParent1 = -1;
                if ("y".equals(answer1.toLowerCase())) {
                    parentId1 = 0;
                    flagParent1 = 1;
                } else {
                    System.out.println("请输入修改后归属的大类id");
                    showType(1);
                    String parId = scanner.nextLine();
                    if (!parId.equals("")) {
                        try {
                            parentId1 = Integer.parseInt(parId);
                        } catch (NumberFormatException e) {
                            System.out.println("请输入正确的数字");
                            return;
                        }
                        ProductType p = productTypeDao.getTypeById(parentId1);
                        if (p == null) {
                            System.out.println("没有该ID");
                            return;
                        }
                        if (p.getFlagParent() == 0) {
                            System.out.println("该ID不是大类");
                            return;
                        }
                    }
                }
                System.out.println("请输入修改后的类型名称");
                String nameS = scanner.nextLine();
                int i1 = productTypeDao.rereviseType(parentId1, nameS, flagParent1, id1);
                if (i1 > 0) {
                    System.out.println("修改成功");
                } else System.out.println("修改失败");
                break;
        }
    }

    /**
     * 查询商品类型信息
     */
    public void queryProType() {
        System.out.println("商品类型信息");
        List<ProductType> list = new ArrayList<>();
        list = productTypeDao.queryType();
        if (list == null) {
            System.out.println("未查询到任何信息");
            return;
        }
        ConsoleTable consoleTable = new ConsoleTable();
        consoleTable.addHeader("类型ID", "大类ID", "类型名称", "是否是大类", "创建时间", "更新时间");
        for (ProductType type : list) {
            consoleTable.addBody(type.getId().toString(), type.getParentId().toString(), type.getTypeName(),
                    type.getFlagParent() == 1 ? "是" : "否", type.getCreateTime().toString(), type.getUpdateTime().toString());
        }
        consoleTable.print();
    }

    /**
     * 删除商品类型信息
     */
    public void deleteProType() {
        System.out.println("请输入商品类型ID");
        int id = scanner.nextInt();
        ProductType productType = null;
        productType = productTypeDao.getTypeById(id);
        if (productType == null) {
            System.out.println("未找到该商品类型ID，请重新选择");
            return;
        }
        //删除父级
        if (productType.getFlagParent() == 1) {
            //判断父级下有没有子级
            ProductType productType1 = null;
            productType1 = productTypeDao.getTypeByFID(id);
            if (productType1 == null) {
                //在判断父级下有没有商品
                List<ProAndProType> list = productTypeDao.getTypeByProId();
                if (list == null && list.size() == 0) {
                    //没有子级，商品，可直接删除
                    int i = productTypeDao.deleteType(id);
                    if (i > 0) {
                        System.out.println("删除成功");
                    } else {
                        System.out.println("删除失败");
                    }
                } else {
                    System.out.println("该大类下存在商品，请先将商品删除");
                    return;
                }
            } else {
                System.out.println("该大类下存在小类，请先将小类删除");
                return;
            }
        }
        //删除子级类型
        if (productType.getFlagParent() == 0) {
            //判断子级类型下有没有商品
            List<ProAndProType> list = new ArrayList<>();
            list = productTypeDao.queryProAndType(id);
            if (list == null || list.size() == 0) {
                //该子类型下没有商品，可直接删除
                int i = productTypeDao.deleteType(id);
                if (i > 0) {
                    System.out.println("删除成功");
                } else {
                    System.out.println("删除失败");
                }
            } else {
                System.out.println("该小类下存在商品，请删除该类下的商品后再删除");
            }
        }
    }


    /**
     * 添加商品信息
     */
    public void addPro() {
        System.out.println("请输入您要添加的商品名称：");
        String productName = scanner.next();
        Product product = productDao.getProductByName(productName);
        if (product != null) {
            System.out.println("该商品以存在，不能重复添加相同商品");
            return;
        }
        Product product1 = new Product();
        product1.setProductName(productName);
        System.out.println("请输入价格：");
        product1.setPrice(scanner.nextDouble());
        System.out.println("请输入商品数量：");
        product1.setNum(scanner.nextInt());
        System.out.println("请输入商品折扣：");
        product1.setDiscount(scanner.nextInt());
        System.out.println("请输入商品的类别：");
        //查询有哪些类别
        showType(0);
        product1.setTypeid(scanner.nextInt());
        System.out.println("请输入商品状态(1.上架，2.下架，3.删除)：");
        product1.setState(scanner.nextInt());
        int i = productDao.addProduct(product1);
        if (i > 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败，请重新添加");
        }
    }

    /**
     * 修改商品信息
     */
    public void revisePro() {
        productMohu();
        System.out.println("请输入商品的编号ID：");
        int id = scanner.nextInt();
        scanner.nextLine();
        try {
            Product product = productDao.getProductById(id);
            if (product != null) {
                //修改操作
                System.out.println("请输入修改后的商品名称：");
                String productName = scanner.nextLine();
                System.out.println("请输入修改后的商品价格：");
                String pr = scanner.nextLine();
                double price = 0.0;
                if (!pr.equals("")) {
                    price = Double.parseDouble(pr);
                }
                System.out.println("请输入修改后的商品数量：");
                String nu = scanner.nextLine();
                int num = -1;
                if (!nu.equals("")) {
                    num = Integer.parseInt(nu);
                }
                System.out.println("请输入修改后的商品折扣：");
                String dis = scanner.nextLine();
                int discount = 0;
                if (!dis.equals("")) {
                    discount = Integer.parseInt(dis);
                }
                System.out.println("请输入修改后的商品类型：");
                showType(0);
                String ty = scanner.nextLine();
                int typeid = 0;
                if (!ty.equals("")) {
                    typeid = Integer.parseInt(ty);
                }
                System.out.println("请输入修改后的商品状态(1.上架，2.下架，3.删除)：");
                String st = scanner.nextLine();
                int state = 0;
                if (!st.equals("")) {
                    state = Integer.parseInt(st);
                }
                int i = productDao.reviseProduct(productName, price, num, discount, typeid, state, id);
                if (i > 0) {
                    System.out.println("修改成功");
                }
            } else {
                System.out.println("未找到该商品，请重新输入");
            }
        } catch (NumberFormatException e) {
            System.out.println("输入的数据类型错误");
        }
    }

    /**
     * 查询商品信息
     */
    public void queryPro() {
        //分页对象
        PageInfo pageInfo = new PageInfo();
        pageInfo.setAllCount(productDao.countProduct());  //总条数
        pageInfo.setCount(5);  //每页显示的条数
        pageInfo.setAllPage();  //总页数
        pageInfo.setPage(0);  //第一页

        System.out.println("商品信息");
        for (Integer i = 0; i < pageInfo.getAllPage(); ) {
            pageInfo.setPage(i);  //第几页
            System.out.println("一共" + pageInfo.getAllPage() + "页，当前是第" + (pageInfo.getPage() + 1) + "页！");
            List<ProAndProType> list = productDao.queryProduct(pageInfo);
            if (list != null && list.size() > 0) {
                ConsoleTable ct = new ConsoleTable();
                ct.addHeader("商品ID", "商品名称", "单价", "商品库存", "折扣", "商品类型", "状态");
                for (ProAndProType proType : list) {
                    ct.addBody(proType.getId().toString(), proType.getProductName(), proType.getPrice().toString(),
                            proType.getNum().toString(), proType.getDiscount().toString(), proType.getTypeName(), StateUtils.zhuan(proType.getState()));
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
     * 删除商品信息
     */
    public void deletePro() {
        productMohu();
        System.out.println("请选择您要删除的商品ID");
        int productId = scanner.nextInt();
        Product product = productDao.getProductById(productId);
        if (product == null) {
            System.out.println("没有该商品ID，请重新输入");
            return;
        }
        int a = productDao.deleteProduct(productId);
        if (a > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    /**
     * 添加新会员
     */
    public void addVip() {
        System.out.println("请输入要增加的会员号：");
        int cardNumber = scanner.nextInt();
        //先查询该会员号是否存在,不存在才能添加
        Vip vip = vipDao.selectVipByCardNum(cardNumber);
        if (vip != null) {
            System.out.println("该会员号已存在，不能添加");
            return;
        }
        Vip vip1 = new Vip();
        vip1.setCardnumber(cardNumber);
        System.out.println("请输入要增加的会员姓名：");
        vip1.setVipname(scanner.next());
        System.out.println("请输入要增加的会员电话号码：");
        vip1.setIphone(scanner.next());
        //新增加的会员积分为0
        vip1.setJifen(0);
        System.out.println("请输入要增加的会员余额：");
        vip1.setMoney(scanner.nextDouble());
        //增加会员时间
        Date date = new Date();
        vip1.setCreateTime(date);
        System.out.println("请设置该会员密码：");
        vip1.setPwd(scanner.nextInt());
        int i = vipDao.addVip(vip1);
        if (i > 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }

    /**
     * 修改会员信息
     */
    private void reviseVip() {
        System.out.println("请输入您要修改的会员号");
        int cardNumber = scanner.nextInt();
        if (cardNumber == 1000) {
            System.out.println("1000无权限操作，请选择其他会员号");
            return;
        }
        //查找有没有该会员号，有则修改
        Vip vip = vipDao.selectVipByCardNum(cardNumber);
        if (vip == null) {
            System.out.println("该会员号不存在，不能修改");
            return;
        }
        Vip vip1 = new Vip();
        vip1.setCardnumber(cardNumber);
        scanner.nextLine();
        System.out.println("请输入修改后的会员姓名：");
        vip1.setVipname(scanner.nextLine());
        System.out.println("请输入修改后的会员电话号码：");
        vip1.setIphone(scanner.nextLine());
        System.out.println("请输入修改后的会员积分");
        String s = scanner.nextLine();
        if (!s.equals("")) {
            vip1.setJifen(Integer.parseInt(s));
        } else {
            vip1.setJifen(0);
        }
        System.out.println("请输入修改后的会员余额：");
        String s1 = scanner.nextLine();
        if (!s1.equals("")) {
            vip1.setMoney(Double.parseDouble(s1));
        } else {
            vip1.setMoney(0.0);
        }
        int i = vipDao.reviseVip(vip1);
        if (i > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
    }

    /**
     * 查询会员信息
     */
    public void selectVip() {
        List<Vip> list = vipDao.selectVip();
        if (list == null || list.size() == 0) {
            System.out.println("未查询到任何会员信息");
            return;
        }
        ConsoleTable ct = new ConsoleTable();
        ct.addHeader("会员ID", "会员号码", "会员名称", "联系方式", "积分", "余额", "创建时间", "更新时间");
        for (Vip vip : list) {
            if (vip.getCardnumber() != 1000) {
                ct.addBody(vip.getId().toString(), vip.getCardnumber().toString(), vip.getVipname(), vip.getIphone(),
                        vip.getJifen().toString(), vip.getMoney().toString(), vip.getCreateTime().toString(),
                        vip.getUpdateTime().toString());
            }
        }
        ct.print();
    }

    /**
     * 删除会员
     */
    public void deleteVip() {
        System.out.println("请输入您要删除的会员号");
        int cardNumber = scanner.nextInt();
        if (cardNumber == 1000) {
            System.out.println("1000无权限操作，请选择其他会员号");
            return;
        }
        //查找有没有该会员号，有则删除
        Vip vip = vipDao.selectVipByCardNum(cardNumber);
        if (vip == null) {
            System.out.println("该会员号不存在，不能删除");
            return;
        }
        if (vip.getJifen() != 0) {
            System.out.println("该会员还存在积分，不能删除");
            return;
        }
        if (vip.getMoney() != 0) {
            System.out.println("该会员账号内还存在余额，不能删除");
            return;
        }
        int i = vipDao.deleteVip(cardNumber);
        if (i > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    /**
     * 会员余额充值
     */
    public void charge() {
        System.out.println("请选择充值的会员账号：");
        int cardNumber = scanner.nextInt();
        if (cardNumber == 1000) {
            System.out.println("1000无权限操作，请选择其他会员号");
            return;
        }
        //查找有没有该会员号，有则充值
        Vip vip = vipDao.selectVipByCardNum(cardNumber);
        if (vip == null) {
            System.out.println("该会员号不存在，不能充值");
            return;
        }
        System.out.println("请输入充值的金额：");
        double money = scanner.nextDouble();
        int i = vipDao.chargeVip(money, cardNumber);
        if (i > 0) {
            System.out.println("充值成功");
        } else System.out.println("充值失败");
    }

    /**
     * 显示类型列表
     *
     * @param flag
     */
    public void showType(int flag) {
        List<ProductType> list = productTypeDao.queryType(flag);
        //显示父类型的类型信息
        ConsoleTable ct = new ConsoleTable();
        ct.addHeader("类型ID", "类型名称");
        for (ProductType type : list) {
            ct.addBody(type.getId().toString(), type.getTypeName());
        }
        ct.print();
    }

    public void productMohu() {
        //模糊查询商品
        List<Product> list = new CashierService().mohuSelectPro();
        //展示
        ConsoleTable consoleTable = new ConsoleTable();
        consoleTable.addHeader("商品ID", "商品名称", "商品价格", "库存", "折扣");
        for (Product product : list) {
            consoleTable.addBody(product.getId().toString(), product.getProductName(), product.getPrice().toString(),
                    product.getNum().toString(), product.getDiscount().toString());
        }
        consoleTable.print();
    }
}

