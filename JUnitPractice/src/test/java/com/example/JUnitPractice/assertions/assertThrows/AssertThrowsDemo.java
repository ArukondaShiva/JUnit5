package com.example.JUnitPractice.assertions.assertThrows;

import com.example.JUnitPractice.exception.BookNotFoundException;
import com.example.JUnitPractice.model.Book;
import com.example.JUnitPractice.service.BookService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AssertThrowsDemo {

    @Test
    void assertThrowsWithNoMessage(){
        BookService bookService = new BookService();

        Book headFirstJava = new Book("1","Head First Java","Oreilly");
        Book headFirstDesignPatterns = new Book("2","Head First Design Pattern","Oreilly2");

        bookService.addBook(headFirstJava);
        bookService.addBook(headFirstDesignPatterns);

        /*
        assertThrows(BookNotFoundException.class, ()->{
            bookService.getBookByTitle("Head First Spring");
        });

         */

        // AssertThrows throws a return type of exception which we provided as excepted exception.
        BookNotFoundException bookNotFoundException = assertThrows(BookNotFoundException.class, ()->{
            bookService.getBookByTitle("Head First Spring");
        });

        // we can provide assert on the exception which was thrown by assertThrows
        assertEquals("Book not found in Bookstore!",bookNotFoundException.getMessage());
    }


    @Test
    void assertThrowsWithMessage(){
        BookService bookService = new BookService();

        Book headFirstJava = new Book("1","Head First Java","Oreilly");
        Book headFirstDesignPatterns = new Book("2","Head First Design Pattern","Oreilly2");

        bookService.addBook(headFirstJava);
        bookService.addBook(headFirstDesignPatterns);

        //NullPointerException

        assertThrows(BookNotFoundException.class, ()->{
            bookService.getBookByTitle("Head First Spring");
        },"Different Exception Thrown");
    }


    @Test
    void assertThrowsWithMessageSupplier(){

        BookService bookService = new BookService();

        Book headFirstJava = new Book("1","Head First Java","Oreilly");
        Book headFirstDesignPatterns = new Book("2","Head First Design Pattern","Oreilly2");

        bookService.addBook(headFirstJava);
        bookService.addBook(headFirstDesignPatterns);

        //NullPointerException

        assertThrows(BookNotFoundException.class, ()->{
            bookService.getBookByTitle("Head First Spring");
        },()->"Different Exception Thrown");
    }

}
