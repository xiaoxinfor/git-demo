package com.javasm.action;

import cn.hutool.core.lang.ConsoleTable;
import com.javasm.bean.Bike;
import com.javasm.bean.BikeCompany;
import com.javasm.constants.BikeConstants;
import com.javasm.service.BikeService;
import com.javasm.service.Impl.BikeServiceImpl;

import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/13-16:06
 * @Since:jdk1.8
 * @Description:
 */
public class BikeAction {
    private Scanner scanner;
    private BikeCompany[] bikeCompanies;//多个公司
    private BikeService bikeService;//接口

    /**
     * 无参构造
     */
    public BikeAction() {
        scanner = new Scanner(System.in);
        bikeService = new BikeServiceImpl();
        init();
    }

    /**
     * 数据初始化
     */
    private void init() {
        bikeCompanies = new BikeCompany[3];//三家公司
        //<<第一家>>
        BikeCompany ofo = new BikeCompany("ofo", 1, null, 10, 123);
        //车类型的数组
        Bike[] ofoBike = new Bike[ofo.getSum()];//这公司有多少车
        //循环添加车的信息
        for (int i = 0; i < ofo.getSum(); i++) {
            int id = 100 + i;
            ofoBike[i] = new Bike(id, BikeConstants.COMPANY_OFO + id, 1, null, null);
        }
        //将ofo单车添加到ofo公司
        ofo.setBikes(ofoBike);
        //将ofo添加到公司
        bikeCompanies[0] = ofo;

        //《第二家》
        BikeCompany haLuo = new BikeCompany("哈啰", 2, null, 10, 100);
        Bike[] haLuoBike = new Bike[haLuo.getSum()];
        for (int i = 0; i < haLuo.getSum(); i++) {
            int id = 200 + i;
            haLuoBike[i] = new Bike(id, BikeConstants.COMPANY_HALUO + id, 1, null, null);
        }
        haLuo.setBikes(haLuoBike);
        bikeCompanies[1] = haLuo;

        //第三家公司
        BikeCompany moBai = new BikeCompany("摩拜", 3, null, 11, 200);
        Bike[] moBaiBike = new Bike[moBai.getSum()];
        for (int i = 0; i < moBai.getSum(); i++) {
            int id = 300 + i;
            moBaiBike[i] = new Bike(id, BikeConstants.COMPANY_MOBAI + id, 1, null, null);
        }
        moBai.setBikes(moBaiBike);
        bikeCompanies[2] = moBai;
    }

    /**
     * 菜单
     */
    public void menu() {
        boolean b = true;
        while (b) {
            System.out.println("欢迎使用迷你共享单车管理系统");
            System.out.println("********************************************");
            System.out.println("1.投放单车");
            System.out.println("2.查看单车");
            System.out.println("3.删除单车");
            System.out.println("4.借出单车");
            System.out.println("5.归还单车");
            System.out.println("6.单车排行榜");
            System.out.println("0.退出");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    bikeService.putBike(bikeCompanies, scanner);
                    break;
                case 2:
                    bikeService.showBike(bikeCompanies);
                    break;
                case 3:
                    bikeService.deleteBike(bikeCompanies, scanner);
                    break;
                case 4:
                    bikeService.jieChuBike(bikeCompanies, scanner);
                    break;
                case 5:
                    bikeService.returnBike(bikeCompanies, scanner);
                    break;
                case 6:
                    BikeCompany[] bikeCompanies1 = bikeService.sortBike(bikeCompanies);
                    xianShi(bikeCompanies1);
                    break;
                case 0:
                    b = false;
                    break;
            }
        }
    }

    //显示
    public void xianShi(BikeCompany[] bikeCompanies) {
        ConsoleTable consoleTable = new ConsoleTable();
        consoleTable.addHeader("公司序号", "公司名称", "单车数量", "单车借出次数");
        for (BikeCompany company : bikeCompanies) {
            consoleTable.addBody(company.getCompanyId().toString(), company.getBikeCompany(), company.getSum().toString(), company.getCount().toString());
        }
        consoleTable.print();
    }
}
