package javasm.practice.practice4.bean;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/6-20:30
 * @Since:jdk1.8
 * @Description:计算器类
 */
public class Counter {
    private double num1;
    private double num2;//操作数
    private String operator;//运算符

    /**
     * 构造方法
     */
    public Counter(double num1, double num2, String operator) {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
    }

    public Counter() {
    }


    //运算功能
    public double yunSuan() {
        double jieGuo = 0;
        switch (this.operator) {
            case "+":
                jieGuo = this.num1 + this.num2;
                break;
            case "-":
                jieGuo = this.num1 - this.num2;
                break;
            case "*":
                jieGuo = this.num1 * this.num2;
                break;
            case "/":
                jieGuo = this.num1 / this.num2;
                break;
        }
        return jieGuo;
    }
}
