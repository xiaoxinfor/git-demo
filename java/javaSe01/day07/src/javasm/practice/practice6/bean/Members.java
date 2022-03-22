package javasm.practice.practice6.bean;

import java.util.Arrays;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/6-21:08
 * @Since:jdk1.8
 * @Description:会员类
 */
public class Members {
    private int id;//会员号
    private String name;
    private int jiFen;//积分

    public Members(int id, String name, int jiFen) {
        this.id = id;
        this.name = name;
        this.jiFen = jiFen;
    }

    public Members() {
    }

    //验证会员号是否合法
    public void yanZ(int id, String name, int jiFen) {
        if (id >= 1000 && id < 10000){
            this.id = id;
            this.name = name;
            this.jiFen = jiFen;
            zheKou(this.jiFen);
            return;
        }
        System.out.println("会员号不合法");
    }
    public void zheKou(int jiFen){
        if (jiFen>=90){
            System.out.println("9折优惠");
        }else if (jiFen>=80){
            System.out.println("8折优惠");
        }else if (jiFen>=70){
            System.out.println("7折优惠");
        }else if (jiFen>=60){
            System.out.println("6折优惠");
        }else {
            System.out.println("没有优惠");
        }
    }
    //抽奖方法
    public void chouJiang(){
        int[] luckyNum = new int[5];
        //给幸运数字数组里面赋值随机数
        for (int i = 0; i < luckyNum.length; i++) {
            luckyNum[i] = (int) (Math.random() * 9000 + 1000);
        }
        System.out.println("本日幸运数字为" + Arrays.toString(luckyNum));
        for (int i = 0; i < luckyNum.length; i++) {
            if (this.id == luckyNum[i]) {
                System.out.println("恭喜您，成为本日幸运会员");
                return;
            }
        }
        System.out.println("抱歉，不是幸运会员");
    }
}
