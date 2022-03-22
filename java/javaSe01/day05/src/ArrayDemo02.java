/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/4-11:34
 * @Since:jdk1.8
 * @Description:
 */
public class ArrayDemo02 {
    public static void main(String[] args) {
        //正确答案
        String[] rightSc = {"A", "C", "B", "C", "D"};
        //学生答案
        String[][] score = {
                {"A", "C", "B", "C", "D"},
                {"A", "B", "B", "C", "D"},
                {"A", "C", "B", "B", "D"},
                {"B", "C", "B", "C", "D"},
                {"A", "C", "B", "B"}
        };
        //计算分数
        //外层循环遍历每个学生，二维数组的长度
        for (int i = 0; i < score.length; i++) {
            int sumScore = 0;//记录学生的分数
            //内层循环遍历学生的分数，二维数组内的一维数组的长度
            for (int j = 0; j < score[i].length; j++) {
                if (score[i][j].equals(rightSc[j])){
                    sumScore += 2;
                }
            }
            System.out.println("第" + (i+1) + "个学生的分数是" + sumScore);
        }
    }
}
