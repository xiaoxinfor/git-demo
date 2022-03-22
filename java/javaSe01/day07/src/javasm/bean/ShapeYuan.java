package javasm.bean;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/6-18:02
 * @Since:jdk1.8
 * @Description:圆类（子类）
 */
public class ShapeYuan extends Shape {
    private double r;//圆形自有的属性

    /**
     * 构造方法
     */
    public ShapeYuan(String name, double r) {
        super(name);
        this.r = r;
    }

    public ShapeYuan() {
    }

    /**
     * 方法重写
     */
    @Override
    public void mianJi() {
        System.out.println(this.getName() + "的面积为" + (3.14 * r * r));
    }

    public void zhouChang() {
        System.out.println(this.getName() + "的周长为" + (2 * 3.14 * r));
    }
}
