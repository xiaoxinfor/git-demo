package javasm.bean;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/5-20:10
 * @Since:jdk1.8
 * @Description:电脑类
 */
public class Computer {
    public String cpu;
    public String type;//品牌

    public int memory;//内存

    /**
     * 无参构造方法
     */
    public Computer() {
    }

    /**
     * 有参构造方法
     */
    public Computer(String cpu, String type, int memory) {
        this.cpu = cpu;
        this.type = type;
        this.memory = memory;
    }

    //上网方法
    public void surfNet(){
        System.out.println("这台电脑能上网");
    }
}
