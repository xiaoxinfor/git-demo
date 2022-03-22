package com.javasm.practice.service.impl;

import cn.hutool.core.lang.ConsoleTable;
import com.javasm.practice.bean.Employees;
import com.javasm.practice.override.SimpleObjectOutputStream;
import com.javasm.practice.service.EmployeesService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/21-20:02
 * @Since:jdk1.8
 * @Description:
 */
public class EmployeesServiceImpl implements EmployeesService {
    /**
     * 序列化
     * 只有第一次写入有头部
     *
     * @param file
     * @param t
     * @param append
     * @param <T>
     */
    @Override
    public <T> void write(File file, T t, boolean append) {
        if (file.length() == 0) {//第一次写入
            try (ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(file, append))) {
                obj.writeObject(t);
                obj.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try (ObjectOutputStream obj = new SimpleObjectOutputStream(new FileOutputStream(file, append))) {
                obj.writeObject(t);
                obj.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @SuppressWarnings("all")
    @Override
    public  List<Employees> read(String file,Scanner scanner) {
        List<Employees> list = new ArrayList<>();
        try (ObjectInputStream obj = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                //将对象存入集合
                Employees t = (Employees) obj.readObject();
                list.add(t);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //删除
        System.out.println("请输入要删除的员工编号：");
        int id = scanner.nextInt();
        int index = -1;//要删除的员工索引
        for (Employees employees : list) {
            if (id == employees.getId()){
                index = list.indexOf(employees);
            }
        }
        if (index == -1){
            System.out.println("未找到该员工");
            return null;
        }
        list.remove(index);
        //将集合写入文件,覆盖原文件
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))){
                for (Employees employees : list) {//必须循环遍历写入，否则下次读取时会出现类型转换异常
                    objectOutputStream.writeObject(employees);
                    objectOutputStream.flush();
                }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("删除成功");
        return list;
    }
    @SuppressWarnings("all")
    @Override
    public void show(String file) {
        List<Employees> list = new ArrayList<>();
        try (ObjectInputStream obj = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                Employees t = (Employees) obj.readObject();
                list.add(t);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ConsoleTable consoleTable = new ConsoleTable();
        consoleTable.addHeader("员工ID","姓名","密码");
        for (Employees employees : list) {
            consoleTable.addBody(employees.getId().toString(),employees.getName(),employees.getpWd());
        }
        consoleTable.print();
    }
}
