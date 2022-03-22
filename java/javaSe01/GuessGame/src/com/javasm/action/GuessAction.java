package com.javasm.action;

import com.javasm.bean.Computer;
import com.javasm.bean.Person;
import jdk.nashorn.internal.ir.IfNode;

import java.time.Year;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/8-17:14
 * @Since:jdk1.8
 * @Description:
 */
public class GuessAction {
    //创建玩家
    private Person person = new Person();
    //创建电脑玩家
    private Computer computer = new Computer();
    private Scanner scanner = new Scanner(System.in);

    /**
     * 启动游戏
     */
    public void start() {
        System.out.println("=======================");
        System.out.println("=======猜拳开始========");
        System.out.println("=======================");
        System.out.println("猜拳规则：1、石头。2、剪刀。3、布。");
        System.out.println("请帮电脑选择角色：");
        System.out.println("1、刘备。2、张飞。3、关羽。");
        int chooseItId = scanner.nextInt();
        getItId(chooseItId);
        System.out.println("请输入你的角色名称");
        person.setName(scanner.next());
        System.out.println(person.getName() + "\t对战\t" + computer.getName());

        //重复出拳
        while (true){
            chooseGuess();
            System.out.println("还要继续吗？（y/n）");
            String answer = scanner.next();
            if (answer.equals("n")){
                System.out.println("猜拳结束");
                System.out.println(computer.getName() + "\tvs\t" + person.getName());
                System.out.println(computer.getScore() + "\tvs\t" + person.getScore());
                break;
            }
        }
    }

    /**
     * 开始猜拳
     */
    public void chooseGuess() {
        //玩家出拳
        System.out.println(person.getName() + "出拳（1、石头。2、剪刀。3、布。）");
        int guessId = scanner.nextInt();
        person.setGuessId(guessId);
        //电脑随机出拳
        int guessComputerId =(int)(Math.random()*3 +1);
        computer.setGuessId(guessComputerId);
        System.out.println(person.getName() + "出拳：" + getGuess(guessId));
        System.out.println(computer.getName() + "出拳：" + getGuess(guessComputerId));
        getScore();
    }

    /**
     * 统计得分
     */
    public void getScore(){
        if ((person.getGuessId() == 1 && computer.getGuessId() ==2) || (person.getGuessId() == 2 && computer.getGuessId() == 3) || (person.getGuessId() == 3 && computer.getGuessId() ==1)){
            person.setScore(person.getScore() + 1);
            System.out.println(person.getName() + "赢了");
        }else if (person.getGuessId() == computer.getGuessId()){
            System.out.println("平局");
        }else {
            computer.setScore(computer.getScore() + 1);
            System.out.println(computer.getName() + "赢了");
        }
    }


    /**
     * 给电脑选择角色
     *
     * @param chooseItId
     */
    public void getItId(int chooseItId) {
        switch (chooseItId) {
            case 1:
                computer.setName("刘备");
                break;
            case 2:
                computer.setName("张飞");
                break;
            case 3:
                computer.setName("关羽");
                break;
            default:
                System.out.println("选择角色错误，请重新选择");
        }
    }

    /**
     * 根据出拳id获取相应的拳
     * @param guessId
     * @return
     */
    public String getGuess(int guessId) {
        switch (guessId) {
            case 1:
                return "石头";
            case 2:
                return "剪刀";
            case 3:
                return "布";
        }
        return "选择错误";
    }
}
