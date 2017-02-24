/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.java.controller;

import assignment.java.entity.User;
import assignment.java.model.UserModel;
import assignment.java.utility.ScannerUtil;

/**
 *
 * @author nnd2890
 */
public class UserController {
    //Showing the list
     public static void processList() {
        UserModel.list();
    }

    public static void processInsert() {
        System.out.println("Thực hiện thêm mới sinh viên.");
        System.out.println("Nhập id.");
        int id = ScannerUtil.getInt();
        System.out.println("Nhập name.");
        String name = ScannerUtil.getString();
        User user = new User();
        user.setId(id);
        user.setName(name);
        UserModel.insert(user);
    }
     
    public static void processUpdate() {
        System.out.println("Thực hiện update sinh viên.");
        System.out.println("Nhập id.");
        int id = ScannerUtil.getInt();
        System.out.println("Nhập name.");
        String name = ScannerUtil.getString();
        User user = new User();
        user.setId(id);
        user.setName(name);
        UserModel.update(user);
    }
    
    public static void processDelete() {
        System.out.println("Thực hiện delete sinh viên.");
        System.out.println("Nhập id.");
        int id = ScannerUtil.getInt();
        User user = new User();
        user.setId(id);
        UserModel.delete(user);
    }
     
    public static void processSelect() {
        System.out.println("Thực hiện Select theo tên sinh viên.");
        System.out.println("Nhập name.");
        String name = ScannerUtil.getString();
        User user = new User();
        user.setName(name);
        UserModel.select(user);
    }
}