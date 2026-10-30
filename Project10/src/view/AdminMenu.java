/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.HashMap;
import java.util.Scanner;
import model.Admin;
import model.ContentManager;
import model.Inputter;
import model.Movie;

/**
 *
 * @author admin
 */
public class AdminMenu {
    public void showAdminMenu(Scanner scanner,Admin admin){
        int choice;
        do {
            System.out.println("--------------------ADMIN--------------------\n"
                             + "-       1. Thong ke so phim da duoc mua     -\n"
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

    public void loginAdmin(Scanner sc, HashMap<String,Admin>adminList, HashMap<String,Movie>movie) {
        System.out.println("Dang nhap Admin");
        String id=Inputter.inputString(sc, "Nhap ID Admin: ");
        
        if(!adminList.containsKey(id)){
            System.out.println("Tai khoan khong ton tai, vui long thu lai");
            return;
        }
        Admin ad=adminList.get(id);
        String pass= Inputter.inputString(sc,"Nhap mat khau: ");
        if(!ad.getPassword().equals(pass)){
            System.out.println("Sai mat khau, vui long thu lai");
            return;
        }
        System.out.println("Dang nhap thanh cong vao tai khoan "+ ad.getName());
        showAdminMenu(sc, ad);
    }
}
