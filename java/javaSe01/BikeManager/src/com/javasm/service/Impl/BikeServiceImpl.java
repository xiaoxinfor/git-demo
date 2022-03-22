package com.javasm.service.Impl;

import cn.hutool.core.lang.ConsoleTable;
import com.javasm.bean.Bike;
import com.javasm.bean.BikeCompany;
import com.javasm.service.BikeService;
import com.javasm.util.BikeUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/13-16:44
 * @Since:jdk1.8
 * @Description:接口的实现类
 */
public class BikeServiceImpl implements BikeService {
    /**
     * 投放单车
     *
     * @param bikeCompanies
     * @param scanner
     */
    @Override
    public void putBike(BikeCompany[] bikeCompanies, Scanner scanner) {
        System.out.println("单车管理系统》》投放单车");
        for (BikeCompany company : bikeCompanies) {
            System.out.println(company.getCompanyId() + "--------->" + company.getBikeCompany());
        }
        System.out.println("请选择要投放的单车品牌");
        int inputId = scanner.nextInt();
        //接收getBikeCompanyById方法的返回值
        BikeCompany bikeCompany = getBikeCompanyById(inputId, bikeCompanies);
        if (bikeCompany == null) {
            System.out.println("没有该单车品牌，请重新选择");
            return;
        }
        //该公司单车信息
        Bike[] bikes = bikeCompany.getBikes();
        //扩容之前的数组大小
        int len = bikes.length;
        System.out.println("请输入要投放的数量");
        int inputNum = scanner.nextInt();
        //投放车辆需要扩容
        bikes = Arrays.copyOf(bikes, bikes.length + inputNum);
        System.out.println("空间不足，已参照配置扩容！");
        //获取扩容之前最后索引位置的Id
        int id = bikes[len - 1].getBikeId();
        //往扩容之后的数组中添加数据
        for (int i = len; i < bikes.length; i++) {
            id++;
            Bike putBike = new Bike(id, bikeCompany.getBikeCompany() + id, 1, null, null);
            bikes[i] = putBike;
        }
        //将扩容之后的数组存入公司
        bikeCompany.setBikes(bikes);
        //修改单车的总数
        bikeCompany.setSum(bikes.length);
        System.out.println("投放" + inputNum + "辆" + bikeCompany.getBikeCompany() + "单车成功");
    }

    /**
     * 显示单车
     *
     * @param bikeCompany
     */
    @Override
    public void showBike(BikeCompany[] bikeCompany) {
        System.out.println("单车管理系统》查看单车");
        //拿到公司信息
        for (BikeCompany company : bikeCompany) {
            ConsoleTable consoleTable = new ConsoleTable();
            consoleTable.addHeader("公司序号", "公司名称", "单车数量", "单车借出次数");
            consoleTable.addBody(company.getCompanyId().toString(), company.getBikeCompany(), company.getSum().toString(), company.getCount().toString());
            //这个公司下的单车信息
            ConsoleTable consoleTable1 = new ConsoleTable();
            consoleTable1.addHeader("单车编号", "单车名称", "单车状态", "借出时间", "归还时间");
            Bike[] bikes = company.getBikes();
            for (Bike bike : bikes) {
                consoleTable1.addBody(bike.getBikeId().toString(), bike.getBikeName(), BikeUtil.getBikeStateStr(bike.getStatus()),
                        BikeUtil.getTimeStr(bike.getBorrowTime()), BikeUtil.getTimeStr(bike.getReturnTime()));
            }
            consoleTable.print();
            consoleTable1.print();
        }
    }

