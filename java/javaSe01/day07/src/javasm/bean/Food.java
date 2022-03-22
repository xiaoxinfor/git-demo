package javasm.bean;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/6-15:36
 * @Since:jdk1.8
 * @Description:
 */
public class Food {
    //编号
    private int id;
    //菜名
    private String name;
    //价格
    private float price;
    //自增id
    private static int idAdd = 1;

    /**
     * 构造方法
     */
    public Food( String name, float price) {
        this.id = idAdd++;
        this.name = name;
        this.price = price;
    }
    public Food() {
    }
    /**
     * set和get方法
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    /**
     * toString方法
     */
    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
