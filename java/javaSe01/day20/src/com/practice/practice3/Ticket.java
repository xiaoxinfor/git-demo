package com.practice.practice3;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/23-10:07
 * @Since:jdk1.8
 * @Description:
 */
public class Ticket {
    private Integer num;//票数

    public Ticket(Integer num) {
        this.num = num;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "num=" + num +
                '}';
    }

    //抢票
    public void qiang(int num){
        synchronized (this){
            int before = this.getNum();
            int after = before - num;

            //票池剩余票数
            this.setNum(after);
            System.out.println(Thread.currentThread().getName() + "取款成功，余额" + getNum() );
        }
    }
}
