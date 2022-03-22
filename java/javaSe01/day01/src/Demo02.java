/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2021/12/29-16:09
 * @Since:jdk1.8
 * @Description:作业1
 */
public class Demo02 {
    public static void main(String[] args) {
        //个人信息
        String name = "易鑫";
        char gender = '男';
        int age = 23;
        String school = "景德镇陶瓷大学";
        String phoneNum = "15070547025";
        String address = "江西省宜春市";
        boolean marry = false;

        System.out.println(name);
        System.out.println(gender);
        System.out.println(age);
        System.out.println(school);
        System.out.println(phoneNum);
        System.out.println(address);
        System.out.println(marry);

        System.out.println("--------------------------");
        //求圆的面积
        final double PAI = 3.14;
        int r = 2;
        System.out.println(PAI * r * r);
    }
}
