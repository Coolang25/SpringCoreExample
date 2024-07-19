package com.trinity.service;

import com.trinity.entity.Author;
import com.trinity.entity.Book;
import com.trinity.repository.AuthorRepository;
import com.trinity.repository.BookRepository;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;

@Component
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public void createBook() {
        Book book = input();
        authorRepository.create(book.getAuthor());
        bookRepository.create(book);
    }

    public List<Book> getAll() {
        return bookRepository.getAll();
    }

    public Set<Author> getAllAuthor() {
        Set<Author> authors = new HashSet<>();
        List<Book> books = bookRepository.getAll();
        for (Book book : books) {
            authors.add(book.getAuthor());
        }
        return authors;
    }


    private Book input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entering the book's title");
        String title = sc.nextLine();
        System.out.println("Entering the author's full name");
        String fullName = sc.nextLine();
        LocalDate dob = null;
        while (true) {
            System.out.println("Entering the author's date of birth: yyyy-MM-dddd");
            try {
                dob = LocalDate.parse(sc.nextLine());
                break;
            } catch (Exception e) {
            }
        }

        System.out.println("Entering the author's address");
        String address = sc.nextLine();
        Author author = new Author(fullName, dob, address);
        return new Book(title, author);
    }

}
