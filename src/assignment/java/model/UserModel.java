/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.java.model;

import assignment.java.entity.User;
import assignment.java.utility.ScannerUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author nnd2890
 */
public class UserModel {
    // Showing the List
     public static void list() {
         try {
            Statement statement = DAO.getConnection().createStatement();
            String query = "SELECT * FROM sv";
            ResultSet rs = statement.executeQuery(query);
            System.out.println("|  ID  |  Name  |");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.format("|  %s  |  %s  |\n", id, name);
            }
            
        } catch (SQLException e) {
            System.err.println("Lỗi khi showList.");
        }
    }

    public static void insert(User user) {
        try {
            Statement statement = DAO.getConnection().createStatement();
            String query = "Insert into sv values('" + user.getId() + "', '" + user.getName() + "')";
            statement.execute(query);
        } catch (SQLException e) {
            System.err.println("Lỗi khi insert.");
        }
    }

   

   

    public static void update(User user) {
       try {
            Statement statement = DAO.getConnection().createStatement();
            String query = "update sv set name='"+ user.getName() +"' where id='" + user.getId() + "'";
            statement.executeUpdate(query);            
        } catch (SQLException e) {
            System.err.println("Lỗi khi showList.");
        }
    }

   

    public static void delete(User user) {
         try {
            Statement statement = DAO.getConnection().createStatement();
            String query = "delete from sv "
                    + "where id='" + user.getId() + "'";
            statement.executeUpdate(query);          
        } catch (SQLException e) {
            System.err.println("Lỗi khi delete.");
        }
    }     
   
    public static void select(User user){
        try {
           Statement statement = DAO.getConnection().createStatement();
           String query = "select * from sv "
                   + "where id='" + user.getId()+ "'";
           ResultSet rs = statement.executeQuery(query);
           System.out.println("|  ID  |  Name  |");
           while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.format("|  %s  |  %s  |\n", id, name);
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi select.");
        }
    }

    // test the features in Class
    public static void main(String[] args) {
        System.out.println("Nhập id.");
        int id = ScannerUtil.getInt();
        User user = new User();
        user.setId(id);
        
        
        
        UserModel.select(user);
    }
}
