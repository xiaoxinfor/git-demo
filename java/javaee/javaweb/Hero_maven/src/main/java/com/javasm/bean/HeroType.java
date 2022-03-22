package com.javasm.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeroType {
    private Integer heroTypeId;
    private String heroTypeName;
}
