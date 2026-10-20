/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Nguyen Kim Thuy Duon
 */
public class Membership {
    private String memsName;
    private int memsPrice;
    private boolean memsActive;

    public Membership() {
    }
    
    public Membership(String memsName, int memsPrice, boolean memsActive) {
        this.memsName = memsName;
        this.memsPrice = memsPrice;
        this.memsActive = memsActive;
    }

    public String getMemsName() {
        return memsName;
    }

    public void setMemsName(String memsName) {
        this.memsName = memsName;
    }

    public int getMemsPrice() {
        return memsPrice;
    }

    public void setMemsPrice(int memsPrice) {
        this.memsPrice = memsPrice;
    }

    public boolean isMemsActive() {
        return memsActive;
    }

    public void setMemsActive(boolean memsActive) {
        this.memsActive = memsActive;
    }
    
    public void active(){
        this.memsActive = true;
    } 
    
    public void cancel(){
        if(this.memsActive){
            this.memsActive = false;
            System.out.println("Da huy goi thanh cong");
        }else {
            System.out.println("Goi da huy tu truoc");
        }
    }
    
}
