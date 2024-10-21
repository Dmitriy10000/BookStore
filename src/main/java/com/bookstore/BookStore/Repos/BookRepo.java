package com.bookstore.BookStore.Repos;

import com.bookstore.BookStore.domain.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepo extends CrudRepository<Book, Long> {
    // Получаем кол-во книг в БД
    long count();
    // Список книг по названию
    @Query("select distinct b from Book b order by b.name")
    List<Book> findDistinctByOrderByNameAsc(Pageable pageable);
    // desc
    @Query("select distinct b from Book b order by b.name desc")
    List<Book> findDistinctByOrderByNameDesc(Pageable pageable);

    // Список книг по рейтингу
    @Query("select distinct b from Book b order by b.rating")
    List<Book> findDistinctByOrderByRatingAsc(Pageable pageable);
    // desc
    @Query("select distinct b from Book b order by b.rating desc")
    List<Book> findDistinctByOrderByRatingDesc(Pageable pageable);

    // Список книг по цене
    @Query("select distinct b from Book b order by b.price")
    List<Book> findDistinctByOrderByPriceAsc(Pageable pageable);
    // desc
    @Query("select distinct b from Book b order by b.price desc")
    List<Book> findDistinctByOrderByPriceDesc(Pageable pageable);

    // Поиск книги по названию сортировка по названию
    @Query("select distinct b from Book b where b.name like %?1% order by b.name")
    List<Book> findDistinctByNameContainingOrderByNameAsc(String name, Pageable pageable);
    // desc
    @Query("select distinct b from Book b where b.name like %?1% order by b.name desc")
    List<Book> findDistinctByNameContainingOrderByNameDesc(String name, Pageable pageable);

    // Поиск книги по названию сортировка по рейтингу
    @Query("select distinct b from Book b where b.name like %?1% order by b.rating")
    List<Book> findDistinctByNameContainingOrderByRatingAsc(String name, Pageable pageable);
    // desc
    @Query("select distinct b from Book b where b.name like %?1% order by b.rating desc")
    List<Book> findDistinctByNameContainingOrderByRatingDesc(String name, Pageable pageable);

    // Поиск книги по названию сортировка по цене
    @Query("select distinct b from Book b where b.name like %?1% order by b.price")
    List<Book> findDistinctByNameContainingOrderByPriceAsc(String name, Pageable pageable);
    // desc
    @Query("select distinct b from Book b where b.name like %?1% order by b.price desc")
    List<Book> findDistinctByNameContainingOrderByPriceDesc(String name, Pageable pageable);
}
