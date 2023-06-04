package com.example.kursach.model;

public class Book implements BookI{
    String author;
    String title;
    String keyWords;
    String id;
    String genre;
    String imgPath;
    String description;

    public Book(String id, String title, String author, String keyWords, String genre, String imgPath, String description) {
        this.title = title;
        this.author = author;
        this.keyWords = keyWords;
        this.id = id;
        this.genre = genre;
        this.imgPath = imgPath;
        this.description = description;
    }

    public String getId(){return id;}
    public String getGenre() {
        return genre;
    }
    public String getAuthor() {
        return author;
    }
    public String getTitle() {
        return title;
    }
    public String getKeyWords() {
        return keyWords;
    }
    public String getDescription() {
        return description;
    }
    public String getImgPath(){
        return imgPath;
    }

}
