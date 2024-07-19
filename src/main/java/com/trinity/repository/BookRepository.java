package com.trinity.repository;

import com.trinity.entity.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookRepository {
    private List<Book> books = new ArrayList<>();
    public List<Book> getAll() {
        return this.books;
    }
    public void create(Book entity) {
        if (this.books.contains(entity)) {
            System.out.println("Book is existed");
        } else {
            this.books.add(entity);
            System.out.println("Add author successfully");
        }
    }
}
