package javasm.practice.practice1.bean;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/6-19:18
 * @Since:jdk1.8
 * @Description:程序员类
 */
public class Programmer {
    private int id;//编号
    private String name;
    private String gender;//性别
    private double salary;//工资
    private String hot;//关注度

    /**
     * 构造方法
     */
    public Programmer(int id, String name, String gender, double salary, String hot) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.salary = salary;
        this.hot = hot;
    }
    public Programmer(){//无参构造设置属性的默认值
        this.id = 01;
        this.name = "李华";
        this.gender = "男";
        this.salary = 10000;
        this.hot = "一般";
    }

    /**
     * get和set方法
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

    public String getHot() {
        return hot;
    }

    public void setHot(String hot) {
        this.hot = hot;
    }

    @Override
    public String toString() {
        return "Programmer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                ", hot='" + hot + '\'' +
                '}';
    }

    //show方法
    public void show(){
        System.out.println(this.toString());
    }
}
