package javasm.bean;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/6-10:34
 * @Since:jdk1.8
 * @Description:封装
 */
public class User {
    //属性
    public String name;
    private int age;
    private int passWord;//密码私有

    /**
     * set和get方法
     */
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
        if (age < 18) {
            System.out.println("年龄必须满18岁，否则默认年龄为18");
            this.age = 18;
        } else {
            this.age = age;
        }

    }

    public int getPassWord() {
        return passWord;
    }

    public void setPassWord(int passWord) {
        if (passWord >= 1000 && passWord < 10000) {
            this.passWord = passWord;
        }else {
            System.out.println("密码必须为四位数");
        }
    }

    public String info(){
        return "名字为" + this.name + "、年龄为" + this.age + "、密码为" + this.passWord;
    }
}
