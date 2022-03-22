package javasm.practice.practice1.demo;

import javasm.practice.practice1.bean.Manager;
import javasm.practice.practice1.bean.Programmer;
import javasm.practice.practice1.bean.SalarySuan;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/6-19:34
 * @Since:jdk1.8
 * @Description:测试类，创建程序员和项目经理对象
 */
public class Test01 {
    public static void main(String[] args) {
        //程序员1，使用无参构造方法的默认值
        Programmer programmer1 = new Programmer();
        programmer1.show();

        //程序员2，自定义属性
        Programmer programmer2 = new Programmer(2,"张三","男",15000,"一般");
        programmer2.show();

        //项目经理1，默认值
        Manager manager1 =new Manager();
        manager1.show();

        //项目经理2
        Manager manager2 = new Manager(2,"李四","男",35000,6,26);
        manager2.show();


        //计算工资
        //新的程序员和项目经理对象
        Programmer programmer3 = new Programmer(3,"小白","男",9000,"高");
        Manager manager3 = new Manager(3,"小黑","女",31000,5,25);
        //计算工资对象
        SalarySuan ji = new SalarySuan();
        ji.jiSuan(programmer3);
        ji.jiSuan(manager3);

    }
}
