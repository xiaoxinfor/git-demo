package com.javasm.Demo;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/18-17:05
 * @Since:jdk1.8
 * @Description:
 */
public interface GenericService<E> {
    void show(E[] array);
    E[] add(E[] array,E e);
    E[] delete(E[] array,E e);
    void update(E[] array,E e,E a);
}
