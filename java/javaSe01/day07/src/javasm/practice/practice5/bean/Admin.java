package javasm.practice.practice5.bean;

import org.omg.CORBA.StringHolder;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/6-20:44
 * @Since:jdk1.8
 * @Description:
 */
public class Admin {
    private String name;//用户名
    private int pass;//密码
    //构造方法
    public Admin(String name, int pass) {
        this.name = name;
        this.pass = pass;
    }
    public Admin(){
    }
    //set和get方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPass() {
        return pass;
    }
    public void setPass(int pass) {
        this.pass = pass;
    }
    //显示管理员信息
    public String xinXi() {
        return "名字：" + this.name + "\t" + "密码：" + this.pass;
    }

    //验证方法
    public boolean yanZheng(String name,int pass){
        //如果验证这个方法传入的名字密码和创建的对象名字密码一样，就返回true，否则false
        return name.equals(this.name) && pass == this.pass;
    }
}
