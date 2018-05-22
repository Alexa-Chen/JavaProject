package com.chenmo.photo.domain;

import java.io.Serializable;
import java.util.List;


public class User  implements Serializable{

    private int id;
    private String username;
    private String password;
    private List<Image> image;

    public User(){

    }

    public User(int id){
        this.id =id;
    }

    public User(int id, String username, String password, List<Image> image) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.image = image;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Image> getImage() {
        return image;
    }

    public void setImage(List<Image> image) {
        this.image = image;
    }
}
