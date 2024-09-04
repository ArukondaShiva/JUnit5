package com.example.JUnitPractice.assertions.assertIterableEquals;

import com.example.JUnitPractice.model.Book;
import com.example.JUnitPractice.service.BookService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class AssertIterableEqualsDemo {

    @Test
    void assertIterableEqualsWithNoMessage(){
        BookService bookService = new BookService();

        Book headFirstJava = new Book("1","Head First Java","Oreilly");
        Book headFirstDesignPatterns = new Book("2","Head First Design Pattern","Oreilly2");
        Book headFirstJavascript = new Book("3","Head First Javascript","Oreilly");

        bookService.addBook(headFirstJava);
        bookService.addBook(headFirstDesignPatterns);
        bookService.addBook(headFirstJavascript);

        List<String> actualTitles = bookService.getBookTitlesByPublisher("Oreilly");
        List<String> expectedTitles = new ArrayList<>();

        expectedTitles.add("Head First Java");
        expectedTitles.add("Head First Javascript");

        assertIterableEquals(expectedTitles,actualTitles);
    }


    @Test
    void assertIterableEqualsWithMessage(){
        BookService bookService = new BookService();

        Book headFirstJava = new Book("1","Head First Java","Oreilly");
        Book headFirstDesignPatterns = new Book("2","Head First Design Pattern","Oreilly2");
        Book headFirstJavascript = new Book("3","Head First Javascript","Oreilly");

        bookService.addBook(headFirstJava);
        bookService.addBook(headFirstDesignPatterns);
        bookService.addBook(headFirstJavascript);

        List<String> actualTitles = bookService.getBookTitlesByPublisher("Oreilly");
        List<String> expectedTitles = new ArrayList<>();

        expectedTitles.add("Head First Java");
        expectedTitles.add("Head First Javascript");

        assertIterableEquals(expectedTitles,actualTitles,"Book titles didn't match");
    }


    @Test
    void assertIterableEqualsWithMessageSupplier(){
        BookService bookService = new BookService();

        Book headFirstJava = new Book("1","Head First Java","Oreilly");
        Book headFirstDesignPatterns = new Book("2","Head First Design Pattern","Oreilly2");
        Book headFirstJavascript = new Book("3","Head First Javascript","Oreilly");

        bookService.addBook(headFirstJava);
        bookService.addBook(headFirstDesignPatterns);
        bookService.addBook(headFirstJavascript);

        List<String> actualTitles = bookService.getBookTitlesByPublisher("Oreilly");
        List<String> expectedTitles = new ArrayList<>();

        expectedTitles.add("Head First Java");
        expectedTitles.add("Head First Javascript");

        assertIterableEquals(expectedTitles,actualTitles,()->"Book titles didn't match");
    }

}