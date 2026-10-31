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
import model.Wallet;

/**
 *
 * @author Nguyen Kim Thuy Duon
 */
public class UserMenu {
    
    public void showMenuLoginUser(Scanner ns, HashMap<String, Movie> movies, HashMap<String, User> userList, Membership plan) {

        int choice;
        do {
            System.out.println("--------------BANG DANG NHAP USER-------------\n"
                              +"-         1. DANG NHAP                       -\n"
                              +"-         2. DANG KY                         -\n"
                              +"-         0. QUAY LAI MENU CHINH             -\n"
                              +"----------------------------------------------\n");
            choice=Inputter.inputInt(ns,"Nhap lua chon cua ban: ");
            switch(choice){
               case 1:
                   loginUser(ns, movies, userList, plan);
                   break;
               case 2:
                   regisUser(ns, movies, userList, plan);
                   break;
               case 0:
                   return;
               default:
                   System.out.println("Du lieu khong hop le");
                   break;
            }
            
        } while (choice != 0);
    }
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
                    System.out.println("Quay lai menu User");
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
        String id=Inputter.inputString(scanner, "Nhap ID nguoi dung: ");
        if(!userList.containsKey(id)){
            System.out.println("Tai khoan khong ton tai, vui long thu lai hoac tao tai khoan");
            return;
        }
        User u=userList.get(id);
        String pass= Inputter.inputString(scanner,"Nhap mat khau: ");
        if(!u.getPassword().equals(pass)){
            System.out.println("Sai mat khau, vui long thu lai");
            return;
        }
        System.out.println("Dang nhap thanh cong vao tai khoan "+ u.getName());
        showUserMenu(scanner, movies, userList, u, plan);
    }
        
    public void regisUser(Scanner scanner, HashMap<String, Movie> movies, HashMap<String, User> userList, Membership plan){
        System.out.println("DANG KY");
        String id=Inputter.inputString(scanner, "Nhap ID: ");
        
        if (userList.containsKey(id)){
            System.out.println("Nguoi dung da ton tai, vui long tao lai");
            return;
        }
        String name=Inputter.inputString(scanner,"Nhap ten nguoi dung: ");
        String password=Inputter.inputString(scanner, "Nhap mat khau: ");
        User u= new User(id, name, password, new Wallet(0, 0));
        userList.put(id, u);
        System.out.println("Tao tai khoan thanh cong");
    }

    private void showMovieList(HashMap<String, Movie> movies) {
        //tao menu
        Movie.sortMvPriceAsc(movies);
        Movie.sortMvPriceDesc(movies);
        Movie.sortMvDurationAsc(movies);
        Movie.sortMvDurationDesc(movies);
    }

}
