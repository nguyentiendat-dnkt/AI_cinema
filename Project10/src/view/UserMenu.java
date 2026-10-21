/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.Scanner;
import model.Inputter;
import model.User;

/**
 *
 * @author Nguyen Kim Thuy Duon
 */
public class UserMenu {
    
    public void menuUser(){
        Scanner ns = new Scanner(System.in);
        int choice;
        do {
            System.out.println("--------------------USER--------------------"
                             + "- 1."
                             + "- 2."
                             + "- 3."
                             + "- 4."
                             + "- 5."
                             + "- 6."
                             + "- 7."
                             + "- 0.");
            choice = Inputter.inputInt(ns."nhap");
            switch (choice) {
                case 1:
                    currentUser.purchaseMovie();
                    break;
                case 1:
                    
                    break;
                case 1:
                    
                    break;
                case 1:
                    
                    break;
                case 1:
                    
                    break;
                case 1:
                    
                    break;
                case 1:
                    
                    break;
                case 1:
                    
                    break;
                default:
                    throw new AssertionError();
            }
        } while (true);
    }
}
