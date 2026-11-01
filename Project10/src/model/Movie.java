/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.HashMap;

/**
 *
 * @author Nguyen Kim Thuy Duon
 */
public class Movie {

    private String movieId;
    private String title;
    private String genre;
    private int moviePrice;
    private boolean isFree;
    private int duration;
    private String producer;

    public Movie() {
    }

    public Movie(String movieId, String title, String genre, int moviePrice, boolean isFree, int duration, String producer) {
        this.movieId = movieId;
        this.title = title;
        this.genre = genre;
        this.moviePrice = moviePrice;
        this.isFree = isFree;
        this.duration = duration;
        this.producer = producer;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getMoviePrice() {
        return moviePrice;
    }

    public void setMoviePrice(int moviePrice) {
        this.moviePrice = moviePrice;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setIsFree(boolean isFree) {
        this.isFree = isFree;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void showMovie() {
        String priceText = isFree ? "Miễn phí" : moviePrice + " Coins";
        System.out.printf("| %-8s | %-20s | %-12s | %-10s | %-4d phút | %-15s |\n",
                movieId, title, genre, priceText, duration, producer);
    }

    public static void sortMvPriceAsc(HashMap<String, Movie> movies) {
        ArrayList<Movie> list = new ArrayList<>(movies.values());

        list.sort(Comparator.comparingInt(Movie::getMoviePrice));

        for (Movie movie : list) {
            movie.showMovie();
        }
    }
    // Gia giam dan
    public static void sortMvPriceDesc(HashMap<String, Movie> movies) {
        ArrayList<Movie> list = new ArrayList<>(movies.values());

        list.sort(Comparator.comparingInt(Movie::getMoviePrice).reversed());

        for (Movie movie : list) {
            movie.showMovie();
        }
    }

    // Thoi luong tang dan
    public static void sortMvDurationAsc(HashMap<String, Movie> movies) {
        ArrayList<Movie> list = new ArrayList<>(movies.values());

        list.sort(Comparator.comparingInt(Movie::getDuration));

        for (Movie movie : list) {
            movie.showMovie();
        }
    }

    // Thoi luong giam dan
    public static void sortMvDurationDesc(HashMap<String, Movie> movies) {
        ArrayList<Movie> list = new ArrayList<>(movies.values());

        list.sort(Comparator.comparingInt(Movie::getDuration).reversed());

        for (Movie movie : list) {
            movie.showMovie();
        }
    }

    @Override
    public String toString() {
        return movieId + "," + title + "," + genre + "," + moviePrice + "," + isFree + "," + duration + "," + producer;
    }

}
