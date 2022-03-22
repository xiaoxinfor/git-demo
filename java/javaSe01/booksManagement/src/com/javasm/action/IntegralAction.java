package com.javasm.action;

import com.javasm.service.IntegralService;
import com.javasm.service.impl.IntegrarServiceImpl;

import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/6-18:56
 * @Since:jdk1.8
 * @Description:
 */
public class IntegralAction {
    private IntegralService integralService;
    private Scanner scanner;
    public IntegralAction() {
        integralService = new IntegrarServiceImpl();
        scanner = new Scanner(System.in);
    }

    /**
     * 积分兑换礼品
     */
    public void integralMenu(){
        System.out.println("书店管理销售系统>积分兑换礼品");
        System.out.println("*************礼品清单*************");
        integralService.show();
        System.out.println("*********************************");
        System.out.println("请输入会员号：");
        int memberId = scanner.nextInt();
        //验证是否有该会员号
        boolean b = integralService.yanZheng(memberId);
        if (!b){
            System.out.println("没有该会员号，请重新输入");
            return;
        }
        System.out.println("请选择您要兑换的礼品编号：");
        int giftId = scanner.nextInt();
        integralService.getGift(giftId,memberId);
    }
}
