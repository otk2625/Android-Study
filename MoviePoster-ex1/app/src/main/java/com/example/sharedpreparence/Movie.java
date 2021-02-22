package com.example.sharedpreparence;

public class Movie {
    private Integer id;
    private Integer Image;

    public Movie(Integer id, Integer image) {
        this.id = id;
        Image = image;
    }

    public Integer getId() {
        return id;
    }

    public Integer getImage() {
        return Image;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setImage(Integer image) {
        Image = image;
    }
}
