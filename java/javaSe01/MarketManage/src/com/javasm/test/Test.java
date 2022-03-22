package com.javasm.test;

import com.javasm.bean.Vip;
import com.javasm.dao.VipDao;
import com.javasm.dao.impl.VipDaoImpl;

import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/22-20:01
 * @Since:jdk1.8
 * @Description:
 */
public class Test {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("请输入修改后的商品名称");
            String productName = scanner.nextLine();
            System.out.println("请输入修改后的商品价格");
            String pr = scanner.nextLine();
            double price = 0.0;
            if (!pr.equals("")){
                price = Double.parseDouble(pr);
            }
            System.out.println("请输入修改后的商品数量");
            String nu = scanner.nextLine();
            int num = 0;
            if (!nu.equals("")){
                num = Integer.parseInt(nu);
            }
            System.out.println("请输入修改后的商品折扣");
            String dis = scanner.nextLine();
            int discount = 0;
            if (!dis.equals("")){
                discount = Integer.parseInt(dis);
            }
            System.out.println("请输入修改后的商品类型");
            String ty = scanner.nextLine();
            int typeid = 0;
            if (!ty.equals("")){
                typeid = Integer.parseInt(ty);
            }
            System.out.println("请输入修改后的商品状态");
            String st = scanner.nextLine();
            int state = 0;
            if (!st.equals("")){
                state = Integer.parseInt(st);
            }
        }catch (NumberFormatException e){

        }



    }
}
