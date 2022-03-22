package javasm.demo;

import javasm.bean.Food;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/6-15:40
 * @Since:jdk1.8
 * @Description:
 */
public class FoodDemo {
    //所有菜品
    private Food[] foods = new Food[5];
    private Scanner scanner = new Scanner(System.in);
    //购物车
    Food[] gouWuChe = new Food[0];

    /**
     * 初始化
     * 创建五个对象，给他们赋值并存入数组
     */
    public void init(){
        foods[0] = new Food("酸辣土豆丝", 18);
        foods[1] = new Food("红烧茄子", 20);
        foods[2] = new Food("红烧肉", 35);
        foods[3] = new Food("红烧鱼", 28);
        foods[4] = new Food("红烧猪蹄", 48);
    }

    /**
     * 启动菜单
     */
    public void menu(){
        boolean control = true;//控制点餐系统循环的退出
        while (control) {
            System.out.println("********欢迎进入点餐系统*********");
            System.out.println("1、显示菜单信息");
            System.out.println("2、点餐");
            System.out.println("3、结算");
            System.out.println("4、退出系统");

            System.out.println("请选择：");
            int choose = scanner.nextInt();

            switch (choose) {
                case 1:
                    caiDan();
                    break;
                case 2:
                    dianCan();
                    break;
                case 3:
                    jieSuan();
                    break;
                case 4:
                    System.out.println("点餐结束，谢谢使用");
                    control = false;
                    break;
            }
        }
    }

    /**
     * 菜单信息
     */
    public void caiDan(){
        System.out.println("点餐系统>>>显示菜单列表");
        for (Food food : foods) {
            System.out.println(food);
        }
    }

    /**
     * 点餐
     */
    public void dianCan(){
        System.out.println("点餐系统>>>点餐");
        System.out.println("请输入您要点的菜单编号");
        int inputId = scanner.nextInt();
        //根据编号查找菜品
        Food selectFood = null;//假设没有该菜品
        for (Food food : foods) {
            if (inputId == food.getId()){
                selectFood = food;
            }
        }
        //判断点的菜有没有
        if (selectFood == null){
            System.out.println("不好意思，没有该菜品，请重新点过");
        }else {
            //将点的菜加入购物车，购物车扩容
            gouWuChe = Arrays.copyOf(gouWuChe,gouWuChe.length + 1);
            gouWuChe[gouWuChe.length - 1] = selectFood;
            System.out.println("将《" + selectFood.getName() + "》加入购物车成功");
        }
    }

    /**
     * 结算
     */
    public void jieSuan(){
        System.out.println("点餐系统>>>点餐");
        //计算总价格
        float price = 0;
        for (Food food : gouWuChe) {
            price += food.getPrice();
        }
        System.out.println("您需要支付" + price + "元");
    }

    /**
     * main方法
     * @param args
     */
    public static void main(String[] args) {
        FoodDemo foodDemo = new FoodDemo();
        foodDemo.init();
        foodDemo.menu();
    }
}
