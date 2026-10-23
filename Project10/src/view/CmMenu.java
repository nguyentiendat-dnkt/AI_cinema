/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.HashMap;
import java.util.Scanner;
import model.ContentManager;
import model.Inputter;
import model.Movie;

/**
 *
 * @author admin
 */
public class CmMenu {
    public void showCmMenu(Scanner scanner, ContentManager cm, HashMap<String, Movie> movies){
        int choice;
        do {
            System.out.println("----------CONTENT MANAGER----------\n"
                             + "-       1. Them phim              -\n"
                             + "-       2. Xoa phim               -\n"
                             + "-       3. Chinh sua phim         -\n"
                             + "-       0. Quay ve menu truoc     -\n"
                             + "-----------------------------------\n");
            choice = Inputter.inputInt(scanner, "Chon chuc nang: ");
            switch (choice) {
                case 1:
                    cm.addMovie(scanner, movies);
                    break;
                case 2:
                    cm.deleteMovie(scanner, movies);
                    break;
                case 3:
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
}
