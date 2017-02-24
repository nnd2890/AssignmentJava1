/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.java.view;

import assignment.java.controller.UserController;
import assignment.java.utility.ScannerUtil;

/**
 *
 * @author nnd2890
 */
public class ConsoleMenu {

    public static void main(String[] args) {
        printMenu();
    }

    static void printMenu() {
        while (true) {
            // Local variable
            int choice ;
            // Display menu graphics
            System.out.println("==============================");
            System.out.println("| Phần mềm quản lý sinh viên |");
            System.out.println("==============================");
            System.out.println("| Lựa chọn:                  |");
            System.out.println("|        1. Danh sách.       |");
            System.out.println("|        2. Thêm mới.        |");
            System.out.println("|        3. Sửa thông tin.   |");
            System.out.println("|        4. Xoá.             |");
            System.out.println("|        5. Tìm kiếm.        |");
            System.out.println("|        6. Exit             |");
            System.out.println("==============================");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = ScannerUtil.getInt();

            // Switch construct
            switch (choice) {
                case 1:
                    UserController.processList();
                    break;
                case 2:
                    UserController.processInsert();
                    break;
                case 3:
                    UserController.processUpdate();
                    break;
                case 4:
                    UserController.processDelete();
                    break;
                case 5:
                    System.out.println("Tìm kiếm sinh viên.");
                    break;
                case 6:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn sai. Vui lòng lựa chọn trong khoảng từ 1 đến 6.");
                    break; // This break is not really necessary
            }
            if (choice == 6) {
                break;
            }
        }
    }
}

