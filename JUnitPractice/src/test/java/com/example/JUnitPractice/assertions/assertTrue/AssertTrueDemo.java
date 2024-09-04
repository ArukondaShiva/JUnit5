package com.example.JUnitPractice.assertions.assertTrue;

import com.example.JUnitPractice.model.Book;
import com.example.JUnitPractice.service.BookService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssertTrueDemo {


    @Test
    public void assertTrueWithNoMessage(){

        BookService bookService = new BookService();

        Book headFirstJava = new Book("1","Head First Java","Oreilly");

        //bookService.addBook(headFirstJava);

        List<Book> listOfBooks = bookService.books();

        assertTrue(listOfBooks.isEmpty());
    }


    @Test
    public void assertTrueWithBooleanSupplierNoMessage(){

        BookService bookService = new BookService();

        Book headFirstJava = new Book("1","Head First Java","Oreilly");
        //bookService.addBook(headFirstJava);
        List<Book> listOfBooks = bookService.books();

        // instead of providing a boolean value, we provided a lambda expression which is nothing but a boolean supplier.
        assertTrue(()->listOfBooks.isEmpty());
    }


    @Test
    public void assertTrueWithMessage(){

        BookService bookService = new BookService();

        Book headFirstJava = new Book("1","Head First Java","Oreilly");
        // bookService.addBook(headFirstJava);
        List<Book> listOfBooks = bookService.books();


        assertTrue(listOfBooks.isEmpty(),"List of Books is not Empty");
    }


    @Test
    void assertTrueWithMessageSupplier(){

        BookService bookService = new BookService();

        Book headFirstJavaBook = new Book("1","Head First Java","Oreilly");
        //bookService.addBook(headFirstJavaBook);
        List<Book> listOfBooks = bookService.books();
        //using Supplier Interface to provide the customised message.
        //This is like a lazy evaluation.
        assertTrue(listOfBooks.isEmpty(),()->"List of books is not empty");
    }


    @Test
    public void assertTrueWithBooleanSupplierAndMessage(){

        BookService bookService = new BookService();

        Book headFirstJava = new Book("1","Head First Java","Oreilly");
        //bookService.addBook(headFirstJava);
        List<Book> listOfBooks = bookService.books();

        assertTrue(()->listOfBooks.isEmpty(),"List of books is not empty");
    }


    @Test
    public void assertTrueWithBooleanSupplierAndMessageSupplier(){

        BookService bookService = new BookService();

        Book headFirstJava = new Book("1","Head First Java","Oreilly");
        //bookService.addBook(headFirstJava);
        List<Book> listOfBooks = bookService.books();

        assertTrue(()->listOfBooks.isEmpty(),()->"List of books is not empty");
    }



}
