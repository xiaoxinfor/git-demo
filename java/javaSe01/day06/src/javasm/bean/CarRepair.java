package javasm.bean;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/5-19:25
 * @Since:jdk1.8
 * @Description:修车厂类
 */
public class CarRepair {
    //属性
    public String name;//修理厂名字
    public String address;//地址
    public String phoneNum;//电话号码

    /**
     * 无参构造
     */
    public CarRepair() {
    }

    /**
     * 全参构造
     */
    public CarRepair(String name, String address, String phoneNum) {
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
    }

    //方法
    public void repair(Car car) {
        System.out.println("请联系" + this.phoneNum + "将" +  car.wheelNum +"轮子的车拖到" + this.address + "的" + this.name + "修车");
    }
}
