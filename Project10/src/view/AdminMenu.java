/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.Scanner;
import model.Admin;
import java.util.HashMap;
import java.util.Scanner;
import model.Inputter;
import model.Movie;
import model.Transaction;
import model.User;



/**
 *
 * @author admin
 */
public class AdminMenu {
    public void showAdminMenu(Scanner scanner, Admin admin, HashMap<String, User> userList){
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
                    System.out.println("\n--- THONG KE SO PHIM DA DUOC MUA ---");
                    if (userList == null || userList.isEmpty()) {
                        System.out.println("He thong chua co user nao!");
                        break;
                    }
                    int totalBought = 0;
                    for (User user : userList.values()) {
                        totalBought += user.getPurchaseMovies().size();
                    }
                    System.out.println("Tong so luot mua phim tren toan he thong: " + totalBought);
                    break;
                case 2:
                    System.out.println("\n--- DINH GIA COIN ---");
                    System.out.println("So coin diem danh hang ngay hien tai: " + admin.getDailyReward() + " coins");
                    admin.setDailyReward(scanner);
                    System.out.println(">> Gia coin moi sau khi cap nhat: " + admin.getDailyReward() + " coins/ngay");
                    break;
                case 3:
                    System.out.println("\n--- DANH SACH THONG TIN USER ---");
                    if (userList == null || userList.isEmpty()) {
                        System.out.println("He thong chua co user nao!");
                        break;
                    }
                    System.out.printf("| %-8s | %-18s | %-12s | %-15s |\n", "ID", "Ten User", "So Du Coin", "So Phim Da Mua");
                    System.out.println("------------------------------------------------------------------");
                    for (User user : userList.values()) {
                        int totalCoins = user.getWallet().getMainCoin() + user.getWallet().getBonusCoin();
                        System.out.printf("| %-8s | %-18s | %-12s | %-15d |\n",
                                user.getMemberId(),
                                user.getName(),
                                totalCoins + " Coins",
                                user.getPurchaseMovies().size());
                    }
                    break;
                case 4:
                    System.out.println("\n--- TAT CA LICH SU GIAO DICH TRONG HE THONG ---");
                    if (userList == null || userList.isEmpty()) {
                        System.out.println("He thong chua co user nao!");
                        break;
                    }
                    boolean hasTrans = false;
                    for (User user : userList.values()) {
                        if (!user.getTransactions().isEmpty()) {
                            hasTrans = true;
                            System.out.println("\n>> Giao dich cua User: " + user.getName() + " (ID: " + user.getMemberId() + "):");
                            for (Transaction t : user.getTransactions()) {
                                System.out.println("   [" + t.getTransId() + "] " 
                                                 + t.getTransType() + " | " 
                                                 + t.getAmount() + " coins | Ngay: " 
                                                 + t.getDate() + " " + t.getTime());
                            }
                        }
                    }
                    if (!hasTrans) {
                        System.out.println("Chua co bat ky giao dich nao phat sinh tren he thong!");
                    }
                    break;
                case 5:
                    System.out.println("\n--- THONG KE DOANH THU HE THONG ---");
                    if (userList == null || userList.isEmpty()) {
                        System.out.println("He thong chua co user nao!");
                        break;
                    }
                    int movieRevenue = 0;
                    int membershipRevenue = 0;
                    for (User user : userList.values()) {
                        for (Transaction t : user.getTransactions()) {
                            // Tiền mua phim / gói hội viên bị trừ được lưu số âm (-80), Math.abs lấy ra số dương thu về
                            if (t.getTransType().equalsIgnoreCase("MUA_PHIM")) {
                                movieRevenue += Math.abs(t.getAmount());
                            } else if (t.getTransType().equalsIgnoreCase("DANG_KY_GOI")) {
                                membershipRevenue += Math.abs(t.getAmount());
                            }
                        }
                    }
                    int totalRevenue = movieRevenue + membershipRevenue;
                    System.out.println("1. Doanh thu tu ban phim: " + movieRevenue + " Coins");
                    System.out.println("2. Doanh thu tu dang ky goi hoi vien: " + membershipRevenue + " Coins");
                    System.out.println("---------------------------------------------");
                    System.out.println("=> TONG DOANH THU HE THONG: " + totalRevenue + " Coins");
                    break;
                case 0:
                    System.out.println("Quay lai menu chon role");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
    }

    public void loginAdmin() {
        //code
    }
}