package com.LibraryManagementSystem.LMS.controllers;
import com.LibraryManagementSystem.LMS.dtos.BookDto;
import com.LibraryManagementSystem.LMS.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable Integer id){
        return  bookService.getBookById(id);
    }

    @GetMapping
    public List<BookDto> getBook(){
        return bookService.getBooks();
    }

    @PostMapping
    public ResponseEntity<String> addBook(@Valid @RequestBody BookDto bookDto){
        try{

            bookService.addBook(bookDto);
            return ResponseEntity.ok("Book added");
        }
        catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBook(@Valid @RequestBody BookDto bookDto, @PathVariable Integer id){
        bookService.UpdateBook(bookDto,id);
        return ResponseEntity.ok("Book Updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Integer id){
        bookService.DeleteBook(id);
        return ResponseEntity.ok("Book Deleted");
    }

}
