package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("books")
public class BookController {

    @Autowired
    BookService bookService;


    // post request /create-book
    // pass book as request body
    @PostMapping("/create-book")
    public ResponseEntity createBook(@RequestBody Book book){
        // Your code goes here.
        Book newB = bookService.createBook(book);
        return new ResponseEntity<>(newB, HttpStatus.CREATED);
    }

    // get request /get-book-by-id/{id}
    // pass id as path variable
    // getBookById()
   @GetMapping("/books/get-book-by-id/{id}")
    public ResponseEntity getBookById(@PathVariable("id") int id) {
        Book newB = bookService.getBookById(id);
        return new ResponseEntity<>(newB,HttpStatus.CREATED);
    }
   // delete request /delete-book-by-id/{id}
   // pass id as path variable
   // deleteBookById()
      @DeleteMapping("/books/delete-book-by-id/{id}")
    public ResponseEntity deleteBookById(@PathVariable("id") int id){
         bookService.deleteBookById(id);
         return new ResponseEntity<>("Successfully Deleted",HttpStatus.FOUND);
    }

    // get request /get-all-books
    // getAllBooks()
    @GetMapping("/books/get-all-books")
    public ResponseEntity getAllBooks(){
        List<Book> l = bookService.getAllBooks();
        return new ResponseEntity<>(l,HttpStatus.ACCEPTED);
    }


    // delete request /delete-all-books
    // deleteAllBooks()
    @DeleteMapping("/books/delete-all-books")
    public ResponseEntity deleteAllBooks(){
        bookService.deleteAllBooks();
        return new ResponseEntity<>("All Data Deleted",HttpStatus.FOUND);
    }

    // get request /get-books-by-author
    // pass author name as request param
    // getBooksByAuthor()
    @GetMapping("/books/get-books-by-author")
    public ResponseEntity getBooksByAuthor(@RequestParam("author") String author){
        List<Book> l = bookService.getBooksByAuthor(author);
        return new ResponseEntity<>(l ,HttpStatus.CREATED);
    }

    // get request /get-books-by-genre
    // pass genre name as request param
    // getBooksByGenre()
    @GetMapping("/books/get-books-by-genre")
    public ResponseEntity getBooksByGenre(@RequestParam("genre") String genre){
       List<Book> l = bookService.getBooksByGenre(genre);
       return new ResponseEntity<>(l ,HttpStatus.CREATED);
    }
}
