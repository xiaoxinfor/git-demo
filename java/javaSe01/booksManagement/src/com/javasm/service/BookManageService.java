package com.javasm.service;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/6-22:50
 * @Since:jdk1.8
 * @Description:
 */
public interface BookManageService {
    /**
     * 查看书目
     */
    void show();

    /**
     * 添加书籍
     */
    void add();

    /**
     * 删除书籍
     */
    void delete();
}
