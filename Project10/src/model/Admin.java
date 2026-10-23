/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Scanner;

/**
 *
 * @author Nguyen Kim Thuy Duon
 */
public class Admin extends Member{
    private int dailyReward;

    public Admin() {
        super();
    }

    public Admin(int dailyReward, String memberId, String name) {
        super(memberId, name);
        this.dailyReward = dailyReward;
    }

    public int getDailyReward() {
        return dailyReward;
    }
    
    public void setDailyReward(Scanner sc){
        this.dailyReward = Inputter.inputInt(sc, "So coin diem danh hang ngay: ");
        System.out.println("Set coin thanh cong");
    }
    
    
    
    public void showUser(){
    }
}
