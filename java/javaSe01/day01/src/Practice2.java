/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2021/12/29-19:09
 * @Since:jdk1.8
 * @Description:练习2（使用变量的形式，定义数据信息）
 */
public class Practice2 {
    public static void main(String[] args) {
        System.out.println("欢迎来到王者荣耀");
        String heroName = "虞姬";
        String heroLocat = "射手";
        int heroPrice = 13888;
        String heroSkill = "远程物理攻击";
        int heroDifficult = 6;
        boolean isHave = true;

        System.out.println("英雄名称：" + heroName);
        System.out.println("英雄定位：" + heroLocat);
        System.out.println("英雄价格：" + heroPrice + "金币");
        System.out.println("英雄技能：" + heroSkill);
        System.out.println("英雄难度：" + heroDifficult + "颗星");
        System.out.println("是否拥有：" + isHave);
    }
}
