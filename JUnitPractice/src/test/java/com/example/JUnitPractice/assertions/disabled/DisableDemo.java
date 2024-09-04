package com.example.JUnitPractice.assertions.disabled;

import com.example.JUnitPractice.model.Book;
import com.example.JUnitPractice.service.BookService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DisableDemo {

    @Test
    @Disabled("skipped until issue #22 has been fixed")
    void assertEqualsWithNoMessage(){
        BookService bookService = new BookService();

        Book headFirstJava = new Book("1","Head First Java","Oreilly");
        Book headFirstDesignPatterns = new Book("2","Head First Design Pattern","Oreilly2");

        bookService.addBook(headFirstJava);
        bookService.addBook(headFirstDesignPatterns);

        Book actualBook = bookService.getBookById("1");

        assertEquals("1",actualBook.getBookId());
        assertEquals("Head First Java", actualBook.getTitle());
    }


    @Test
    void assertEqualsWithMessage(){
        BookService bookService = new BookService();

        Book headFirstJava = new Book("1","Head First Java","Oreilly");
        Book headFirstDesignPatterns = new Book("2","Head First Design Pattern","Oreilly2");

        bookService.addBook(headFirstJava);
        bookService.addBook(headFirstDesignPatterns);

        Book actualBook = bookService.getBookById("1");

        assertEquals("1",actualBook.getBookId());
        assertEquals("Head First Java", actualBook.getTitle(),"Book title didn't match");
    }


    @Test
    void assertEqualsWithMessageSupplier(){

        BookService bookService = new BookService();

        Book headFirstJava = new Book("1","Head First Java","Oreilly");
        Book headFirstDesignPatterns = new Book("2","Head First Design Pattern","Oreilly2");

        bookService.addBook(headFirstJava);
        bookService.addBook(headFirstDesignPatterns);

        Book actualBook = bookService.getBookById("1");

        assertEquals("1",actualBook.getBookId());
        assertEquals("Head First Java", actualBook.getTitle(),()->"Book title didn't match");

    }

}
