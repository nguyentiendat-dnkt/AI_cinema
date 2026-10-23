/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

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
        String id = Inputter.inputString(sc, "Nhap ID: ");
        String title = Inputter.inputString(sc, "Nhap ten phim: ");
        String genre = Inputter.inputString(sc, "Nhap the loai: ");
        int price = Inputter.inputInt(sc, "Nhap gia (coin): ");
        int duration = Inputter.inputInt(sc, "Nhap thoi luong (phut): ");
        String producer = Inputter.inputString(sc, "Nhap nha san xuat: ");
        
        Movie newMovie = new Movie(id, title, genre, price, true, duration, producer);
        movies.put(id, newMovie);
        
        System.out.println("Them phim thanh cong!");
    }
    
    public void deleteMovie(Scanner sc, HashMap<String, Movie> movies){
        String deleteId = Inputter.inputString(sc, "Nhap ID phim can xoa: ");
        Movie deleteMovie = movies.get(deleteId);

        if (deleteMovie != null) {
            movies.remove(deleteId);
            System.out.println("Xoa phim thanh cong!");
        } else {
            System.out.println("Khong tim thay phim!");
        }
    }
    
    public void editMovie(Scanner sc, HashMap<String, Movie> movies){
        String editId = Inputter.inputString(sc, "Nhap id phim can sua: ");
        Movie editMovie = movies.get(editId);
        
        if (editMovie != null){
            editMovie.setTitle(Inputter.inputString(sc, "Nhap ten phim moi: "));
            editMovie.setGenre(Inputter.inputString(sc, "Nhap the loai moi: "));
            editMovie.setMoviePrice(Inputter.inputInt(sc, "Nhap gia moi: "));
            editMovie.setDuration(Inputter.inputInt(sc, "Nhap thoi luong phim moi: "));
            editMovie.setProducer(Inputter.inputString(sc, "Nhap nha san xuat moi: "));
            
            System.out.println("Cap nhat phim thanh cong");
        }else{
            System.out.println("Khong tim thay phim");
        }
    }
}
