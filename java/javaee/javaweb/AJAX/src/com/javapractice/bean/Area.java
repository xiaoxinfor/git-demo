package com.javapractice.bean;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/14-19:31
 * @Since:jdk1.8
 * @Description:
 */
public class Area {
    Integer areaId;
    String areaName;
    Integer areaLevel;
    Integer paarentId;

    public Area() {
    }

    public Area(String areaName, Integer areaLevel, Integer paarentId) {
        this.areaName = areaName;
        this.areaLevel = areaLevel;
        this.paarentId = paarentId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getAreaLevel() {
        return areaLevel;
    }

    public void setAreaLevel(Integer areaLevel) {
        this.areaLevel = areaLevel;
    }

    public Integer getPaarentId() {
        return paarentId;
    }

    public void setPaarentId(Integer paarentId) {
        this.paarentId = paarentId;
    }
}
