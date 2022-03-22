package javasm.test;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/5-15:18
 * @Since:jdk1.8
 * @Description:
 */
public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.age = 23;
        p1.name = "y";
        p1.likes = new String[]{"hhh"};
        p1.eat();
        p1.addLikes();
        p1.sleep();
        p1.show();


        Person p2 = new Person(23, "opo", new String[]{"看书"});
        p2.addLikes();
        p2.show();



    }
}
