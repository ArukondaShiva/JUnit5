package com.example.JUnitPractice.assertions.assertArrayEquals;

import com.example.JUnitPractice.model.Book;
import com.example.JUnitPractice.service.BookService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssertArrayEqualsDemo {

    @Test
    void assertArraysEqualsWithNoMessage(){
        BookService bookService = new BookService();

        Book headFirstJava = new Book("1","Head First Java","Oreilly");
        Book headFirstDesignPatterns = new Book("2","Head First Design Pattern","Oreilly2");
        Book headFirstJavascript = new Book("3","Head First Javascript","Oreilly");

        bookService.addBook(headFirstJava);
        bookService.addBook(headFirstDesignPatterns);
        bookService.addBook(headFirstJavascript);

        String[] actualBookIds = bookService.getBookIdsByPublisher("Oreilly");

        // checks all elements & number of elements & order of elements in two arrays.
        assertArrayEquals(new String[]{"1","3"},actualBookIds);
    }


    @Test
    void assertArraysEqualsWithMessage(){
        BookService bookService = new BookService();

        Book headFirstJava = new Book("1","Head First Java","Oreilly");
        Book headFirstDesignPatterns = new Book("2","Head First Design Pattern","Oreilly2");
        Book headFirstJavascript = new Book("3","Head First Javascript","Oreilly");

        bookService.addBook(headFirstJava);
        bookService.addBook(headFirstDesignPatterns);
        bookService.addBook(headFirstJavascript);

        String[] actualBookIds = bookService.getBookIdsByPublisher("Oreilly");

        // checks all elements & number of elements & order of elements in two arrays.
        assertArrayEquals(new String[]{"1","3"},actualBookIds,"bookIds didn't matched");
    }


    @Test
    void assertArraysEqualsWithMessageSupplier(){
        BookService bookService = new BookService();

        Book headFirstJava = new Book("1","Head First Java","Oreilly");
        Book headFirstDesignPatterns = new Book("2","Head First Design Pattern","Oreilly2");
        Book headFirstJavascript = new Book("3","Head First Javascript","Oreilly");

        bookService.addBook(headFirstJava);
        bookService.addBook(headFirstDesignPatterns);
        bookService.addBook(headFirstJavascript);

        String[] actualBookIds = bookService.getBookIdsByPublisher("Oreilly");

        // checks all elements & number of elements & order of elements in two arrays.
        assertArrayEquals(new String[]{"1","3"},actualBookIds,()->"bookIds didn't matched");
    }



}
