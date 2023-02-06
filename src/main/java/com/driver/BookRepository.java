package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;

@Repository
public class BookRepository {
    HashMap<Integer,Book> map ;
    private int id ;

    public BookRepository(){
        map = new HashMap<>();
        id = 1;
    }

    public Book createBook(Book book){
        book.setId(id);

        map.put(id, book);
        id++;
        return book;
    }

    public Book getBookById(int id){
        return map.get(id);
    }

    public List<Book> getAllBooks(){
        List<Book> list = new ArrayList<>();
        for(Book b : map.values())
            list.add(b);
        return list;
    }

    public List<Book> getBooksByAuthor(String author){
        List<Book> list = new ArrayList<>();
        for(Book b : map.values()){
            if(b.getAuthor().equals(author))
                list.add(b);
        }
        return list;
    }

    public List<Book> getBooksByGenre(String genre){
        List<Book> list = new ArrayList<>();
        for(Book b : map.values()){
            if(b.getGenre().equals(genre))
                list.add(b);
        }
        return list;
    }
    public void deleteBookById(int id){
        map.remove(id);
    }

    public void deleteAllBooks(){
        map.clear();
    }
}
