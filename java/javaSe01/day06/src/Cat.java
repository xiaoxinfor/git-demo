/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/5-11:42
 * @Since:jdk1.8
 * @Description:创建一个猫类
 */
public class Cat {
    //属性
    public String name;//猫的名字
    public String color;//颜色
    public int age;//猫的年龄
    public double weight;//体重

    //方法
    //跑的方法
    public void run(){
        System.out.println("猫会跑");
    }
    public void sleep(){
        System.out.println("猫睡觉");
    }

    //main 方法
    public static void main(String[] args) {
        //创建一个对象，调用属性和方法
        Cat huaCat = new Cat();//花猫
        huaCat.name = "jack";
        huaCat.color = "red";
        huaCat.age = 5;
        huaCat.weight = 5.2;
        System.out.println(huaCat.name);
        System.out.println(huaCat.color);
        System.out.println(huaCat.age);
        System.out.println(huaCat.weight);

        huaCat.run();
        huaCat.sleep();
    }
}
