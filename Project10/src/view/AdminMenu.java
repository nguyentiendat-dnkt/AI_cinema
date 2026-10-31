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
                             + "-       1. Thong kee so phim da duoc mua     -\n"
                             + "-       2. Dinh gia coin                    -\n"
                             + "-       3. Xem thong tin user               -\n"
                             + "-       4. Xem tat ca lich su giao dich     -\n"
                             + "-       5. Thong ke doanh thu               -\n"
                             + "-       0. Thoat                            -\n"
                             + "---------------------------------------------\n");
            choice = Inputter.inputInt(scanner, "Chon chuc nang: ");
            switch (choice) {
                case 1:
                    //code
                    break;
                case 2:
                    //code
                    break;
                case 3:
                    //code
                    break;
                case 4:
                    //code
                    break;
                case 5:
                    //code
                    break;
                case 0:
                    System.out.println("Quay lai menu chon role");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
    }

    public void loginAdmin() {
        //code
    }
}
