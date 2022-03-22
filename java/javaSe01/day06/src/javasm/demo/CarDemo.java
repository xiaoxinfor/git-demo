package javasm.demo;

import javasm.bean.Car;
import javasm.bean.CarRepair;

import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/5-19:33
 * @Since:jdk1.8
 * @Description:
 */
public class CarDemo {
    public static void main(String[] args) {
        run();
    }

    public static void run(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入轮子数");
        int wheel = scanner.nextInt();
        String color = "红色";

        /**
         * 创建对象
         */
        Car car1 = new Car(wheel,color);
        CarRepair carRepair1 = new CarRepair("羊村修理厂","青青草原","110");
        if (car1.wheelNum == 4){
            car1.runCar();
        }else {
            carRepair1.repair(car1);
        }
    }

}
