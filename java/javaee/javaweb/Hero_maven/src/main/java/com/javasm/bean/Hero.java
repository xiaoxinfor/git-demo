package com.javasm.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hero {

    private Integer heroId;
    private String heroName;
    private Integer heroTypeId;
    private String heroImage;
    private Integer heroAttack;
    private Integer heroHealth;
    private String heroCreateDate;
    private Integer heroState;

    public Hero(String heroName, Integer heroTypeId, String heroImage, Integer heroAttack, Integer heroHealth, String heroCreateDate) {
        this.heroName = heroName;
        this.heroTypeId = heroTypeId;
        this.heroImage = heroImage;
        this.heroAttack = heroAttack;
        this.heroHealth = heroHealth;
        this.heroCreateDate = heroCreateDate;
    }
}