    /**
     * 删除单车
     *
     * @param bikeCompanies
     * @param scanner
     */
    @Override
    public void deleteBike(BikeCompany[] bikeCompanies, Scanner scanner) {
        System.out.println("单车管理系统>>删除单车");
        for (BikeCompany company : bikeCompanies) {
            System.out.println(company.getCompanyId() + "--------->" + company.getBikeCompany());
        }
        System.out.println("请选择要删除的单车品牌");
        int inputId = scanner.nextInt();
        BikeCompany bikeCompany = getBikeCompanyById(inputId, bikeCompanies);
        if (bikeCompany == null) {
            System.out.println("没有该单车品牌，请重新输入");
            return;
        }
        System.out.println(bikeCompany.getBikeCompany() + "有共享单车如下");
        ConsoleTable consoleTable = new ConsoleTable();
        consoleTable.addHeader("单车编号", "单车名称", "单车状态", "借出时间", "归还时间");
        Bike[] bikes = bikeCompany.getBikes();
        for (Bike bike : bikes) {
            consoleTable.addBody(bike.getBikeId().toString(), bike.getBikeName(), BikeUtil.getBikeStateStr(bike.getStatus()),
                    BikeUtil.getTimeStr(bike.getBorrowTime()), BikeUtil.getTimeStr(bike.getReturnTime()));
        }
        consoleTable.print();
        System.out.println("请输入要删除单车的编号");
        int inputBikeId = scanner.nextInt();
        Bike bike = getBikeById(inputBikeId, bikes);
        if (bike == null) {
            System.out.println("没找到该车辆，请重新输入");
            return;
        }
        //已借出的车不能删除
        if (bike.getStatus() == 0) {
            System.out.println("该车辆已借出，暂不能删除。");
            return;
        }
        int index = -1;//这辆单车在数组中的索引
        for (int i = 0; i < bikes.length; i++) {
            if (inputBikeId == bikes[i].getBikeId()) {
                index = i;
                break;
            }
        }
        //前一个元素被后一个元素覆盖
        for (int i = index + 1; i < bikes.length; i++) {
            bikes[i - 1] = bikes[i];
            //编号没改
        }
        //缩容
        bikes = Arrays.copyOf(bikes, bikes.length - 1);
        //将缩减后的数组存入公司
        bikeCompany.setBikes(bikes);

        //修改单车数量
        bikeCompany.setSum(bikes.length);
        System.out.println("删除" + bikeCompany.getBikeCompany() + "公司的" + bike.getBikeName() + "成功");
    }

    /**
     * 借出车辆
     *
     * @param bikeCompanies
     * @param scanner
     */
    @Override
    public void jieChuBike(BikeCompany[] bikeCompanies, Scanner scanner) {
        System.out.println("单车管理系统>>借出单车");
        for (BikeCompany company : bikeCompanies) {
            System.out.println(company.getCompanyId() + "--------->" + company.getBikeCompany());
        }
        System.out.println("请选择要借出的单车品牌");
        int inputId = scanner.nextInt();
        BikeCompany bikeCompany = getBikeCompanyById(inputId, bikeCompanies);
        if (bikeCompany == null) {
            System.out.println("没有该单车品牌，请重新输入");
            return;
        }
        Bike[] bikes = bikeCompany.getBikes();
        int i = 0;//计算有多少辆可借出的车
        for (Bike bike : bikes) {
            if (bike.getStatus() == 1){
                i++;
            }
        }
        if (i == 0){
            System.out.println("该公司下无可借出的车");
            return;
        }
        System.out.println(bikeCompany.getBikeCompany() + "有共享单车如下");
        ConsoleTable consoleTable = new ConsoleTable();
        consoleTable.addHeader("单车编号", "单车名称", "单车状态", "借出时间", "归还时间");

        for (Bike bike : bikes) {
            if (bike.getStatus() == 1) {
                consoleTable.addBody(bike.getBikeId().toString(), bike.getBikeName(), BikeUtil.getBikeStateStr(bike.getStatus()),
                        BikeUtil.getTimeStr(bike.getBorrowTime()), BikeUtil.getTimeStr(bike.getReturnTime()));
            }
        }
        consoleTable.print();
        System.out.println("请输入要借出单车的编号");
        int inputBikeId = scanner.nextInt();
        Bike bike = getBikeById(inputBikeId, bikes);
        if (bike == null) {
            System.out.println("没找到该车辆，请重新输入");
            return;
        }
        //已借出的车不能再借
        if (bike.getStatus() == 0) {
            System.out.println("该车辆已借出，暂不能删除。");
            return;
        }

        System.out.println("请输入借出日期（yyyy-MM-dd HH:mm:ss）：");
        String zz = scanner.nextLine();//接收一个回车
        String inputTime = scanner.nextLine();
        bike.setBorrowTime(inputTime);
        //修改该辆单车的状态
        bike.setStatus(0);

        System.out.println("借出" + bikeCompany.getBikeCompany() + "公司的" + bike.getBikeName() + "成功");
    }

    /**
     * 根据公司编号查找公司信息
     *
     * @param id
     * @param bikeCompanies
     * @return
     */
    private BikeCompany getBikeCompanyById(int id, BikeCompany[] bikeCompanies) {
        BikeCompany bikeCompany = null;//没找到就为空
        for (BikeCompany company : bikeCompanies) {
            if (id == company.getCompanyId()) {
                bikeCompany = company;
            }
        }
        return bikeCompany;
    }

