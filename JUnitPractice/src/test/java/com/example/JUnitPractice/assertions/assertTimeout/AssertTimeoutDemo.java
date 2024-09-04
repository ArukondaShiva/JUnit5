package com.example.JUnitPractice.assertions.assertTimeout;

import com.example.JUnitPractice.model.Book;
import com.example.JUnitPractice.service.BookService;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

public class AssertTimeoutDemo {

    @Test
    void assertTimeoutWithNoMessage(){
        BookService bookService = new BookService();

        for(int i=1;i<=1000;i++){
            bookService.addBook(new Book(String.valueOf(i),"Head First Java","Oreilly"));
        }

        List<String> actualTitles = new ArrayList<>();

        assertTimeout(Duration.ofMillis(1),()->{
            actualTitles.addAll(bookService.getBookTitlesByPublisher("Oreilly"));
        });

        assertEquals(1000,actualTitles.size());
    }


    @Test
    void assertTimeoutWithMessage(){
        BookService bookService = new BookService();

        for(int i=1;i<=1000;i++){
            bookService.addBook(new Book(String.valueOf(i),"Head First Java","Oreilly"));
        }

        List<String> actualTitles = new ArrayList<>();

        assertTimeout(Duration.ofMillis(1),()->{
            actualTitles.addAll(bookService.getBookTitlesByPublisher("Oreilly"));
        },"Performance issues with getBookTitlesByPublisher() method");

        assertEquals(1000,actualTitles.size());
    }


    @Test
    void assertTimeoutWithMessageSupplier(){
        BookService bookService = new BookService();

        for(int i=1;i<=1000;i++){
            bookService.addBook(new Book(String.valueOf(i),"Head First Java","Oreilly"));
        }

        List<String> actualTitles = new ArrayList<>();

        assertTimeout(Duration.ofMillis(1),()->{
            actualTitles.addAll(bookService.getBookTitlesByPublisher("Oreilly"));
        },()->"Performance issues with getBookTitlesByPublisher() method");

        assertEquals(1000,actualTitles.size());
    }


}
