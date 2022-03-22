package work.practice2;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2021/12/30-21:48
 * @Since:jdk1.8
 * @Description:让计算机随机产生10个0到2之间的数
 */
public class Practice05 {
    public static void main(String[] args) {
        int i = 1;
        while (i <= 10) {
            double random = Math.random() * 3;
            int result = (int) random;
//            if (result == 0){
//                System.out.println("生成了一只白猪，我好怕怕");
//            }else if (result == 1){
//                System.out.println("生成了一只黑猪，我喜欢");
//            }else {
//                System.out.println("生成了一只红猪，有下酒菜了");
//            }

            switch (result) {
                case 0:
                    System.out.println("生成了一只白猪，我好怕怕");
                    break;
                case 1:
                    System.out.println("生成了一只黑猪，我喜欢");
                    break;
                default:
                    System.out.println("生成了一只红猪，有下酒菜了");
            }

            i++;
        }
    }
}