    /**
     * 归还单车
     *
     * @param bikeCompanies
     * @param scanner
     */
    @Override
    public void returnBike(BikeCompany[] bikeCompanies, Scanner scanner) {
        System.out.println("单车管理系统>>归还单车");
        for (BikeCompany company : bikeCompanies) {
            System.out.println(company.getCompanyId() + "--------->" + company.getBikeCompany());
        }
        System.out.println("请选择要归还的单车品牌");
        int inputId = scanner.nextInt();
        BikeCompany bikeCompany = getBikeCompanyById(inputId, bikeCompanies);
        if (bikeCompany == null) {
            System.out.println("没有该单车品牌，请重新输入");
            return;
        }
        Bike[] bikes = bikeCompany.getBikes();
        int i = 0;//计算有多少辆借出的车
        for (Bike bike : bikes) {
            if (bike.getStatus() == 0){
                i++;
            }
        }
        if (i == 0){
            System.out.println("该公司下无借出的车，无需归还");
            return;
        }
        System.out.println(bikeCompany.getBikeCompany() + "有共享单车如下");
        ConsoleTable consoleTable = new ConsoleTable();
        consoleTable.addHeader("单车编号", "单车名称", "单车状态", "借出时间", "归还时间");
        for (Bike bike : bikes) {
            if (bike.getStatus() == 0) {
                consoleTable.addBody(bike.getBikeId().toString(), bike.getBikeName(), BikeUtil.getBikeStateStr(bike.getStatus()),
                        BikeUtil.getTimeStr(bike.getBorrowTime()), BikeUtil.getTimeStr(bike.getReturnTime()));
            }
        }
        consoleTable.print();
        System.out.println("请输入要归还单车的编号");
        int inputBikeId = scanner.nextInt();
        Bike bike = getBikeById(inputBikeId, bikes);
        if (bike == null) {
            System.out.println("没找到该车辆，请重新输入");
            return;
        }
        //未借出的车不能归还
        if (bike.getStatus() == 1) {
            System.out.println("该车辆未借出，不能归还。");
            return;
        }
        System.out.println("请输入归还日期（yyyy-MM-dd HH:mm:ss）：");
        String zz = scanner.nextLine();//接收一个回车
        String inputTime = scanner.nextLine();
        bike.setReturnTime(inputTime);
        //拿到该车辆的借出归还时间   String转成Date
        Date dateBorrowTime = dateTime(bike.getBorrowTime());
        Date dateReturnTime = dateTime(bike.getReturnTime());
        //日期差
        long charge = (dateReturnTime.getTime() - dateBorrowTime.getTime()) / (60 * 1000);//相差的分钟
        //租金一分钟0.02元
        double money = charge * 0.02;
        System.out.println("您的借车时间为:" + bike.getBorrowTime());
        System.out.println("您的用车时间为<<" + charge + ">>分钟，需支付：" + money + "元");
        //借出次数加1
        bikeCompany.setCount(bikeCompany.getCount() + 1);
        bike.setStatus(1);//归还成功变为可借状态
        //将借出归还时间置空
        bike.setReturnTime(null);
        bike.setBorrowTime(null);
    }

    /**
     * 借车次数排行
     *
     * @param bikeCompanies
     * @return
     */
    @Override
    public BikeCompany[] sortBike(BikeCompany[] bikeCompanies) {
        System.out.println("单车管理系统>>借车次数排行榜");
        BikeCompany temp = null;
        //冒泡排序
        for (int i = 0; i < bikeCompanies.length - 1; i++) {
            for (int j = 0; j < bikeCompanies.length - i - 1; j++) {
                if (bikeCompanies[j].getCount() > bikeCompanies[j + 1].getCount()) {
                    temp = bikeCompanies[j];
                    bikeCompanies[j] = bikeCompanies[j + 1];
                    bikeCompanies[j + 1] = temp;
                }
            }
        }
        return bikeCompanies;
    }

    /**
     * 根据单车编号查找该单车信息
     *
     * @param bikeId
     * @param bikes
     * @return
     */
    private Bike getBikeById(int bikeId, Bike[] bikes) {
        Bike bike = null;
        for (Bike bike1 : bikes) {
            if (bikeId == bike1.getBikeId()) {
                bike = bike1;
            }
        }
        return bike;
    }

    /**
     * String转成Date
     *
     * @param time
     * @return
     */
    private Date dateTime(String time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateTime = null;
        try {
            dateTime = sdf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateTime;
    }
}
