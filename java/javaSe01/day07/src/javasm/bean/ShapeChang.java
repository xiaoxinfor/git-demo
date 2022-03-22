package javasm.bean;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/6-19:01
 * @Since:jdk1.8
 * @Description:
 */
public class ShapeChang extends Shape {
    private double chang;
    private double bian;

    /**
     * 构造方法
     */
    public ShapeChang(String name, double chang, double bian) {
        super(name);
        this.chang = chang;
        this.bian = bian;
    }

    public ShapeChang() {
    }

    /**
     * 方法重写
     */
    @Override
    public void mianJi() {
        System.out.println(this.getName() + "的面积为" + (this.bian * this.chang));
    }

    public void zhouChang() {
        System.out.println(this.getName() + "的面积为" + (this.bian * 2 + this.chang * 2));
    }
}
