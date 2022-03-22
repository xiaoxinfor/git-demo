package javasm.practice.practice1.bean;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/6-19:46
 * @Since:jdk1.8
 * @Description:计算工资类
 */
public class SalarySuan {
    //程序员工资计算
    public void jiSuan(Programmer programmer){
        System.out.println("程序员" + programmer.getName() + "的工资是：" + programmer.getSalary());
    }

    public void jiSuan(Manager manager){
        System.out.println("项目经理" + manager.getName() + "的工资是：" + manager.getSalary());
    }
}
