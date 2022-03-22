import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2021/12/31-17:13
 * @Since:jdk1.8
 * @Description:
 */
public class ArrayDemo02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入班级人数：");
        int count = scanner.nextInt();

        double[] numbers = new double[count];
        String[] name = new String[count];
        //录入成绩,姓名
        for (int i = 0; i < count; i++) {
            System.out.println("请输入姓名：");
            name[i] = scanner.next();

            System.out.println("请输入" + name[i] + "的成绩");
            numbers[i] = scanner.nextDouble();
        }
        //显示
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(name[i] + "的成绩为" + numbers[i]);
        }
        //总成绩、平均成绩、最高分最低分
        double sum = 0;
        double max = numbers[0];
        double min = numbers[0];
        double avg = 0;
        int indexMax = 0, indexMin = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];

            if (numbers[i] > max) {
                max = numbers[i];
                indexMax = i;
            }
            if (numbers[i] < min) {
                min = numbers[i];
                indexMin = i;
            }
            avg = (sum - max - min) / (count - 2);
        }
        System.out.println("总和为" + sum + "平均分为" + avg);
        System.out.println(name[indexMax] + "是最高分为" + max);
        System.out.println(name[indexMin] + "是最低分为" + min);

    }
}
