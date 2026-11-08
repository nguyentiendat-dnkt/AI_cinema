/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author Nguyen Kim Thuy Duon
 */
public class Transaction {

    private String transId;
    private String transType;
    private int amount;
    private LocalDate date;

    public Transaction() {
    }

    public Transaction(String transId, String transType, int amount) {
        this.transId = transId;
        this.transType = transType;
        this.amount = amount;
    }
    
    
    public Transaction(String transId, String transType, int amount, LocalDate date) {
        this.transId = transId;
        this.transType = transType;
        this.amount = amount;
        this.date = LocalDate.now();
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return transId + ", " + transType + ", " + amount + ", " + date;
    }

}
