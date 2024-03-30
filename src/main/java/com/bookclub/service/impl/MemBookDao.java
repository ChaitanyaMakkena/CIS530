package com.bookclub.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.bookclub.model.Book;
import com.bookclub.service.dao.BookDao;

public class MemBookDao implements BookDao {

	private List<Book> books;
    public MemBookDao() {
        books = new ArrayList<>();
        books.add(new Book("6000568903", "Core Java", "This is a Core Java", 400, Arrays.asList("Author-1")));
        books.add(new Book("6000768901", "Spring Boot", "This is a Spring Boot", 150, Arrays.asList("Author-1", "Author-2")));
        books.add(new Book("6000119012", "AWS Lambda", "This is a AWS Lambda", 250, Arrays.asList("Author-1")));
    }
    @Override
    public List<Book> list() {
        return this.books;
    }

    @Override
    public Book find(String key) {

        for (Book book:this.books){
            if(book.getIsbn().equals(key)){
                return book;
            }
        }
        return new Book();
    }

}
