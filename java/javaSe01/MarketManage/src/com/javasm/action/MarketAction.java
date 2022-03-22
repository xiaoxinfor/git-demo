package com.javasm.action;

import com.javasm.bean.Vip;
import com.javasm.constants.AdminConstants;
import com.javasm.constants.CashierConstants;
import com.javasm.dao.VipDao;
import com.javasm.dao.impl.VipDaoImpl;
import com.javasm.service.AdminService;
import com.javasm.service.CashierService;
import com.javasm.service.VipService;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/21-20:34
 * @Since:jdk1.8
 * @Description:
 */
public class MarketAction {
    private Scanner scanner;
    private AdminService adminService;
    private CashierService cashierService;
    private VipDao vipDao = new VipDaoImpl();

    public MarketAction() {
        scanner = new Scanner(System.in);
        adminService = new AdminService();
        cashierService = new CashierService();
    }

    /**
     * 登录界面菜单
     */
    public void menu() {
        while (true) {
            System.out.println("***********欢迎使用超市管理系统***********");
            System.out.println("1.登录");
            System.out.println("0.退出系统");
            System.out.println("请选择：");
            try {
                int choose = scanner.nextInt();
                switch (choose) {
                    case 1:
                        Log();
                        break;
                    case 0:
                        System.out.println("退出成功，谢谢使用");
                        return;
                }
            } catch (InputMismatchException e) {
                System.out.println("请输入正确的选项");
            }
            scanner.nextLine();
        }
    }

    public void Log() {
        System.out.println("请输入账号");
        String act = scanner.next();
        System.out.println("请输入密码");
        int pwd = scanner.nextInt();
        if (act.equals(AdminConstants.adminAct) && pwd == AdminConstants.adminPwd) {
            System.out.println("欢迎管理员使用");
            adminService.adminOperate();
            return;
        }
        if (act.equals(CashierConstants.CashierAct) && pwd == CashierConstants.CashierPwd) {
            System.out.println("欢迎收银员使用");
            cashierService.cashierOperate();
            return;
        }
        //会员登录
        int a = -1;
        try {
            a = Integer.parseInt(act);
        } catch (NumberFormatException e) {
        }
        Vip vip = vipDao.selectVipByCardNum(a);
        if (a == 1000) {
            System.out.println("非会员账号无权登录");
            return;
        }
        if (vip != null && pwd == vip.getPwd()) {
            System.out.println("欢迎会员使用");
            new VipService().vipOperate(a);
            return;
        }
        System.out.println("抱歉，无此账号和密码，请确认后输入");
    }
}
