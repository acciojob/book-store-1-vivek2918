package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public Book createBook(Book book){
        return bookRepository.createBook(book);
    }

    public Book getBookById(int id){
        return bookRepository.getBookById(id);
    }

    public List<Book> getAllBooks(){
        return bookRepository.getAllBooks();
    }

    public List<Book> getBooksByAuthor(String author){
        return bookRepository.getBooksByAuthor(author);
    }

    public List<Book> getBooksByGenre(String genre) {
        return bookRepository.getBooksByGenre(genre);
    }

    public void deleteBookById(int id){
       bookRepository.deleteBookById(id);
    }

    public void deleteAllBooks(){
        bookRepository.deleteAllBooks();
    }
}
