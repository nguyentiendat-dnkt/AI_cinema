/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Nguyen Kim Thuy Duon
 */
public class Wallet {
    private int mainCoin;
    private int bonusCoin;

    public Wallet(int mainCoin, int bonusCoin) {
        this.mainCoin = mainCoin;
        this.bonusCoin = bonusCoin;
    }

    public int getMainCoin() {
        return mainCoin;
    }

    public void setMainCoin(int mainCoin) {
        this.mainCoin = mainCoin;
    }

    public int getBonusCoin() {
        return bonusCoin;
    }

    public void setBonusCoin(int bonusCoin) {
        this.bonusCoin = bonusCoin;
    }
    
    public void addCoin(int amount){
        if(amount >0){
            mainCoin += amount;
            System.out.println("Da nap tien thanh cong");
        }else {
            System.out.println("Khong hop le");
        }
    }
    
    public void addBonusCoin(int amount){
       if (amount > 0) {
            this.bonusCoin += amount;
            System.out.println("Bạn đã nhận được " + amount + " bonus coins!");
        }else {
            System.out.println("Khong hop le");
       }
    }
    
    public boolean deductCoin(int amount){
        if(amount <= 0){
            return false;
        }if (mainCoin + bonusCoin < amount){
            return false;
        }if (mainCoin >= amount){
            mainCoin -= amount;
        }else {
            int temp = amount - mainCoin;
            mainCoin = 0;
            bonusCoin = bonusCoin - temp;
        }
        return true;
    }
    
    public double viewWallet(){
        return mainCoin + bonusCoin;
    }

    public void showWalletInfo() {
        System.out.println("Main Coin: " + mainCoin);
        System.out.println("Bonus Coin: " + bonusCoin);
        System.out.println("Tong so du: " + (mainCoin + bonusCoin) + " Coins");
    }
}
