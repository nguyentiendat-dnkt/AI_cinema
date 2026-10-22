/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import ct.Main;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Nguyen Kim Thuy Duon
 */
public class ContentManager extends Member{

    public ContentManager() {
        super();
    }
    
    public ContentManager(String memberId, String name){
        super(memberId, name);
    }
    
    public void addMovie(Scanner sc, HashMap<String, Movie> movies){
        System.out.println("--- THEM PHIM MOI ---");
    }
    
    public void deleteMovie(){
    }
    
    public void editMovie(){
    }
}
