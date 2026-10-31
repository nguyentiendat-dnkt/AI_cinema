/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import model.Movie;

/**
 *
 * @author Nguyen Kim Thuy Duon
 */
public class FileManage {

    public void saveToFile(HashMap<String, Movie> movies) {
        try {
            File f = new File("./movie.csv");
            try ( FileWriter fw = new FileWriter(f);  BufferedWriter bw = new BufferedWriter(fw)) {
                for (Movie mv : movies.values()) {
                    bw.write(mv.toString());
                    bw.newLine();
                }
            }
            System.out.println("Ghi file thanh cong");
        } catch (IOException e) {
            System.out.println("Loi");
        }
    }

    public void readFromFile(HashMap<String, Movie> movies) {
        try {
            File f = new File("./movie.csv");
            if (!f.exists()) {
                return;
            }
            try (FileReader fr = new FileReader(f); BufferedReader br = new BufferedReader(fr)) {
                String tam;
                while ((tam = br.readLine()) != null) {
                    Movie x = dataToObj(tam);
                    if (x != null) {
                        movies.put(x.getMovieId(), x);
                    }
                }
            }
            System.out.println("Doc file thanh cong");
        } catch (IOException e) {
        }

    }

    public Movie dataToObj(String tam) {
        try {
            String[] temp = tam.split(",");

            if (temp.length >= 7) {
                String movieId = temp[0];
                String title = temp[1];
                String genre = temp[2];
                int moviePrice = Integer.parseInt(temp[3]);
                boolean isFree = Boolean.parseBoolean(temp[4]);
                int duration = Integer.parseInt(temp[5]);
                String producer = temp[6];

                return new Movie(movieId, title, genre, moviePrice, isFree, duration, producer);
            }
        } catch (NumberFormatException e) {
            System.out.println("Loi");
        }
        return null;
    }
}
