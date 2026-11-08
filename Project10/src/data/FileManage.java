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
import java.time.LocalDate;
import java.util.HashMap;
import model.Movie;
import model.Transaction;
import model.User;
import model.Wallet;

/**
 *
 * @author Nguyen Kim Thuy Duon
 */
public class FileManage {

    //Movie
    public void saveToFileM(HashMap<String, Movie> movies) {
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

    public void readFromFileM(HashMap<String, Movie> movies) {
        try {
            File f = new File("./movie.csv");
            if (!f.exists()) {
                return;
            }
            try ( FileReader fr = new FileReader(f);  BufferedReader br = new BufferedReader(fr)) {
                String tam;
                while ((tam = br.readLine()) != null) {
                    Movie x = dataToObjM(tam);
                    if (x != null) {
                        movies.put(x.getMovieId(), x);
                    }
                }
            }
            System.out.println("Doc file thanh cong");
        } catch (IOException e) {
        }

    }

    public Movie dataToObjM(String tam) {
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

    //Purchased Movie
    public void saveToFilePM(HashMap<String, Movie> Purmovies) {
        try {
            File f = new File("./purchased_movie.csv");
            try ( FileWriter fw = new FileWriter(f);  BufferedWriter bw = new BufferedWriter(fw)) {
                for (Movie mv : Purmovies.values()) {
                    bw.write(mv.toString());
                    bw.newLine();
                }
            }
            System.out.println("Ghi file thanh cong");
        } catch (IOException e) {
            System.out.println("Loi");
        }
    }

    public void readFromFilePM(HashMap<String, Movie> Purmovies) {
        try {
            File f = new File("./purchased_movie.csv");
            if (!f.exists()) {
                return;
            }
            try ( FileReader fr = new FileReader(f);  BufferedReader br = new BufferedReader(fr)) {
                String tam;
                while ((tam = br.readLine()) != null) {
                    Movie x = dataToObjPM(tam);
                    if (x != null) {
                        Purmovies.put(x.getMovieId(), x);
                    }
                }
            }
            System.out.println("Doc file thanh cong");
        } catch (IOException e) {
        }

    }

    public Movie dataToObjPM(String tam) {
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

    //User
    public void saveToFileU(HashMap<String, User> users) {
        try {
            File f = new File("./user.csv");
            try ( FileWriter fw = new FileWriter(f);  BufferedWriter bw = new BufferedWriter(fw)) {
                for (User us : users.values()) {
                    bw.write(us.toString());
                    bw.newLine();
                }
            }
            System.out.println("Ghi file thanh cong");
        } catch (IOException e) {
            System.out.println("Loi");
        }
    }

    public void readFromFileU(HashMap<String, User> users) {
        try {
            File f = new File("./user.csv");
            if (!f.exists()) {
                return;
            }
            try ( FileReader fr = new FileReader(f);  BufferedReader br = new BufferedReader(fr)) {
                String tam;
                while ((tam = br.readLine()) != null) {
                    User x = dataToObjU(tam);
                    if (x != null) {
                        users.put(x.getMemberId(), x);
                    }
                }
            }
            System.out.println("Doc file thanh cong");
        } catch (IOException e) {
        }

    }

    public User dataToObjU(String tam) {
        try {
            String[] temp = tam.split(",");
            if (temp.length >= 5) {
                String memberId = temp[0].trim();
                String name = temp[1].trim();
                String password = temp[2].trim();
                int mainCoin = Integer.parseInt(temp[3].trim());
                int bonusCoin = Integer.parseInt(temp[4].trim());
                Wallet wallet = new Wallet(mainCoin, bonusCoin);
                return new User(memberId, name, password, wallet);
            }
        } catch (NumberFormatException e) {
            System.out.println("Lỗi parse data user: " + tam);
        }
        return null;
    }

    //Lich su giao dich
    public void saveToFileTH(HashMap<String, Transaction> tr) {
        try {
            File f = new File("./transaction_his.csv");
            try ( FileWriter fw = new FileWriter(f);  BufferedWriter bw = new BufferedWriter(fw)) {
                for (Transaction t : tr.values()) {
                    bw.write(t.toString());
                    bw.newLine();
                }
            }
            System.out.println("Ghi file thanh cong");
        } catch (IOException e) {
            System.out.println("Loi");
        }
    }

    public void readFromFileTH(HashMap<String, Transaction> tr) {
        try {
            File f = new File("./transaction_his.csv");
            if (!f.exists()) {
                return;
            }
            try ( FileReader fr = new FileReader(f);  BufferedReader br = new BufferedReader(fr)) {
                String tam;
                while ((tam = br.readLine()) != null) {
                    Transaction x = dataToObjTH(tam);
                    if (x != null) {
                        tr.put(x.getTransId(), x);
                    }
                }
            }
            System.out.println("Doc file thanh cong");
        } catch (IOException e) {
        }

    }

    public Transaction dataToObjTH(String tam) {
        try {
            String[] temp = tam.split(",");

            if (temp.length >= 5) {
                String transId = temp[0];
                String transType = temp[1];
                int amount = Integer.parseInt(temp[2]);
                LocalDate date = LocalDate.parse(temp[3]);

                return new Transaction(transId, transType, amount, date);
            }
        } catch (NumberFormatException e) {
            System.out.println("Loi");
        }
        return null;
    }
}
