package com.javasm.bean.vo;

import com.javasm.bean.Hero;
import lombok.Data;

/**
 * @Author：liulei
 * @Version：1.0
 * @Date：2022/3/16-15:31
 * @Since:jdk1.8
 * @Description:
 */
@Data
public class HeroTypeInfo extends Hero {
    private Integer heroId;
    private String heroName;
    private Integer heroTypeId;
    private String heroImage;
    private Integer heroAttack;
    private Integer heroHealth;
    private String heroCreateDate;
    private Integer heroState;
    // 英雄类型
    private String heroTypeName;

}
