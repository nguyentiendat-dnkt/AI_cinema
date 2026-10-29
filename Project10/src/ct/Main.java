/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ct;

import java.util.Scanner;
import model.Membership;
import model.Movie;
import java.util.HashMap;
import model.Admin;
import model.ContentManager;
import model.Inputter;
import model.Member;
import view.UserMenu;
import model.User;
import model.Wallet;
import view.AdminMenu;
import view.CmMenu;

/**
 *
 * @author Nguyen Kim Thuy Duon
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner ns = new Scanner(System.in);
        UserMenu userMenu = new UserMenu();
        CmMenu cmMenu = new CmMenu();
        AdminMenu adMenu = new AdminMenu();
        HashMap<String, User> userList = new HashMap<>();
        Membership plan = new Membership("Weekly", 30, false);
        HashMap<String, Movie> movies = new HashMap<>();
        int chon;
        do {            
            System.out.println("----------HE THONG QUAN LY AI CINEMA----------\n"
                              +"-         1. USER                            -\n"
                              +"-         2. CONTENT MANAGEMENT              -\n"
                              +"-         3. ADMIN                           -\n"
                              +"-         0. Thoat chuong trinh              -\n"
                              +"----------------------------------------------\n");
            
            chon = Inputter.inputInt(ns, "Ban la ai???: ");

            switch (chon) {
                case 1:
                    userMenu.loginUser(ns, movies, userList, plan);
                    break;
                case 2:
                    cmMenu.loginCm();
                    break;     
                case 3:
                    adMenu.loginAdmin();
                    break;
                case 0:
                    System.out.println("Tam biet!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn từ 0 đến 10.");
            }
        } while (chon != 0);

        ns.close();
    }

}   