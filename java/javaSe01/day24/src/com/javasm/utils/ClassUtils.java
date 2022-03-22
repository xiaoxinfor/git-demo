package com.javasm.utils;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/19-18:01
 * @Since:jdk1.8
 * @Description:
 */
public class ClassUtils {
    /**
     * 根据列名拼接成员方法的名称
     * @param labelName
     * @return
     */
    public static String getMethod(String labelName){
        StringBuilder stringBuilder = new StringBuilder("set");
        stringBuilder.append(labelName.substring(0,1).toUpperCase());
        stringBuilder.append(labelName.substring(1));
        return stringBuilder.toString();
    }

    public static Class getC(String className){
        //将所有日期全部设为：util.date
        if (className.equals("java.sql.Date") || className.equals("java.sql.Timestamp")){
            className = "java.util.Date";
        }
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
