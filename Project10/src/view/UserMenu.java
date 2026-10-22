/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.HashMap;
import java.util.Scanner;
import model.Inputter;
import model.Membership;
import model.Movie;
import model.User;

/**
 *
 * @author Nguyen Kim Thuy Duon
 */
public class UserMenu {
    
    public void showUserMenu(Scanner scanner, HashMap<String, Movie> movies, User user, Membership plan){
        int choice;
        do {
            System.out.println("--------------------USER--------------------\n"
                             + "-    1. Xem danh sach phim                 -\n"
                             + "-    2. Mua phim                           -\n"
                             + "-    3. Xem phim da mua                    -\n"
                             + "-    4. Diem danh nhan coin                -\n"
                             + "-    5. Dang ky goi thanh vien             -\n"
                             + "-    6. Xem so du vi                       -\n"
                             + "-    7. Xem lich su giao dich              -\n"
                             + "-    0. Quay lai menu truoc!               -\n"
                             + "--------------------------------------------\n");
            choice = Inputter.inputInt(scanner, "Chon chuc nang: ");
            switch (choice) {
                case 1:
                    showMovieList(movies);
                    break;
                case 2:
                    buyMovie(scanner, movies, user);
                    break;
                case 3:
                    watchMovie(scanner, movies, user);
                    break;
                case 4:
                    user.checkIn();
                    break;
                case 5:
                    user.buyMembership(plan);
                    break;
                case 6:
                    user.getWallet().showWalletInfo();
                    break;
                case 7:
                    user.viewTransactionHistory();
                    break;
                case 0:
                    System.out.println("Quay lai menu chon role");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
    }

    private void showMovieList(HashMap<String, Movie> movies) {
        if (movies.isEmpty()) {
            System.out.println("Kho phim hien dang rong!");
        }else {
            for (Movie movie : movies.values()) {
                movie.showMovie();
            }
        }
    }

    private void buyMovie(Scanner scanner, HashMap<String, Movie> movies, User user) {
        System.out.println("--- MUA PHIM ---");
        if (movies.isEmpty()) {
            System.out.println("Kho phim hien dang rong!");
        }
        for (Movie movie : movies.values()) {
            movie.showMovie();
        }
        String buyId = Inputter.inputString(scanner, "Nhap ID phim: ");
        Movie buyMovie = movies.get(buyId);
        user.purchaseMovie(buyMovie);
    }

    private void watchMovie(Scanner scanner, HashMap<String, Movie> movies, User user) {
        System.out.println("--- XEM PHIM ---");
        for (Movie movie : movies.values()) {
            movie.showMovie();
        }
        String watchId = Inputter.inputString(scanner, "Nhap ma phim muon xem: ");
        Movie watchMovie = movies.get(watchId);
        user.watchMovie(watchMovie);
    }


}
