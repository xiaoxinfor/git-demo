package com.javasm.service;

import com.javasm.bean.BikeCompany;

import java.util.Scanner;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/13-16:11
 * @Since:jdk1.8
 * @Description:
 */
public interface BikeService {
    void putBike(BikeCompany[] bikeCompanies, Scanner scanner);
    void showBike(BikeCompany[] bikeCompany);
    void deleteBike(BikeCompany[] bikeCompanies,Scanner scanner);
    void jieChuBike(BikeCompany[] bikeCompanies,Scanner scanner);
    void returnBike(BikeCompany[] bikeCompanies,Scanner scanner);
    BikeCompany[] sortBike(BikeCompany[] bikeCompanies);
}
