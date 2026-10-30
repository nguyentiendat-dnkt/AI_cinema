/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import model.Movie;

/**
 *
 * @author Nguyen Kim Thuy Duon
 */
public class FileManage {
    
    public void saveToFile(HashMap<String, Movie> movies) throws IOException{
        File f = new File("./file.csv");
        FileWriter fw = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(fw);
        for (Movie mv : movies.values()) {
            bw.write(mv.toString());
        }
        bw.close();
        fw.close();
        
    }
}
