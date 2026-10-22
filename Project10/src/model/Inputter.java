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
public class Inputter {
    public static String inputString(Scanner sc, String tb) {
        System.out.print(tb);
        return sc.nextLine();
    }
    
    public static int inputInt(Scanner sc, String tb) {
        int kq = 0;
        boolean lap = true;
        do {
            try {
                System.out.print(tb);
                kq = sc.nextInt();
                lap = false;
                return kq;
            } catch (Exception e) {
                System.out.println("Ban da nhap sai. Vui long nhap lai!");
                sc.nextLine();
            }
        } while (lap);
        return kq;
    }
    
    public static double inputDouble (Scanner sc, String tb) {
        System.out.print(tb);
        double kq = sc.nextDouble();
        return kq;
    }
}
