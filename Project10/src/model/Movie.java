/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

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
    private LocalDate releaseDate;
    private int duration;
    private String producer;

    public Movie() {
    }

    public Movie(String movieId, String title, String genre, int moviePrice, boolean isFree, LocalDate releaseDate, int duration, String producer) {
        this.movieId = movieId;
        this.title = title;
        this.genre = genre;
        this.moviePrice = moviePrice;
        this.isFree = isFree;
        this.releaseDate = releaseDate;
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

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
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
        System.out.printf("| %-8s | %-20s | %-12s | %-10s | %-10s | %-4d phút | %-15s |\n",
                movieId, title, genre, priceText, releaseDate, duration, producer);
    }
    
   @Override
    public String toString() {
        return "Movie{" +
                "movieId='" + movieId + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", moviePrice=" + (isFree ? 0 : moviePrice) +
                ", isFree=" + isFree +
                ", releaseDate=" + releaseDate +
                ", duration=" + duration + " mins" +
                ", producer='" + producer + '\'' +
                '}';
    }
}
