/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.ArrayList;

/**
 *
 * @author Nguyen Kim Thuy Duon
 */
public class Member {
    private String userId;
    private String name;
    private Wallet wallet;
    private Membership membership;
    private ArrayList<Movie> purchaseMovie;
    private ArrayList<Transaction> transactions;

    public Member() {
        this.wallet = new Wallet(0, 0);
        this.membership = null;
        this.purchaseMovie = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    public Member(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.wallet =new Wallet(0, 0);
        this.membership = null;
        this.purchaseMovie = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public Membership getMembership() {
        return membership;
    }

    public ArrayList<Movie> getPurchaseMovie() {
        return purchaseMovie;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
    
    public boolean purchaseMovie(Movie mv){
        if(mv == null){
            System.out.println("Phim khong ton tai");
            return false;
        }if(mv.isFree()){
            System.out.println("Phim mien phi");
            return false;
        }if(purchaseMovie.contains(mv)){
            System.out.println("Phim da co trong danh sach");
            return false;
        }if(wallet.deductCoin(mv.getMoviePrice())==false){
            System.out.println("Giao dich khong thanh cong");
            return false;
        }else{
            purchaseMovie.add(mv);
            String transId = "T" + (transactions.size() + 1);
            transactions.add(new Transaction(transId, "MUA_PHIM", -mv.getMoviePrice()));
            
            System.out.println("Mua phim " + mv.getTitle() + " thanh cong!");
            return true;
        }       
    } 

    public boolean watchMovie(Movie mv){
        if(mv == null){
            System.out.println("Phim khong ton tai");
            return false;
        }if(mv.isFree() || purchaseMovie.contains(mv) || (membership!=null && membership.isMemsActive())){
            System.out.println("Phim "+ mv.getTitle() +" dang duoc chieu");
            return true;
        }
        System.out.println("Chua xem duoc phim nay");
        return false;
    }
    
    public void checkIn(){
        int dailyReward = 10;
        wallet.addBonusCoin(dailyReward);
        String transId = "T" + (transactions.size() + 1);
        transactions.add(new Transaction(transId, "DIEM_DANH", dailyReward));
        System.out.println("Diem danh thanh cong");
    }
    
    public boolean buyMembership(Membership memsPlan){
        if(membership != null && membership.isMemsActive()){
            System.out.println("Co goi van con han");
            return false;
        }if(wallet.deductCoin(memsPlan.getMemsPrice())==false){
            System.out.println("Giao dich khong thanh cong");
            return false;
        }
        membership = memsPlan;
        memsPlan.active();
        String transId = "T" + (transactions.size() + 1);
        transactions.add(new Transaction(transId, "DANG_KY_GOI", -memsPlan.getMemsPrice()));
        System.out.println("Dang ky goi thanh vien thanh cong!");
        return true;
    }
    
    public void viewTransactionHistory(){
        if(transactions.isEmpty()){
            System.out.println("Chua co giao dich");
            return;
        }
        for (int i = 0; i < transactions.size(); i++) {
            Transaction t = transactions.get(i);
            System.out.println(t.getTransId()+" | "+ t.getTransType() + " | " + t.getAmount()+" | "+ t.getDate()+ " | "+ t.getTime());
        }
    }

}
