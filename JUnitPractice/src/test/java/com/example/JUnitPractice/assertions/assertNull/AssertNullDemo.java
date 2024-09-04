package com.example.JUnitPractice.assertions.assertNull;

import com.example.JUnitPractice.model.Book;
import com.example.JUnitPractice.service.BookService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class AssertNullDemo {


    @Test
    void assertNullWithNoMessage(){
        BookService bookService = new BookService();
        Book headFirstJava = new Book("1","Head First Java","Oreilly");
        Book headFirstDesignPatterns = new Book("2","Head First Design Pattern","Oreilly2");
        bookService.addBook(headFirstJava);
        bookService.addBook(headFirstDesignPatterns);

        Book actualBook = bookService.getBookById("10");
        assertNull(actualBook);
    }


    @Test
    void assertNullWithMessage(){
        BookService bookService = new BookService();

        Book headFirstJava = new Book("1","Head First Java","Oreilly");
        Book headFirstDesignPatterns = new Book("2","Head First Design Pattern","Oreilly2");

        bookService.addBook(headFirstJava);
        bookService.addBook(headFirstDesignPatterns);

        Book actualBook = bookService.getBookById("20");
        assertNull(actualBook,"Book is not null");
    }


    @Test
    void assertNullWithMessageSupplier(){

        BookService bookService = new BookService();

        Book headFirstJava = new Book("1","Head First Java","Oreilly");
        Book headFirstDesignPatterns = new Book("2","Head First Design Pattern","Oreilly2");

        bookService.addBook(headFirstJava);
        bookService.addBook(headFirstDesignPatterns);

        Book actualBook = bookService.getBookById("10");

        assertNull(actualBook,()->"Book is not null");
    }


}
