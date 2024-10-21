package com.bookstore.BookStore.domain;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private String author;
    private String description;
    private double price;       // цена в долларах
    private String imageUrl;
    private Long rating;        // 1-10

    public Book() {
    }

    public Book(Long id, String name, String author, String description, double price, String imageUrl, Long rating) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }
}
