package com.trinity;

import com.trinity.config.AppConfig;
import com.trinity.service.AuthorService;
import com.trinity.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AuthorService authorService = context.getBean(AuthorService.class);
        BookService bookService = context.getBean(BookService.class);
        Scanner sc = new Scanner(System.in);
        boolean repeat = true;
        while (repeat) {
            System.out.println("Select the option:");
            System.out.println("0: Exit");
            System.out.println("1: Add New Book");
            System.out.println("2: Add New Author");
            System.out.println("3: List All Books");
            System.out.println("4: List All Authors");
            String select;
            select = sc.nextLine();

            switch (select) {
                case "0":
                    repeat = false;
                    break;
                case "1":
                    bookService.createBook();
                    break;
                case "2":
                    authorService.createAuthor();
                    break;
                case "3":
                    System.out.println(bookService.getAll().toString());
                    break;
                case "4":
                    System.out.println(bookService.getAllAuthor().toString());
                    break;
                default:
                    System.out.println("Illegal");
            }

        }
    }
}