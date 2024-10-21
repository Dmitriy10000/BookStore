package com.bookstore.BookStore.domain;

import javax.persistence.*;

@Entity
public class Basket {
    @Id
    private Long id;
    private int count;

    public Basket() {
    }

    public Basket(Long id, int count) {
        this.id = id;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
