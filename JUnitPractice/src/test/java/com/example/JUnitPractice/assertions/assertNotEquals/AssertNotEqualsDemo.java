package com.example.JUnitPractice.assertions.assertNotEquals;

import com.example.JUnitPractice.model.Book;
import com.example.JUnitPractice.service.BookService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AssertNotEqualsDemo {


    @Test
    void assertNotEqualsWithNoMessage(){
        BookService bookService = new BookService();

        Book headFirstJava = new Book("1","Head First Java","Oreilly");
        Book headFirstDesignPatterns = new Book("2","Head First Design Pattern","Oreilly2");

        bookService.addBook(headFirstJava);
        bookService.addBook(headFirstDesignPatterns);

        Book actualBook = bookService.getBookById("1");

        assertNotEquals("11",actualBook.getBookId());
        assertNotEquals("Head First Java1", actualBook.getTitle());
    }


    @Test
    void assertNotEqualsWithMessage(){
        BookService bookService = new BookService();

        Book headFirstJava = new Book("1","Head First Java","Oreilly");
        Book headFirstDesignPatterns = new Book("2","Head First Design Pattern","Oreilly2");

        bookService.addBook(headFirstJava);
        bookService.addBook(headFirstDesignPatterns);

        Book actualBook = bookService.getBookById("1");

        //assertNotEquals("1",actualBook.getBookId());
        assertNotEquals("Head First Java1", actualBook.getTitle(),"Books titles matched");
    }


    @Test
    void assertEqualsWithMessageSupplier(){

        BookService bookService = new BookService();

        Book headFirstJava = new Book("1","Head First Java","Oreilly");
        Book headFirstDesignPatterns = new Book("2","Head First Design Pattern","Oreilly2");

        bookService.addBook(headFirstJava);
        bookService.addBook(headFirstDesignPatterns);

        Book actualBook = bookService.getBookById("1");

        //assertNotEquals("1",actualBook.getBookId());
        assertNotEquals("Head First Java1", actualBook.getTitle(),()->"Books titles match matched");

    }

}