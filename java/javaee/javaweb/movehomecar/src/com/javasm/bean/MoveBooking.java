package com.javasm.bean;

import java.util.Date;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/10-19:38
 * @Since:jdk1.8
 * @Description:
 */
public class MoveBooking {
    Integer id;
    String area;
    String cartype;
    Date movedate;
    String contact;
    String phone;
    Integer state;

    @Override
    public String toString() {
        return "MoveBooking{" +
                "id=" + id +
                ", area='" + area + '\'' +
                ", cartype='" + cartype + '\'' +
                ", movedate=" + movedate +
                ", contact='" + contact + '\'' +
                ", phone='" + phone + '\'' +
                ", state=" + state +
                '}';
    }

    public MoveBooking(Integer id, String area, String cartype, Date movedate, String contact, String phone, Integer state) {
        this.id = id;
        this.area = area;
        this.cartype = cartype;
        this.movedate = movedate;
        this.contact = contact;
        this.phone = phone;
        this.state = state;
    }

    public MoveBooking(String area, String cartype, Date movedate, String contact, String phone) {
        this.area = area;
        this.cartype = cartype;
        this.movedate = movedate;
        this.contact = contact;
        this.phone = phone;
    }

    public MoveBooking() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCartype() {
        return cartype;
    }

    public void setCartype(String cartype) {
        this.cartype = cartype;
    }

    public Date getMovedate() {
        return movedate;
    }

    public void setMovedate(Date movedate) {
        this.movedate = movedate;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
