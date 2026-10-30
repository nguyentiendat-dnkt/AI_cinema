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
    Scanner ns = new Scanner(System.in);
    public void showUserMenu(Scanner scanner, HashMap<String, Movie> movies, HashMap<String, User> userList, User user, Membership plan){
        int choice;
        do {
            System.out.println("--------------------USER--------------------\n"
                             + "-    1. Xem danh sach phim                 -\n"
                             + "-    2. Mua phim                           -\n"
                             + "-    3. Xem phim                           -\n"
                             + "-    4. Diem danh nhan coin                -\n"
                             + "-    5. Dang ky goi thanh vien             -\n"
                             + "-    6. Xem so du vi                       -\n"
                             + "-    7. Xem lich su giao dich              -\n"
                             + "-    0. Thoat                              -\n"
                             + "--------------------------------------------\n");
            choice = Inputter.inputInt(scanner, "Chon chuc nang: ");
            switch (choice) {
                case 1:
                    showMovieList(ns, movies);
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

    public void loginUser(Scanner scanner, HashMap<String, Movie> movies, HashMap<String, User> userList, Membership plan){
        System.out.println("DANG NHAP");
        // code chuc nang
        regisUser(scanner, movies, userList, plan); // ko co thi tao tai khoan moi
//        showUserMenu(scanner, movies, userList, user, plan); // show menu neu dang nhap thanh cong
    }
        
    public void regisUser(Scanner scanner, HashMap<String, Movie> movies, HashMap<String, User> userList, Membership plan){
        System.out.println("DANG KY");
        //code chuc nang
        loginUser(scanner, movies, userList, plan); //dang ky xong thi quay lai trang dang nhap
    }

    private void showMovieList(Scanner scanner, HashMap<String, Movie> movies) {
        int choice;
            do {
            System.out.println("--------------------SORT--------------------\n"
                             + "-    1. Highest - Lowest Price             -\n"
                             + "-    2. Lowest - Highest Price             -\n"
                             + "-    3. Longest - Shortest Duration        -\n"
                             + "-    4. Shortest - Longest Duration         -\n"
                             + "-    0. Thoat                              -\n"
                             + "--------------------------------------------\n");
            choice = Inputter.inputInt(scanner, "Chon bo loc: ");
            switch (choice) {
                case 1:
                    Movie.sortMvPriceDesc(movies);
                    break;
                case 2:
                    Movie.sortMvPriceAsc(movies);
                    break;
                case 3:
                    Movie.sortMvDurationDesc(movies);
                    break;
                case 4:
                    Movie.sortMvDurationAsc(movies);
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
        
