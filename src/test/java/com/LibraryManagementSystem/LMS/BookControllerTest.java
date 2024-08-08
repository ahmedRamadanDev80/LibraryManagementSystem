package com.LibraryManagementSystem.LMS;

import com.LibraryManagementSystem.LMS.controllers.BookController;
import com.LibraryManagementSystem.LMS.dtos.BookDto;
import com.LibraryManagementSystem.LMS.services.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @BeforeEach
    void setUp() {
        // Setup can be done here if needed
    }

    @Test
    void testGetBooks() throws Exception {
        BookDto bookDto = new BookDto(1, "Test Book", "Author", 2024, "1234567890123");
        when(bookService.getBooks()).thenReturn(Collections.singletonList(bookDto));

        mockMvc.perform(get("/api/books")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Test Book"));
    }

    @Test
    void testGetBookById() throws Exception {
        BookDto bookDto = new BookDto(1, "Test Book", "Author", 2024, "1234567890123");
        when(bookService.getBookById(1)).thenReturn(bookDto);

        mockMvc.perform(get("/api/books/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Test Book"));
    }

    @Test
    void testUpdateBook() throws Exception {
        BookDto bookDto = new BookDto(1, "Updated Book", "Updated Author", 2024, "1234567890123");
        doNothing().when(bookService).UpdateBook(bookDto, 1);

        mockMvc.perform(put("/api/books/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\":\"Updated Book\",\"author\":\"Updated Author\",\"publicationYear\":2024,\"isbn\":\"1234567890123\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Book Updated"));
    }

    @Test
    void testDeleteBook() throws Exception {
        doNothing().when(bookService).DeleteBook(1);

        mockMvc.perform(delete("/api/books/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Book Deleted"));
    }

    @Test
    void testAddBook() throws Exception {
        BookDto bookDto = new BookDto(1, "New Book", "New Author", 2024, "1234567890123");
        doNothing().when(bookService).addBook(bookDto);

        mockMvc.perform(post("/api/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\":\"New Book\",\"author\":\"New Author\",\"publicationYear\":2024,\"isbn\":\"1234567890123\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Book added"));
    }
}
