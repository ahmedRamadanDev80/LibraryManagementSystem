package com.LibraryManagementSystem.LMS.entities;
import com.LibraryManagementSystem.LMS.dtos.BookDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Book  {
    @Id
    @SequenceGenerator(name = "BOOK_ID_SEQ_GENERATOR", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "BOOK_ID_SEQ_GENERATOR")
    private Integer id;

    private String title;
    private String author;
    private int publicationYear;
    private String isbn;

    public static Book from(BookDto bookdto) {
        return new Book(
                bookdto.getId(),
                bookdto.getTitle(),
                bookdto.getAuthor(),
                bookdto.getPublicationYear(),
                bookdto.getIsbn()
        );
    }
}
