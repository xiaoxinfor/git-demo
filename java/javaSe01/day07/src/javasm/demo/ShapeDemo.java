package javasm.demo;

import javasm.bean.ShapeChang;
import javasm.bean.ShapeYuan;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/6-19:06
 * @Since:jdk1.8
 * @Description:
 */
public class ShapeDemo {
    public static void main(String[] args) {
        //创建一个圆形对象
        ShapeYuan shapeYuan1 = new ShapeYuan("圆形",6);
        shapeYuan1.mianJi();
        shapeYuan1.zhouChang();

        //创建一个长方形对象
        ShapeChang shapeChang1 = new ShapeChang("长方形",5,6);
        shapeChang1.mianJi();
        shapeChang1.zhouChang();
    }
}
