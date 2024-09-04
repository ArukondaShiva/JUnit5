package com.example.JUnitPractice.assertions.assertTimeoutPreemptively;

import com.example.JUnitPractice.model.Book;
import com.example.JUnitPractice.service.BookService;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AssertTimeoutPreemptivelyDemo {

    @Test
    void assertTimeoutWithNoMessage(){
        BookService bookService = new BookService();

        for(int i=1;i<=1000;i++){
            bookService.addBook(new Book(String.valueOf(i),"Head First Java","Oreilly"));
        }

        List<String> actualTitles = new ArrayList<>();

        assertTimeoutPreemptively(Duration.ofMillis(1),()->{
            actualTitles.addAll(bookService.getBookTitlesByPublisher("Oreilly"));
        });

        assertEquals(1000,actualTitles.size());
    }


    @Test
    void assertTimeoutPreemptivelyWithMessage(){
        BookService bookService = new BookService();

        for(int i=1;i<=1000;i++){
            bookService.addBook(new Book(String.valueOf(i),"Head First Java","Oreilly"));
        }

        List<String> actualTitles = new ArrayList<>();

        assertTimeoutPreemptively(Duration.ofMillis(1),()->{
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

        assertTimeoutPreemptively(Duration.ofMillis(1),()->{
            actualTitles.addAll(bookService.getBookTitlesByPublisher("Oreilly"));
        },()->"Performance issues with getBookTitlesByPublisher() method");

        assertEquals(1000,actualTitles.size());
    }



}
