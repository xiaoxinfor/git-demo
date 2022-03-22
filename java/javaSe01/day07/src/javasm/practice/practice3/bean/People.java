package javasm.practice.practice3.bean;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/6-20:12
 * @Since:jdk1.8
 * @Description:人类
 */
public class People {
    private int id;//身份号
    private String name;
    private int age;
    public static int ciShu = 0;//统计创建对象的次数

    //构造方法

    public People(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        ciShu++;
    }

    public People() {
        ciShu++;
    }

    /**
     * set和get方法
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //比较年龄的方法
    public void biJiao(People people){
        if (this.age > people.age){
            System.out.println(this.name+ "的年龄大于" + people.name + "年龄");
            return;
        }
        System.out.println(this.name+ "的年龄小于" + people.name + "年龄");
    }
}
