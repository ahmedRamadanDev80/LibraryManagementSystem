package com.LibraryManagementSystem.LMS.dtos;
import com.LibraryManagementSystem.LMS.entities.Book;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDto{
    private int id;
    @NotBlank(message = "Title is Required")
    private String title;
    @NotBlank(message = "Author is Required")
    private String author;
    @Min(value = 1500, message = "Publication year should be no earlier than 1500")
    @Max(value = 2024, message = "Publication year should be no later than the current year")
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