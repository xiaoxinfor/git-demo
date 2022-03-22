package com.practice2.action;

import com.practice2.bean.Player;
import com.practice2.bean.Poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/15-21:25
 * @Since:jdk1.8
 * @Description:
 */
public class GameAction {
    private List<Poker> pokerBox = new ArrayList<>();//一副牌
    private List<Player> playerList = new ArrayList<>(3);//三个玩家

    //初始化
    public void init(){
        String[] colors = {"♥", "♠", "♣", "♦"};
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        
        //初始化一副牌
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < values.length; j++) {
                Poker poker = new Poker(colors[i],values[j]);
                pokerBox.add(poker);
            }
        }
        //添加大小王
        pokerBox.add(new Poker(null,"大王"));
        pokerBox.add(new Poker(null,"小王"));

        //添加三个玩家
        playerList.add(new Player("jack",null,null));
        playerList.add(new Player("jdk",null,null));
        playerList.add(new Player("tom",null,null));
    }

    //发牌
    public void pai() {
        init();
        //打乱牌的顺序
        Collections.shuffle(pokerBox);

        List<Poker> pokers1 = new ArrayList<>(17);
        List<Poker> pokers2 = new ArrayList<>(17);
        List<Poker> pokers3 = new ArrayList<>(17);
        List<Poker> pokers4 = new ArrayList<>(3);
        //遍历牌盒
        for (int i = 0; i < pokerBox.size(); i++) {
            if (i >= 51) {
                pokers4.add(pokerBox.get(i));
            } else if (i % 3 == 0) {
                pokers1.add(pokerBox.get(i));
            } else if (i % 3 == 1) {
                pokers2.add(pokerBox.get(i));
            } else if (i % 3 == 2) {
                pokers3.add(pokerBox.get(i));
            }
        }
        //选地主
        int suiJi1 = (int) (Math.random() * 3);
        switch (suiJi1) {
            case 0:
                pokers1.addAll(pokers4);
                break;
            case 1:
                pokers2.addAll(pokers4);
                break;
            case 2:
                pokers3.addAll(pokers4);
                break;
        }

        //显示
        System.out.println(pokers1);
        System.out.println(pokers2);
        System.out.println(pokers3);
    }
}
