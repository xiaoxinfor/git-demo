/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/4-15:58
 * @Since:jdk1.8
 * @Description:
 */
public class MethodDemo02 {
    public static void main(String[] args) {
        //调用参数
        show("yx" ,"tom","jack");
        System.out.println("**************************");
        show("rose");
        System.out.println("**************************");
        show();
    }
    public static void show(String...name){
        if (name != null && name.length>0){
            for (int i = 0; i < name.length; i++) {
                System.out.println(name[i]);
            }
        }
    }
}
