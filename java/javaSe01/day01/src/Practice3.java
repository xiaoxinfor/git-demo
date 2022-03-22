/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2021/12/29-19:26
 * @Since:jdk1.8
 * @Description:算法练习
 */
public class Practice3 {
    public static void main(String[] args) {
        //求光年是多少千米
        long speed = 299792458;
        int time = 365 * 24 * 60 * 60;
        long km = speed * time / 1000;
        System.out.println("一光年是" + km + "千米");

        //计算周数与剩余天数
        int weeks = 46 / 7;
        System.out.println("周数是" + weeks);
        int days = 46 % 7;
        System.out.println("剩余天数是" + days);

        //求圆的面积
        double radius = 1.5;
        final double PAI = 3.14;
        double area = PAI * radius * radius;
        System.out.println("圆的面积为" + area);

        //挑扇子
        //扇形扇子面积
        double radiusS = 26.5;
        double jiaoDu = 134.6;
        double sArea = PAI * radiusS * radiusS * (jiaoDu / 360);
        System.out.println("扇形扇子面积为" + sArea);
        //圆形扇子面积
        double radiusY = (36.5 - 12.3) / 2;
        double yArea = PAI * radiusY * radiusY;
        System.out.println("圆形扇子面积为" + yArea);
        //相比较
        String result = sArea > yArea ? "选扇形扇子" : "选圆形扇子";
        System.out.println(result);

        //a和b的值互换
        int a = 10, b = 20;
        int c;
        c = a;
        a = b;
        b = c;
        System.out.println(a);
        System.out.println(b);

        //求各个位数的和
        int x = 456;
		int bai = x/100;
		int shi = x/10%10;
		int ge = x%10;
		int result1 = bai + shi + ge;
        System.out.println("4 + 5 + 6" + "=" + result1);

        //求华氏度
		//华氏度 = 摄氏度*9/5 + 32
        int temperature = 6;
        int fahrenheit = temperature*9/5 + 32;
        System.out.println("华氏度是" + fahrenheit);

    }
}
