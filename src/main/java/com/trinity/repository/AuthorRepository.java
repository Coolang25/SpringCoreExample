package com.trinity.repository;

import com.trinity.entity.Author;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class AuthorRepository {

    private List<Author> authors = new ArrayList<>();
    public List<Author> getAll() {
        return this.authors;
    }
    public void create(Author entity) {
        if (this.authors.contains(entity)) {
            System.out.println("Author is existed");
        } else {
            this.authors.add(entity);
            System.out.println("Add author successfully");
        }
    }

}
