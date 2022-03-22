package com.javasm.practice.service;

import com.javasm.practice.bean.Employees;

import java.io.File;
import java.util.List;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/21-19:59
 * @Since:jdk1.8
 * @Description:
 */
public interface EmployeesService {
    /**
     * 添加员工信息（序列化）
     *
     * @param file
     * @param t
     * @param append
     * @param <T>
     */
    <T> void write(File file, T t, boolean append);

    /**
     * 删除员工信息
     * @param file
     * @param <>
     * @return
     */
    List<Employees> read(String file,Scanner scanner);


    void show(String file);
}
