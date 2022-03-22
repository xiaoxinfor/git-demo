package com.javasm.action;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/6-18:18
 * @Since:jdk1.8
 * @Description:
 */

import com.javasm.service.MemberService;
import com.javasm.service.impl.MemberServiceImpl;

import java.util.Scanner;

public class MemberAction {
    private MemberService memberService;

    public MemberAction() {
        memberService = new MemberServiceImpl();
    }

    /**
     * 会员管理
     */
    public void memberMenu(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("书店管理销售系统>会员管理");
            System.out.println("*********************************");
            System.out.println("1.显 示 所 有 会 员 信 息");
            System.out.println("2.添 加 会 员 信 息");
            System.out.println("3.修 改 会 员 信 息");
            System.out.println("4.返 回 主 菜 单");
            System.out.println("*********************************");
            System.out.println("请选择");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    memberService.show();
                    break;
                case 2:
                    memberService.add();
                    break;
                case 3:
                    memberService.upadte();
                    break;
                case 4:
                    return;
            }
        }
    }
}
