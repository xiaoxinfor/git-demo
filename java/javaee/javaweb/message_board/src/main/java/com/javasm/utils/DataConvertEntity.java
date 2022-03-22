package com.javasm.utils;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 将 request 中 客户端提交到服务器的数据封装到 实体类
 *
 * @Author：liulei
 * @Version：1.0
 * @Date：2022/3/18-10:12
 * @Since:jdk1.8
 * @Description:
 */
public class DataConvertEntity {

    /**
     * // 1.获取 请求数据  ok
     * // 2.获取 需要实例化对象的实体类的Class  ok
     * // 3.通过 Class 获取 类中所有的属性（本类中的属性）
     * // 4.通过 类中所有的属性 到 request中获取数据，将request中的数据存储在 Class 的对象中
     *
     * @param parameterMap request对象中客户端提交到服务器的值
     * @param clazz        实体类的类型
     * @param <T>          实例化的对象
     * @return
     */
    public static <T> T requestDataConvertEntity(Map<String, String[]> parameterMap, Class<T> clazz) throws IllegalAccessException, InstantiationException {
        // 通过Class类中 newInstance()反射调用实体类中的无参构造，实例化对象
        T newInstance = clazz.newInstance();
        // 通过 Class 获取 类中所有的属性（本类中的属性）
        Field[] declaredFields = clazz.getDeclaredFields();
        // 遍历 declaredFields
        for (Field declaredField : declaredFields) {
            // 获取属性的属性名
            String fieldName = declaredField.getName();
            // 通过 fieldName 到 parameterMap 获取数据,如果有值，说明客户端向服务器发送对应的数据，需要将数据存在 newInstance
            String[] values = parameterMap.get(fieldName);// 获取request中数据

            if (values != null && values.length == 1) {//  request中提交的数据是单个的
                // 暴力破解
                declaredField.setAccessible(true);
                System.out.println(declaredField.getType().getName());
                String value = values[0];// equest中提交的数据
                // 通过  declaredField 的类型转换 values 的值
                if (declaredField.getType().getName().equals("java.lang.Integer")) {
                    Integer i = DataConvert.stringConvertInteger(value);
                    // 需要将数据存在 newInstance
                    declaredField.set(newInstance, i);
                } else if (declaredField.getType().getSimpleName().equals("java.lang.Float")) {
                    Float i = DataConvert.stringConvertFloat(value);
                    // 需要将数据存在 newInstance
                    declaredField.set(newInstance, i);
                } else {
                    // 需要将数据存在 newInstance
                    declaredField.set(newInstance, value);
                }
            } else if (values != null && values.length > 1) {// request中提交的数据是多个的
                String value = "";
                for (int i = 0; i < values.length; i++) {
                    value += values[i];
                    if (i < values.length - 1) {
                        value += ", ";
                    }
                }
                // 需要将数据存在 newInstance
                declaredField.set(newInstance, value);
            }
        }
        return newInstance;
    }

}
