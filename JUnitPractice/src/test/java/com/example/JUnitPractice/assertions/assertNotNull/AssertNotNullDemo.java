package com.example.JUnitPractice.assertions.assertNotNull;

import com.example.JUnitPractice.model.Book;
import com.example.JUnitPractice.service.BookService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AssertNotNullDemo {


    @Test
    void assertNotNullWithNoMessage(){
        BookService bookService = new BookService();

        Book headFirstJava = new Book("1","Head First Java","Oreilly");
        Book headFirstDesignPatterns = new Book("2","Head First Design Pattern","Oreilly2");

        bookService.addBook(headFirstJava);
        bookService.addBook(headFirstDesignPatterns);

        Book actualBook = bookService.getBookById("2");
        assertNotNull(actualBook);
    }


    @Test
    void assertNotNullWithMessage(){
        BookService bookService = new BookService();

        Book headFirstJava = new Book("1","Head First Java","Oreilly");
        Book headFirstDesignPatterns = new Book("2","Head First Design Pattern","Oreilly2");

        bookService.addBook(headFirstJava);
        bookService.addBook(headFirstDesignPatterns);

        Book actualBook = bookService.getBookById("2");
        assertNotNull(actualBook,"Book is not null");
    }


    @Test
    void assertNotNullWithMessageSupplier(){

        BookService bookService = new BookService();

        Book headFirstJava = new Book("1","Head First Java","Oreilly");
        Book headFirstDesignPatterns = new Book("2","Head First Design Pattern","Oreilly2");

        bookService.addBook(headFirstJava);
        bookService.addBook(headFirstDesignPatterns);

        Book actualBook = bookService.getBookById("1");

        assertNotNull(actualBook,()->"Book is not null");
    }



}
