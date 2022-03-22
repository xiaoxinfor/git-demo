package javasm.bean;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/5-19:16
 * @Since:jdk1.8
 * @Description:车类
 */
public class Car {
    //属性
    public int wheelNum;//轮子数
    public String colorCar;//车的颜色

    /**
     * 无参构造
     */
    public Car() {
    }

    /**
     * 全参构造
     */
    public Car(int wheelNum, String colorCar) {
        this.wheelNum = wheelNum;
        this.colorCar = colorCar;
    }

    //方法
    public void runCar() {
        System.out.println("一辆" + this.colorCar + this.wheelNum +"轮子的车开起来了");
    }
}
