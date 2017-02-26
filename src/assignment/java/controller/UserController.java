/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.java.controller;

import assignment.java.entity.User;
import assignment.java.model.DAO;
import assignment.java.model.UserModel;
import assignment.java.utility.ScannerUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
        UserModel.list();
    }
     
    public static void processUpdate() {
         try {
           System.out.println("Thực hiện update sinh viên.");
           System.out.println("Nhập id.");
           User user = new User();
           int id = ScannerUtil.getInt();
           Statement statement = DAO.getConnection().createStatement();
           String query = "select * from sv "
                   + "where id='" + id + "'";
           ResultSet rs = statement.executeQuery(query);
           
                if (!rs.next()) {
                        System.out.println("The Id is not exist!");
                } else {
                        System.out.println("Danh sach ban muon Update:");
                        user.setId(id);
                        UserModel.select(user);
                        System.out.println("Enter the Name you want to update:");
                        String name = ScannerUtil.getString();
                        user.setName(name);
                        UserModel.update(user);
                        
                }  
            

        } catch (SQLException e) {
            System.err.println("Lỗi khi select.");
        }       
    }
    
    public static void processDelete() {
        try {
           System.out.println("Thực hiện delete sinh viên.");
           System.out.println("Nhập id.");
           User user = new User();
           int id = ScannerUtil.getInt();
           Statement statement = DAO.getConnection().createStatement();
           String query = "select * from sv "
                   + "where id='" + id + "'";
           ResultSet rs = statement.executeQuery(query);
           
                if (!rs.next()) {
                        System.out.println("The Id is not exist!");
                } else{
                        System.out.println("Danh sach ban muon Delete:");
                        user.setId(id);
                        UserModel.select(user);
                        System.out.println("Are you sure to delete that?(y/n):");
                        String yn = ScannerUtil.getString();
                        if (yn.equals("y")) {
                            UserModel.delete(user);
                            UserModel.list();
                        }else{
                             System.out.println("Du lieu khong thay doi");
                             UserModel.list();
                        }                      
                }  
            

        } catch (SQLException e) {
            System.err.println("Lỗi khi select.");
        }
    }
     
    public static void processSelect() {
        System.out.println("Thực hiện Select theo ID sinh viên.");
        System.out.println("Nhập id.");
        int id = ScannerUtil.getInt();
        User user = new User();
        user.setId(id);
        UserModel.select(user);
        
    }
}