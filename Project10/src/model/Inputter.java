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
        System.out.print(tb);
        return Integer.parseInt(sc.nextLine());
    }
}
