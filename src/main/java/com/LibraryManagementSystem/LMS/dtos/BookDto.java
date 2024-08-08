package com.LibraryManagementSystem.LMS.dtos;
import com.LibraryManagementSystem.LMS.entities.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDto{
    private int id;
    private String title;
    private String author;
    private int publicationYear;
    private String isbn;


    public static BookDto from (Book myBook){
        return new BookDto(
                myBook.getId(),
                myBook.getTitle(),
                myBook.getAuthor(),
                myBook.getPublicationYear(),
                myBook.getIsbn()
        );
    }
}