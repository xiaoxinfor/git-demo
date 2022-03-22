package com.javasm.atm.action;

import com.javasm.atm.bean.AtmUser;
import com.javasm.atm.constants.UserConstants;
import com.javasm.atm.exception.AtmException;

import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/10-17:28
 * @Since:jdk1.8
 * @Description:
 */
public class AtmAction {
    Scanner scanner = new Scanner(System.in);
    //操作用户
    private AtmUser atmUser;

    //构造方法
    public AtmAction() {
        atmUser = new AtmUser(UserConstants.User1_Id, UserConstants.User1_Pwd, 10000, UserConstants.name1);
    }

    /**
     * 启动菜单
     */
    public void start() {
        while (true) {
            System.out.println("欢迎使用ATM管理系统");
            System.out.println("1.登录");
            System.out.println("0.退出");
            System.out.println("请选择：");
            int choose = scanner.nextInt();
            if (choose == 1) {
                try {
                    login();
                } catch (AtmException e) {
                    System.out.println(e.getMessage());
                }
            } else if (choose == 0) {
                System.out.println("退出成功");
                return;
            }else System.out.println("无该项选择。");
        }
    }

    /**
     * 登录
     * 自定义一个异常然后将异常抛出
     */
    public void login() throws AtmException {
        System.out.println("请输入登录的卡号：");
        String inputId = scanner.next();
        System.out.println("请输入密码");
        int inputPwd = scanner.nextInt();
        //卡号输入错误
        if (!inputId.equals(atmUser.getIdCard())) {
            throw new AtmException("卡号不存在");
        } else if (!inputId.equals(atmUser.getIdCard()) || inputPwd != atmUser.getPassword()) {
            throw new AtmException("卡号或密码错误");
        }
        System.out.println("登陆成功");
        menu();
    }

    /**
     * 修改密码
     *
     * @throws AtmException
     */
    public void gaiPwd() throws AtmException {
        System.out.println("ATM管理系统>>>修改密码");
        System.out.println("请输入您的新密码");
        int newPwd = scanner.nextInt();
        System.out.println("请确认您的新密码");
        int newPwd1 = scanner.nextInt();
        if (newPwd != newPwd1) {
            throw new AtmException("两次密码不一致，请重新输入。");
        }
        //密码修改成功
        atmUser.setPassword(newPwd);
    }

    /**
     * 取款
     *
     * @throws AtmException
     */
    public void qu() throws AtmException {
        System.out.println("ATM管理系统>>>用户取款");
        System.out.println("请输入取款金额：");
        double inputBalance = scanner.nextDouble();
        if (inputBalance % 100 != 0) {
            throw new AtmException("取款金额只能为整百");
        } else if (inputBalance < 100) {
            throw new AtmException("取款最小金额为100");
        } else if (inputBalance > 10000) {
            throw new AtmException("取款金额最高不能超过一万");
        } else if (inputBalance > atmUser.getBalance()) {
            throw new AtmException("余额不足");
        }

        //输入无异常，取款成功
        atmUser.setBalance(atmUser.getBalance() - inputBalance);//取款后的余额
        System.out.println("取款成功");
    }

    /**
     * 存款
     *
     * @throws AtmException
     */
    public void cun() throws AtmException {
        System.out.println("ATM管理系统>>>用户取款");
        System.out.println("请输入存款金额：");
        double inputBalance = scanner.nextDouble();
        if (inputBalance % 100 != 0) {
            throw new AtmException("存款金额只能为整百");
        } else if (inputBalance < 100) {
            throw new AtmException("存款最小金额为100");
        } else if (inputBalance > 10000) {
            throw new AtmException("存款金额最高不能超过一万");
        }
        //输入无异常，取款成功
        atmUser.setBalance(atmUser.getBalance() + inputBalance);//存款后的余额
        System.out.println("存款成功");
    }

    /**
     * 转账
     */
    public void zhuanZhang() throws AtmException {
        System.out.println("ATM管理系统>>>转账");
        System.out.println("请输入您要转账的账户卡号");
        String inputId = scanner.next();
        System.out.println("请再次确认要转账的卡号");
        String inputId1 = scanner.next();
        if (!inputId.equals(inputId1)) {
            throw new AtmException("抱歉，两次输入不一致，请确认后输入");
        }
        if (!inputId1.equals(UserConstants.User2_Id)) {
            throw new AtmException("抱歉，未查询到该用户，请确认后输入");
        }
        System.out.println("请确认对方的姓名：");
        String inputName = scanner.next();
        if (!inputName.equals(UserConstants.name2)) {
            throw new AtmException("抱歉，卡号和姓名不一致，请重新输入");
        }
        System.out.println("请输入您要转账的金额：");
        double inputBalance = scanner.nextDouble();
        if (inputBalance > atmUser.getBalance()) {
            throw new AtmException("抱歉，余额不足");
        }
        atmUser.setBalance(atmUser.getBalance() - inputBalance);
        System.out.println("转账成功");
    }

    /**
     * 主菜单
     */
    public void menu() {
        while (true) {
            System.out.println("《《《欢迎使用ATM管理系统》》》");
            System.out.println("1.修改登录密码");
            System.out.println("2.取款");
            System.out.println("3.存款");
            System.out.println("4.查询余额");
            System.out.println("5.转账");
            System.out.println("0.返回登录界面");
            System.out.println("6.请选择");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    try {
                        gaiPwd();
                    } catch (AtmException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        qu();
                    } catch (AtmException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        cun();
                    } catch (AtmException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("您的余额为" + atmUser.getBalance());
                    break;
                case 5:
                    try {
                        zhuanZhang();
                    } catch (AtmException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 0:
                    return;
            }
        }
    }
}
