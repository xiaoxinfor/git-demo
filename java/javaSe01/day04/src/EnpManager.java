import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/3-14:52
 * @Since:jdk1.8
 * @Description:
 */
public class EnpManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //初始化数据
        int[] id = {101, 102, 103};
        String[] name = {"张三", "李四", "王五"};
        //工资
        float[] salary = {15000, 6500, 7800};


        boolean b = true;//控制循环的开关
        while (b) {
            //主菜单
            System.out.println("********欢迎使用员工管理系统*********");
            System.out.println("1、显示所有的员工信息");
            System.out.println("2、添加");
            System.out.println("3、删除");
            System.out.println("4、修改");
            System.out.println("5、根据编号查询");
            System.out.println("6、根据工资降序排序");
            System.out.println("0、退出");
            System.out.println("请选择：");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("员工管理系统>>>显示所有员工信息");
                    System.out.println("编号\t姓名 \t工资");
                    for (int i = 0; i < id.length; i++) {
                        System.out.println(id[i] + "\t" + name[i] + "\t" + salary[i]);
                    }
                    break;
                case 2:
                    System.out.println("员工管理系统>>>添加员工信息");
                    //扩容前获取id中的最大值
                    int maxId = id[id.length - 1];
                    //扩容
                    id = Arrays.copyOf(id, id.length + 1);
                    name = Arrays.copyOf(name, name.length + 1);
                    salary = Arrays.copyOf(salary, salary.length + 1);
                    //id自动增长，在原来最大id的基础上加1
                    id[id.length - 1] = ++maxId;
                    //输入姓名
                    System.out.println("请输入姓名");
                    String inputName = scanner.next();
                    name[name.length - 1] = inputName;
                    //输入工资
                    System.out.println("请输入" + inputName + "的工资");
                    salary[salary.length - 1] = scanner.nextFloat();
                    System.out.println("添加成功");
                    break;
                case 3:
                    System.out.println("员工管理系统>>>删除员工信息");
                    System.out.println("请输入要删除员工的员工编号：");
                    int deleId = scanner.nextInt();
                    int deleIndex = -1;//要删除员工的员工编号下标
                    for (int i = 0; i < id.length; i++) {
                        if (deleId == id[i]) {
                            deleIndex = i;
                        }
                    }
                    if (deleIndex == -1) {
                        System.out.println("系统中没有该员工编号，请核实后输入");
                    } else {
                        //循环覆盖
                        for (int i = deleIndex; i < id.length - 1; i++) {
                            //将后一个的数据覆盖到前一个位置中
                            id[i] = id[i + 1];
                            name[i] = name[i + 1];
                            salary[i] = salary[i + 1];
                        }
                        //缩容
                        id = Arrays.copyOf(id, id.length - 1);
                        name = Arrays.copyOf(name, name.length - 1);
                        salary = Arrays.copyOf(salary, salary.length - 1);
                        System.out.println("删除成功");
                    }
                    break;
                case 4:
                    System.out.println("员工管理系统>>>修改员工信息");
                    System.out.println("请输入要修改的员工编号：");
                    int updateId = scanner.nextInt();
                    int updateIndex = -1;//要修改的员工编号下标
                    for (int i = 0; i < id.length; i++) {
                        if (updateId == id[i]) {
                            updateIndex = i;
                        }
                    }
                    if (updateId == -1) {
                        System.out.println("系统中没有该员工编号！请核实后查询");
                    } else {
                        System.out.println("请输入修改后的姓名");
                        name[updateIndex] = scanner.next();
                        System.out.println("请输入修改后的工资");
                        salary[updateIndex] = scanner.nextInt();
                        System.out.println("修改成功");
                    }
                    break;
                case 5:
                    System.out.println("员工管理系统>>>查询员工信息");
                    System.out.println("请输入员工编号");
                    int inputId = scanner.nextInt();
                    int selectIndex = -1;//所要查询的员工编号的下标
                    for (int i = 0; i < id.length; i++) {
                        if (inputId == id[i]) {
                            selectIndex = i;
                        }
                    }
                    if (selectIndex == -1) {
                        System.out.println("系统中没有该员工编号！请核实后查询");
                    } else {
                        System.out.println("员工编号：" + id[selectIndex]);
                        System.out.println("员工姓名：" + name[selectIndex]);
                        System.out.println("员工工资：" + salary[selectIndex]);
                    }
                    break;
                case 6:
                    //将原数组复制生成新数组，使排序完成后不会影响到原数组
                    int[] sortId = Arrays.copyOf(id,id.length);
                    String[] sortName = Arrays.copyOf(name,name.length);
                    float[] sortSalary = Arrays.copyOf(salary,salary.length);

                    //降序排序：冒泡
                    for (int i = 0; i < salary.length - 1; i++) {
                        for (int j = 0; j < salary.length - 1 - i; j++) {
                            if (sortSalary[j] < sortSalary[j + 1]){
                                float temp1 = sortSalary[j];
                                sortSalary[j] = sortSalary[j+1];
                                sortSalary[j+1] = temp1;

                                int temp2 = sortId[j];
                                sortId[j] = sortId[j+1];
                                sortId[j+1] = temp2;

                                String temp3 = sortName[j];
                                sortName[j] = sortName[j+1];
                                sortName[j+1] = temp3;
                            }
                        }
                    }
                    System.out.println("排序后：");
                    System.out.println(Arrays.toString(sortId));
                    System.out.println(Arrays.toString(sortName));
                    System.out.println(Arrays.toString(sortSalary));
                    break;
                case 0:
                    System.out.println("退出成功");
                    b = false;
                    break;

            }
        }
    }
}
