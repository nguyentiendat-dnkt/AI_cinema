/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Nguyen Kim Thuy Duon
 */
public class Admin extends Member{
    private int dailyReward;
    private int exchangeCoin;

    public Admin() {
    }

    public Admin(int dailyReward, int exchangeCoin, String memberId, String name) {
        super(memberId, name);
        this.dailyReward = dailyReward;
        this.exchangeCoin = exchangeCoin;
    }
    
    public void dailyReward(){
    }
    
    public void exchangeCoin(){
    }
    
    public void showUser(){
    }
}
