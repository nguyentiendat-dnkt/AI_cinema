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
public class Member {
    private String memberId;
    private String name;
    private String password;
    

    public Member() {
    }

    public Member(String memberId, String name, String password) {
        this.memberId = memberId;
        this.name = name;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void showMovieList(HashMap<String, Movie> movies) {
        if (movies.isEmpty()) {
            System.out.println("Kho phim hien dang rong!");
        }else {
            for (Movie movie : movies.values()) {
                movie.showMovie();
            }
        }
    }
}
