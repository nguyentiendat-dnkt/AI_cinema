/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.HashMap;
import java.util.Scanner;
import model.ContentManager;
import model.Inputter;
import model.Member;
import model.Movie;
import model.User;

/**
 *
 * @author admin
 */
public class CmMenu {
    public void showCmMenu(Scanner scanner, ContentManager cm, Member member, HashMap<String, Movie> movies){
        int choice;
        do {
            System.out.println("----------CONTENT MANAGER----------\n"
                             + "-       1. Xem danh sach phim     -\n"
                             + "-       2. Them phim              -\n"
                             + "-       3. Xoa phim               -\n"
                             + "-       4. Chinh sua phim         -\n"
                             + "-       0. Thoat                  -\n"
                             + "-----------------------------------\n");
            choice = Inputter.inputInt(scanner, "Chon chuc nang: ");
            switch (choice) {
                case 1:
                    member.showMovieList(movies);
                    break;
                case 2:
                    cm.addMovie(scanner, movies);
                    break;
                case 3:
                    cm.deleteMovie(scanner, movies);
                    break;
                case 4:
                    cm.editMovie(scanner, movies);
                    break;
                case 0:
                    System.out.println("Quay lai menu chon role");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
    }

    public void loginCm(Scanner sc, HashMap<String,ContentManager>cMList, HashMap<String,Movie>movie) {
        System.out.println("Dang nhap quan ly");
        String id=Inputter.inputString(sc, "Nhap ID quan ly: ");
        
        if(!cMList.containsKey(id)){
            System.out.println("Tai khoan khong ton tai, vui long thu lai");
            return;
        }
        ContentManager cM=cMList.get(id);
        String pass= Inputter.inputString(sc,"Nhap mat khau: ");
        if(!cM.getPassword().equals(pass)){
            System.out.println("Sai mat khau, vui long thu lai");
            return;
        }
        System.out.println("Dang nhap thanh cong vao tai khoan "+ cM.getName());
        showCmMenu(sc, cM, cM, movie);
    }

}
