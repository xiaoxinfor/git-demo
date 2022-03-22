import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/4-13:52
 * @Since:jdk1.8
 * @Description:
 */
public class ArrayDemo03 {
    public static void main(String[] args) {
        /*
            录入N个班级！  --> 二位数组的长度
            每个班级录入M个学生！   --> 二位数组元素：一维数组的长度!
            显示每个学生的成绩!
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入班级个数");
        int classCount = scanner.nextInt();

        //定义一个二维数组，第一个括号内是班级的个数，第二个括号是班级的人数
        int[][] arr = new int[classCount][];

        //循环遍历班级
        for (int i = 0; i < classCount; i++) {
            System.out.println("请输入第" + (i + 1) + "个班的人数：");
            int studentCount = scanner.nextInt();
            //定义一维数组,学生分数
            int[] studentScore = new int[studentCount];
            //遍历班级人数，给每个学生输入分数
            for (int j = 0; j < studentCount; j++) {
                System.out.println("请输入第" + (j+1) + "个学生的分数");
                int score = scanner.nextInt();
                studentScore[j] = score;
            }
            //将学生分数这个一维数组放入arr这个二维数组
            arr[i] = studentScore;
        }
        //显示
        for (int[] banJi : arr) {
            System.out.println(Arrays.toString(banJi));
        }
        System.out.println("用Arrays.deepToString可以将二维数组转化为字符串输出");
        System.out.println(Arrays.deepToString(arr));
    }
}
