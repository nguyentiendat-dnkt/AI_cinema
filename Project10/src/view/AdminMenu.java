/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.Scanner;
import model.Admin;
import model.Inputter;

/**
 *
 * @author admin
 */
public class AdminMenu {
    public void showAdminMenu(Scanner scanner,Admin admin){
        int choice;
        do {
            System.out.println("--------------------ADMIN--------------------\n"
                             + "-       1. Set coin diem danh               -\n"
                             + "-       2. Dinh gia coin                    -\n"
                             + "-       3. Thong tin nguoi dung             -\n"
                             + "-       0. Quay ve menu truoc               -\n"
                             + "---------------------------------------------\n");
            choice = Inputter.inputInt(scanner, "Chon chuc nang: ");
            switch (choice) {
                case 1:
                    admin.setDailyReward(scanner);
                    break;
                case 2:
                    //admin.exchangeCoin();
                    break;
                case 3:
                    admin.showUser();
                    break;
                case 0:
                    System.out.println("Quay lai menu chon role");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
    }
}
