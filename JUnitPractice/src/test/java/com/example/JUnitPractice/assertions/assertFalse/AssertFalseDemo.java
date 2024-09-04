package com.example.JUnitPractice.assertions.assertFalse;

import com.example.JUnitPractice.model.Book;
import com.example.JUnitPractice.service.BookService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class AssertFalseDemo {


    @Test
    public void assertFalseWithNoMessage(){

        BookService bookService = new BookService();

        Book headFirstJava = new Book("1","Head First Java","Oreilly");
        bookService.addBook(headFirstJava);

        List<Book> listOfBooks = bookService.books();

        assertFalse(listOfBooks.isEmpty());
    }


    @Test
    public void assertFalseWithBooleanSupplierNoMessage(){

        BookService bookService = new BookService();

        Book headFirstJava = new Book("1","Head First Java","Oreilly");
        bookService.addBook(headFirstJava);
        List<Book> listOfBooks = bookService.books();

        // instead of providing a boolean value, we provided a lambda expression which is nothing but a boolean supplier.
        assertFalse(()->listOfBooks.isEmpty());
    }


    @Test
    public void assertFalseWithMessage(){

        BookService bookService = new BookService();

        Book headFirstJava = new Book("1","Head First Java","Oreilly");
        bookService.addBook(headFirstJava);
        List<Book> listOfBooks = bookService.books();

        assertFalse(listOfBooks.isEmpty(),"List of Books is not Empty");
    }


    @Test
    void assertFalseWithMessageSupplier(){

        BookService bookService = new BookService();

        Book headFirstJavaBook = new Book("1","Head First Java","Oreilly");
        bookService.addBook(headFirstJavaBook);
        List<Book> listOfBooks = bookService.books();
        //using Supplier Interface to provide the customised message.
        //This is like a lazy evaluation.
        assertFalse(listOfBooks.isEmpty(),()->"List of books is not empty");
    }


    @Test
    public void assertFalseWithBooleanSupplierAndMessage(){

        BookService bookService = new BookService();

        Book headFirstJava = new Book("1","Head First Java","Oreilly");
        bookService.addBook(headFirstJava);
        List<Book> listOfBooks = bookService.books();

        assertFalse(()->listOfBooks.isEmpty(),"List of books is not empty");
    }


    @Test
    public void assertFalseWithBooleanSupplierAndMessageSupplier(){

        BookService bookService = new BookService();

        Book headFirstJava = new Book("1","Head First Java","Oreilly");
        bookService.addBook(headFirstJava);
        List<Book> listOfBooks = bookService.books();

        assertFalse(()->listOfBooks.isEmpty(),()->"List of books is not empty");
    }



}
