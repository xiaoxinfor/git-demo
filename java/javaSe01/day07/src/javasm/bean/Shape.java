package javasm.bean;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/6-17:57
 * @Since:jdk1.8
 * @Description:图形类（父类）
 */
public class Shape {
    private String name;

    /**
     * 构造方法
     * @param name
     */
    public Shape(String name) {
        this.name = name;
    }

    public Shape() {
    }

    /**
     * get和set方法
     * @return
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void mianJi(){
        System.out.println("求面积");
    }
    public void zhouChang(){
        System.out.println("求周长");
    }
}
