package javasm.practice.practice1.bean;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/6-19:25
 * @Since:jdk1.8
 * @Description:项目经理类
 */
public class Manager {
    private int id;//编号
    private String name;
    private String gender;//性别
    private double salary;//工资
    private int exp;//项目经验（几年）
    private double bonus;//项目分红，百分之几

    /**
     * 构造方法
     * @param id
     * @param name
     * @param gender
     * @param salary
     * @param exp
     * @param bonus
     */
    public Manager(int id, String name, String gender, double salary, int exp, double bonus) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.salary = salary;
        this.exp = exp;
        this.bonus = bonus;
    }
    public Manager(){
        this.id = 01;
        this.name = "张华";
        this.gender = "男";
        this.salary = 30000;
        this.exp = 5;
        this.bonus = 25;
    }

    /**
     * get和set方法
     * @return
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                ", exp=" + exp +
                ", bonus=" + bonus +
                '}';
    }
    //show方法
    public void show(){
        System.out.println(this.toString());
    }
}
