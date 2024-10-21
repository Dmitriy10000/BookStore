package com.bookstore.BookStore.Repos;

import com.bookstore.BookStore.domain.Basket;
import org.springframework.data.repository.CrudRepository;

public interface BasketRepo extends CrudRepository<Basket, Long> {
}
