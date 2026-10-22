/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ct;

import java.time.LocalDate;
import java.util.Scanner;
import model.Member;
import model.Membership;
import model.Movie;
import java.util.HashMap;
import model.Admin;
import model.ContentManager;
import model.Inputter;
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
        ContentManager cm = new ContentManager();
        AdminMenu adMenu = new AdminMenu();
        Admin admin = new Admin();
        User user = new User("M1", "Dat", new Wallet(0, 0));
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
                    userMenu.showUserMenu(ns, movies, user, plan);
                    break;
                case 2:
                    cmMenu.showCmMenu(ns, cm, movies);
                    break;
                    
                case 3:
                    adMenu.showAdminMenu(ns, admin);
                    break;
//                    
//                case 5:
//                    System.out.println("--- ĐĂNG KÝ GÓI THÀNH VIÊN ---");
//                    member.buyMembership(plan);
//                    break;
//                    
//                case 6:
//                    System.out.println("\n--- HỦY GÓI THÀNH VIÊN ---");
//                    if (member.getMembership() != null) {
//                        member.getMembership().cancel();
//                    } else {
//                        System.out.println("Ban chua dang ky goi thanh vien nao!");
//                    }
//                    break;
//                    
//                case 7:
//                    System.out.println("\n--- NẠP COIN ---");
//                    int coin = Inputter.inputInt(ns, "Nhap so coin muon nap: ");
//                    member.getWallet().addCoin(coin);
//                    break;
//                    
//                case 8:
//                    System.out.println("\n--- XEM SỐ DƯ VÍ ---");
//                    member.getWallet().showWalletInfo();
//                    break;
//                    
//                case 9:
//                    System.out.println("\n--- LỊCH SỬ GIAO DỊCH ---");
//                    member.viewTransactionHistory();
//                    break;
//                    
//                case 10:
//                    System.out.println("\n--- QUẢN LÝ KHO PHIM ---");
//                    System.out.println("1. Them phim moi");
//                    System.out.println("2. Xoa phim");
//                    System.out.println("0. Quay lai");
//                    
//                    int movieChoice = Inputter.inputInt(ns, "Chon thao tac (0-2): ");
//
//                    switch (movieChoice) {
//                        case 1:
//                            String id = Inputter.inputString(ns, "Nhap ID: ");
//                            String title = Inputter.inputString(ns, "Nhap ten phim: ");
//                            String genre = Inputter.inputString(ns, "Nhap the loai: ");
//                            int price = Inputter.inputInt(ns, "Nhap gia (coin): ");
//                            int year = Inputter.inputInt(ns, "Nhap nam phat hanh: ");
//                            int month = Inputter.inputInt(ns, "Nhap thang phat hanh: ");
//                            int day = Inputter.inputInt(ns, "Nhap ngay phat hanh: ");
//                            int duration = Inputter.inputInt(ns, "Nhap thoi luong (phut): ");
//                            String producer = Inputter.inputString(ns, "Nhap nha san xuat: ");
//
//                            Movie newMovie = new Movie(
//                                    id, title, genre, price,
//                                    (price == 0),
//                                    LocalDate.of(year, month, day),
//                                    duration, producer
//                            );
//
//                            movies.add(newMovie);
//                            System.out.println("Them phim moi thanh cong!");
//                            break;

//                        case 2:
//                            String deleteId = Inputter.inputString(ns, "Nhap ID phim can xoa: ");
//                            Movie deleteMovie = searchById(deleteId, movies);
//
//                            if (deleteMovie != null) {
//                                movies.remove(deleteMovie);
//                                System.out.println("Xoa phim thanh cong!");
//                            } else {
//                                System.out.println("Khong tim thay phim!");
//                            }
//                            break;
//
//                        case 0:
//                            System.out.println("Quay lai menu chinh.");
//                            break;
//
//                        default:
//                            System.out.println("Lua chon khong hop le.");
//                            break;
//                    }
//                    break;

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