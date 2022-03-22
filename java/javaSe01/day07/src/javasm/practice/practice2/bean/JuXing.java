package javasm.practice.practice2.bean;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/6-20:03
 * @Since:jdk1.8
 * @Description:矩形类
 */
public class JuXing {
    private double gao;//高
    private double kuan;//宽

    /**
     * 构造方法
     */
    public JuXing(double gao, double kuan) {
        this.gao = gao;
        this.kuan = kuan;
    }

    public JuXing() {
    }

    /**
     * set和get方法
     */
    public double getGao() {
        return gao;
    }

    public void setGao(double gao) {
        this.gao = gao;
    }

    public double getKuan() {
        return kuan;
    }

    public void setKuan(double kuan) {
        this.kuan = kuan;
    }

    //计算面积
    public double mianJi() {
        return this.gao * this.kuan;
    }

    //计算周长
    public double zhouChang() {
        return this.kuan * 2 + this.gao;
    }
}
