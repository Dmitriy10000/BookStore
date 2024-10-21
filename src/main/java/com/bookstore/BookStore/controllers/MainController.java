package com.bookstore.BookStore.controllers;

import com.bookstore.BookStore.Repos.*;
import com.bookstore.BookStore.domain.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class MainController {

    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private BasketRepo basketRepo;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("title", "Home page");
        return "home";
    }

    @GetMapping("/book")
    public String getBook(
            @RequestParam(name="page", required=false, defaultValue="1") long page,
            @RequestParam(name="sortedBy", required=false, defaultValue="name") String sortedBy,
            @RequestParam(name="order", required=false, defaultValue="asc") String order,
            @RequestParam(name="contains", required=false, defaultValue="") String contains,
            Map<String, Object> model
    ) {
        Iterable<Book> books = null;
        int booksPerPage = 15;
        // Получаем количество страниц
        long totalPages = bookRepo.count() / booksPerPage + 1;
//        System.out.println("BookCount: " + bookRepo.count());
//        System.out.println("TotalPages: " + totalPages);
        if (page > totalPages) {
            page = totalPages;
        }
        if (page < 1) {
            page = 1;
        }
        Search search = new Search(page, sortedBy, order, contains, totalPages);

        // Сортировка
        Pageable pageable = PageRequest.of((int) page - 1, booksPerPage);
        if (contains.equals("")) {
            switch (sortedBy) {
                case "name" -> {
                    if (order.equals("desc")) {
                        books = bookRepo.findDistinctByOrderByNameDesc(pageable);
                    }
                    else {
                        books = bookRepo.findDistinctByOrderByNameAsc(pageable);
                    }
                }
                case "price" -> {
                    if (order.equals("desc")) {
                        books = bookRepo.findDistinctByOrderByPriceDesc(pageable);
                    }
                    else {
                        books = bookRepo.findDistinctByOrderByPriceAsc(pageable);
                    }
                }
                case "rating" -> {
                    if (order.equals("desc")) {
                        books = bookRepo.findDistinctByOrderByRatingDesc(pageable);
                    }
                    else {
                        books = bookRepo.findDistinctByOrderByRatingAsc(pageable);
                    }
                }
            }
        }
        else {
            switch (sortedBy) {
                case "name" -> {
                    if (order.equals("desc")) {
                        books = bookRepo.findDistinctByNameContainingOrderByNameDesc(contains, pageable);
                    }
                    else {
                        books = bookRepo.findDistinctByNameContainingOrderByNameAsc(contains, pageable);
                    }
                }
                case "price" -> {
                    if (order.equals("desc")) {
                        books = bookRepo.findDistinctByNameContainingOrderByPriceDesc(contains, pageable);
                    }
                    else {
                        books = bookRepo.findDistinctByNameContainingOrderByPriceAsc(contains, pageable);
                    }
                }
                case "rating" -> {
                    if (order.equals("desc")) {
                        books = bookRepo.findDistinctByNameContainingOrderByRatingDesc(contains, pageable);
                    }
                    else {
                        books = bookRepo.findDistinctByNameContainingOrderByRatingAsc(contains, pageable);
                    }
                }
            }
        }
//        System.out.println("page: " + page);
//        System.out.println("sortedBy: " + sortedBy);
//        System.out.println("order: " + order);
//        System.out.println("contains: " + contains);
//        System.out.println("books: " + books);

        // Передаем в модель
        model.put("books", books);
        model.put("search", search);
        model.put("title", "Books");
        return "book-main";
    }


    @GetMapping("/test")
    public String getTest(
            @RequestParam(name="page", required=false, defaultValue="1") long page,
            @RequestParam(name="sortedBy", required=false, defaultValue="name") String sortedBy,
            @RequestParam(name="order", required=false, defaultValue="asc") String order,
            @RequestParam(name="contains", required=false, defaultValue="") String contains,
            Map<String, Object> model
    ) {
        Iterable<Book> books = null;
        int booksPerPage = 15;
        // Получаем количество страниц
        long totalPages = bookRepo.count() / booksPerPage + 1;
//        System.out.println("BookCount: " + bookRepo.count());
//        System.out.println("TotalPages: " + totalPages);
        if (page > totalPages) {
            page = totalPages;
        }
        if (page < 1) {
            page = 1;
        }
        Search search = new Search(page, sortedBy, order, contains, totalPages);

        // Сортировка
        Pageable pageable = PageRequest.of((int) page - 1, booksPerPage);
        if (contains.equals("")) {
            switch (sortedBy) {
                case "name" -> {
                    if (order.equals("desc")) {
                        books = bookRepo.findDistinctByOrderByNameDesc(pageable);
                    }
                    else {
                        books = bookRepo.findDistinctByOrderByNameAsc(pageable);
                    }
                }
                case "price" -> {
                    if (order.equals("desc")) {
                        books = bookRepo.findDistinctByOrderByPriceDesc(pageable);
                    }
                    else {
                        books = bookRepo.findDistinctByOrderByPriceAsc(pageable);
                    }
                }
                case "rating" -> {
                    if (order.equals("desc")) {
                        books = bookRepo.findDistinctByOrderByRatingDesc(pageable);
                    }
                    else {
                        books = bookRepo.findDistinctByOrderByRatingAsc(pageable);
                    }
                }
            }
        }
        else {
            switch (sortedBy) {
                case "name" -> {
                    if (order.equals("desc")) {
                        books = bookRepo.findDistinctByNameContainingOrderByNameDesc(contains, pageable);
                    }
                    else {
                        books = bookRepo.findDistinctByNameContainingOrderByNameAsc(contains, pageable);
                    }
                }
                case "price" -> {
                    if (order.equals("desc")) {
                        books = bookRepo.findDistinctByNameContainingOrderByPriceDesc(contains, pageable);
                    }
                    else {
                        books = bookRepo.findDistinctByNameContainingOrderByPriceAsc(contains, pageable);
                    }
                }
                case "rating" -> {
                    if (order.equals("desc")) {
                        books = bookRepo.findDistinctByNameContainingOrderByRatingDesc(contains, pageable);
                    }
                    else {
                        books = bookRepo.findDistinctByNameContainingOrderByRatingAsc(contains, pageable);
                    }
                }
            }
        }
//        System.out.println("page: " + page);
//        System.out.println("sortedBy: " + sortedBy);
//        System.out.println("order: " + order);
//        System.out.println("contains: " + contains);
//        System.out.println("books: " + books);

        // Передаем в модель
        model.put("books", books);
        model.put("search", search);
        model.put("title", "Test page");
        return "test";
    }

    @GetMapping("/item")
    public String getItem(
            @RequestParam(name="id", required=false, defaultValue="0") Long id,
            Map<String, Object> model
    ) {
        Book book = bookRepo.findById(id).orElse(null);
        if (book == null) {
//            return "error404";
            return "redirect:/";
        }
        else {
            // Заполняем массив звезд
            int[] stars = new int[5];
            Arrays.fill(stars, 0);
            for (int i = 0; i < 5; i++) {
                if (book.getRating() == i * 2 + 1) {
                    stars[i] = 1;
                }
                else if (book.getRating() > i * 2) {
                    stars[i] = 2;
                }
            }

            // Передаем в модель
            model.put("stars", stars);
            model.put("book", book);
            model.put("title", book.getName());
            return "item";
        }
    }

    @PostMapping("/item")
    public String postItem(
            @RequestParam(name="id") Long id,
            Map<String, Object> model
    ) {
        if (id != null) {
            Iterable<Basket> items = basketRepo.findAll();
            List<Basket> itemsList = (List<Basket>) items;
            // Проверяем, есть ли уже такая книга в корзине
            for (Basket item : itemsList) {
                if (item.getId().equals(id)) {
                    item.setCount(item.getCount() + 1);
                    basketRepo.save(item);
                    return "redirect:/item?id=" + id;
                }
            }
            // Если нет, то добавляем
            Basket item = new Basket(id, 1);
            basketRepo.save(item);
        }
        return "redirect:/item?id=" + id;
    }

    @PostMapping("/book")
    public String postBook(
            @RequestParam(name="id") Long id,
            Map<String, Object> model
    ) {
        if (id != null) {
            Iterable<Basket> items = basketRepo.findAll();
            List<Basket> itemsList = (List<Basket>) items;
            // Проверяем, есть ли уже такая книга в корзине
            for (Basket item : itemsList) {
                if (item.getId().equals(id)) {
                    item.setCount(item.getCount() + 1);
                    basketRepo.save(item);
                    return "redirect:/book";
                }
            }
            // Если нет, то добавляем
            Basket item = new Basket(id, 1);
            basketRepo.save(item);
        }
        return "redirect:/book";
    }

    @GetMapping("/basket")
    public String getBasket(
            Map<String, Object> model
    ) {
        Iterable<Basket> items = basketRepo.findAll();
        List<Basket> itemsList = (List<Basket>) items;
        List<Book> booksList = new ArrayList<>();
        double total = 0;
        for (Basket item : itemsList) {
            booksList.add(bookRepo.findById(item.getId()).orElse(null));
            total += Objects.requireNonNull(bookRepo.findById(item.getId()).orElse(null)).getPrice() * item.getCount();
        }

        // Сортируем по алфавиту
        for (int i = 0; i < booksList.size(); i++) {
            for (int j = 0; j < booksList.size() - 1; j++) {
                if (booksList.get(j).getName().compareTo(booksList.get(j + 1).getName()) > 0) {
                    Book temp = booksList.get(j);
                    booksList.set(j, booksList.get(j + 1));
                    booksList.set(j + 1, temp);
                    Basket temp2 = itemsList.get(j);
                    itemsList.set(j, itemsList.get(j + 1));
                    itemsList.set(j + 1, temp2);
                }
            }
        }
        model.put("books", booksList);
        model.put("items", itemsList);
        model.put("total", total);
        model.put("title", "Basket");
        return "basket";
    }

    @PostMapping("/basket")
    public String postBasket(
            @RequestParam(name="action") String action,
            @RequestParam(name="id", required=false, defaultValue="") Long id,
            Map<String, Object> model
    ) {
        System.out.println(action);
        System.out.println(id);
        switch (action) {
            case "delete" -> basketRepo.deleteById(id);
            case "add" -> {
                Basket item = basketRepo.findById(id).orElse(null);
                if (item != null) {
                    item.setCount(item.getCount() + 1);
                    basketRepo.save(item);
                }
            }
            case "remove" -> {
                Basket item = basketRepo.findById(id).orElse(null);
                if (item != null) {
                    if (item.getCount() > 1) {
                        item.setCount(item.getCount() - 1);
                        basketRepo.save(item);
                    }
                    else {
                        basketRepo.deleteById(id);
                    }
                }
            }
            case "clear" -> basketRepo.deleteAll();
        }
        return "redirect:/basket";
    }
}
