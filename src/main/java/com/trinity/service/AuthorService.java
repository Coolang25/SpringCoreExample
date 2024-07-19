package com.trinity.service;

import com.trinity.entity.Author;
import com.trinity.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

@Service
public class AuthorService{
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void createAuthor() {
        Author author = input();
        authorRepository.create(author);
    }

    public List<Author> getAll() {
        return authorRepository.getAll();
    }


    private Author input() {
        Scanner sc = new Scanner(System.in);
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
        return new Author(fullName, dob, address);
    }
}
