package com.practice2.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/15-21:18
 * @Since:jdk1.8
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    String playName;//玩家名称
    String role;//角色
    List<Poker> poker;//牌
}
