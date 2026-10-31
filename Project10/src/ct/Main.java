/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ct;

import data.FileManage;
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
        FileManage fm = new FileManage();
        HashMap<String, User> userList = new HashMap<>();
        HashMap<String,ContentManager> cMList= new HashMap<>();
        HashMap<String,Admin> adminList=new HashMap<>();
        Membership plan = new Membership("Weekly", 30, false);
        HashMap<String, Movie> movies = new HashMap<>();
        ContentManager cM1= new ContentManager("cm1","Dat","123");
        ContentManager cM2= new ContentManager("cm2","Huy","321");
        Admin ad1=new Admin("ad1", "Cho Tinh", "1234");
        User us1=new User("us1","Bunni","12345", new Wallet(0, 0));
        cMList.put("cm1", cM1);
        cMList.put("cm2", cM2);
        adminList.put("ad1", ad1);
        userList.put("us1", us1);
        
        fm.readFromFile(movies);
        int chon;
        do {
            System.out.println("----------HE THONG QUAN LY AI CINEMA----------\n"
                              +"-         1. USER                            -\n"
                              +"-         2. CONTENT MANAGEMENT              -\n"
                              +"-         3. ADMIN                           -\n"
                              +"-         0. Thoat chuong trinh              -\n"
                              +"----------------------------------------------\n");
            
            chon = Inputter.inputInt(ns, "Select Role: ");

            switch (chon) {
                case 1:
                    userMenu.showMenuLoginUser(ns, movies, userList, plan);
                    break;
                case 2:
                    cmMenu.showCmMenu(ns, cM2, cM2, movies);
                    break;     
                case 3:
                    adMenu.showAdminMenu(ns, ad1, userList);
                    break;
                case 0:
                    fm.saveToFile(movies);
                    System.out.println("Tam biet!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn từ 0 đến 10.");
            }
        } while (chon != 0);

        ns.close();
    }

}   
