package practice;


/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/1-15:04
 * @Since:jdk1.8
 * @Description:
 */
public class Practice06 {
    public static void main(String[] args) {
        int[] array = {2, 432, 5221, 235, 2, 5352, 1, 53, 5, 3, 5364, 2, 2, 63, 3533, 2, 53, 532, 532};
        //1、求和
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        System.out.println("和为" + sum);

        //2、下标为奇数的元素   6、将奇数位置元素存到B数组中
        int ge = 0;//个数
        System.out.println("-------------下标为奇数的元素有---------------------");
        for (int i = 1; i < array.length; i++) {
            if (i % 2 != 0) {
                System.out.print("下标" + i + "为:" + array[i] + "\t ");
                ge++;
            }
        }
        System.out.println("\n" + "---------------数组B(下标为奇数)---------------------");
        //定义一个数组B，用来存储奇数位置的元素
        int[] arrB = new int[ge];
        int index = 0;//数组B的下标
        for (int i = 0; i < array.length; i++) {
            if (i % 2 != 0) {
                arrB[index] = array[i];
                index++;
            }
        }
        for (int i = 0; i < ge; i++) {
            System.out.print(arrB[i] + "\t");
        }

        //3、输出值为奇数的
        System.out.println("\n" + "----------------------输出值为奇数的有--------------------------");
        int geJi = 0;//奇数元素的个数
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                System.out.print(array[i] + "\t");
                geJi++;
            }
        }
        //偶数元素存到数组C
        System.out.println("\n ------------------------数组C(元素为偶数)-------------------");
        int geOu = array.length - geJi;//偶数元素的个数
        //定义数组C，大小为偶数元素的个数
        int[] arrC = new int[geOu];
        int indexO = 0;//数组C的下标
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                arrC[indexO] = array[i];
                indexO++;
            }
        }
        for (int i = 0; i < geOu; i++) {
            System.out.print(arrC[i] + "\t");
        }

        //4、将所有元素乘2
        int[] newArr1 = new int[array.length];
        System.out.println("\n" + "---------------乘2后的数组-------------------------");
        for (int i = 0; i < array.length; i++) {
            newArr1[i] = array[i] * 2;
            System.out.print(newArr1[i] + "\t");
        }

        //5、将所有元素加到第一个元素中
        array[0] = sum;
        System.out.println("\n ------将所有元素加到第一个元素中------------------");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }

        //6、7、将奇数位置元素存到B数组中、偶数元素存到C数组中（在2题和3题中）

        //8、分别逆序输出B数组和C数组。

        //逆序B
        System.out.println("\n ------------逆序B------------------------");
        //创建一个和B大小一样的数组
        int[] newB = new int[arrB.length];
        //逆序遍历arrB
        for (int i = arrB.length - 1, j = 0; i >= 0; i--, j++) {
            newB[j] = arrB[i];
        }
        arrB = newB;
        for (int i = 0; i < arrB.length; i++) {
            System.out.print(arrB[i] + "\t");
        }

        //逆序C
        System.out.println("\n ------------逆序C------------------------");
        //创建一个和C大小一样的数组
        int[] newC = new int[arrC.length];
        //逆序遍历arrC
        for (int i = arrC.length - 1, j = 0; i >= 0; i--, j++) {
            newC[j] = arrC[i];
        }
        arrC = newC;
        for (int i = 0; i < arrC.length; i++) {
            System.out.print(arrC[i] + "\t");
        }
    }
}
