import java.util.Arrays;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/4-16:34
 * @Since:jdk1.8
 * @Description:
 */
public class MethodDemo03 {
    public static void main(String[] args) {
        String[] name = new String[5];
        init(name);
        name = add(name);
        show(name);
    }

    public static void init(String[] name) {
        name[0] = "rose";
        name[1] = "jack";
        name[2] = "tom";
        name[3] = "polly";
        name[4] = "luccy";
    }

    public static String[] add(String[] name) {
        //扩容
        name = Arrays.copyOf(name, name.length + 1);//Arrays.copyOf是复制创建了一个新数组,内存地址发生变化
        //所以需要把全新的数组返回覆盖原来的
        name[name.length - 1] = "pack";
        return name;
    }

    public static void show(String[] name) {
        System.out.println(Arrays.toString(name));
    }
}
