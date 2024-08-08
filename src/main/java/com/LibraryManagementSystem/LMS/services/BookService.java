package com.LibraryManagementSystem.LMS.services;
import com.LibraryManagementSystem.LMS.dtos.BookDto;
import com.LibraryManagementSystem.LMS.entities.Book;
import com.LibraryManagementSystem.LMS.repos.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;


    public BookDto getBookById(Integer id) {
        Book book = bookRepo.findById(id).orElseThrow(() -> new RuntimeException("No Book is founded"));

        return BookDto.from(book);
    }


    public List<BookDto> getBooks() {
        List<Book> booksFromDB = bookRepo.findAll();

        return booksFromDB.stream().map(BookDto::from).collect(Collectors.toList());
    }

    public void addBook(BookDto bookDto) {
        Book CreatedBook = Book.from(bookDto);
        bookRepo.save(CreatedBook);

    }

    public  void UpdateBook(BookDto bookDto,Integer id) {
        Book book = bookRepo.findById(id).orElseThrow(() -> new RuntimeException("No Book is founded"));
        Book UpdatedBook = Book.from(bookDto);
        bookRepo.save(UpdatedBook);
    }


    public void DeleteBook(Integer id) {
        bookRepo.deleteById(id);
    }

}
