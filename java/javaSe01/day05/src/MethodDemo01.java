/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/4-15:05
 * @Since:jdk1.8
 * @Description:
 */
public class MethodDemo01 {
    public static void main(String[] args) {
        //调用getNumber方法
        //用a来接收返回值
        int a = getNumber('*', 6, 9);
        System.out.println(a);
    }

    public static int getNumber(char fuHao, int num1, int num2) {
        int result = 0;
        switch (fuHao) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
        }
        return result;
    }
}
