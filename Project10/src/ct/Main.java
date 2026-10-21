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
import java.util.ArrayList;
import model.Inputter;

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
        Member member = new Member("M01", "Dat");
        Membership plan = new Membership("Weekly", 30, false);
        ArrayList<Movie> movies = new ArrayList<>(); 
        int chon;
        do {            
            System.out.println("----------HE THONG QUAN LY AI CINEMA----------"
                              +"-         1. USER                            -"
                              +"-         2. CONTENT MANAGEMENT              -"
                              +"-         3. ADMIN                           -"
                              +"-         4. Thoat chuong trinh              -"
                              +"----------------------------------------------");
            
            chon = Inputter.inputInt(ns, "Ban la ai???: ");

            switch (chon) {
                case 1:
                    menuUser(ns);
//                    if (movies.isEmpty()) {
//                        System.out.println("Kho phim hien dang rong!");
//                    } else {
//                        for (Movie movie : movies) {
//                            movie.showMovie();
//                        }
//                    }
                    break;
                    
                case 2:
                    menuCM(ns);
//                    System.out.println("--- MUA PHIM ---");
//                    if (movies.isEmpty()) {
//                        System.out.println("Kho phim hien dang rong!");
//                        break;
//                    }
//                    for (Movie movie : movies) {
//                        movie.showMovie();
//                    }
//                    String buyId = Inputter.inputString(ns, "Nhap ID phim: ");
//                    Movie buyMovie = searchById(buyId, movies);
//                    member.purchaseMovie(buyMovie);
                    break;
                    
                case 3:
                    menuAdmin(ns);
//                    System.out.println("--- XEM PHIM ---");
//                    for (Movie movie : movies) {
//                        movie.showMovie();
//                    }
//                    String watchId = Inputter.inputString(ns, "Nhap ma phim muon xem: ");
//                    Movie watchMovie = searchById(watchId, movies);
//                    member.watchMovie(watchMovie);
                    break;
                    
//                case 4:
//                    System.out.println("--- ĐIỂM DANH HÀNG NGÀY ---");
//                    member.checkIn();
//                    break;
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
//
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
   
    public static Movie searchById(String movieId, ArrayList<Movie> movies) {
        if (movieId == null || movies == null){
            return null;
        }
        for (Movie movie : movies) {
            if (movie.getMovieId().equalsIgnoreCase(movieId)) {
                return movie;
            }
        }
        return null;
    }
}   