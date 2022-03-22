package practice;

import java.util.Arrays;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/3-19:15
 * @Since:jdk1.8
 * @Description:斗地主
 */
public class practice01 {
    public static void main(String[] args) {
        //花色
        String[] colors = {"♠", "♥", "♣", "♦"};
        //牌面
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        //大小王
        String[] kings = {"大王", "小王"};
        //一副牌
        String[] brands = new String[54];

        //一个牌面数字需要有四个花色
        //外层4个循环,内层13个循环
        int indexBrands = 0;//brands数组的索引
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < values.length; j++) {
                brands[indexBrands++] = colors[i] + values[j];
            }
        }
        //在brands数组的最后两个位置加入大小王
        brands[brands.length - 2] = kings[0];
        brands[brands.length - 1] = kings[1];
        //显示牌面
        System.out.println(Arrays.toString(brands));

        //随机洗牌
        for (int i = 0; i < brands.length; i++) {
            //定义一个0到57的随机数
            int suiJi = (int) (Math.random() * brands.length);
            String temp = brands[i];
            brands[i] = brands[suiJi];
            brands[suiJi] = temp;
        }
        //显示牌面
        System.out.println(Arrays.toString(brands));

        /*发牌，一个人发17张牌，留三张底牌
          一张一张的发，
          第一人发；0，3,6    牌数%3 == 0
          第二人：1,4,7       牌数%3 == 1
          第三人：2,5,8       牌数%3 == 2
        */
        String[] play1 = new String[17];
        String[] play2 = new String[17];
        String[] play3 = new String[17];

        //需要留三张底牌，循环次数减3
        int play1Index = 0, play2Index = 0, play3Index = 0;
        for (int i = 0; i < brands.length - 3; i++) {
            if (i % 3 == 0) {
                play1[play1Index++] = brands[i];
            } else if (i % 3 == 1) {
                play2[play2Index++] = brands[i];
            } else if (i % 3 == 2) {
                play3[play3Index++] = brands[i];
            }
        }
        //选地主
        //生成一个随机数
        int suiJi1 = (int) (Math.random() * 3);
        switch (suiJi1) {
            case 0:
                //扩容
                play1 = Arrays.copyOf(play1,play1.length + 3);
                play1[play1.length-1] = brands[51];
                play1[play1.length-2] = brands[52];
                play1[play1.length-3] = brands[53];
                break;
            case 1:
                play2 = Arrays.copyOf(play2,play2.length + 3);
                play2[play2.length-1] = brands[51];
                play2[play2.length-2] = brands[52];
                play2[play2.length-3] = brands[53];
                break;
            case 2:
                play3 = Arrays.copyOf(play3,play3.length + 3);
                play3[play3.length-1] = brands[51];
                play3[play3.length-2] = brands[52];
                play3[play3.length-3] = brands[53];
                break;
        }
        System.out.println(Arrays.toString(play1));
        System.out.println(Arrays.toString(play2));
        System.out.println(Arrays.toString(play3));
    }
}
