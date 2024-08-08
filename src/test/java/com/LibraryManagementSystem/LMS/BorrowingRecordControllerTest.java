package com.LibraryManagementSystem.LMS;

import com.LibraryManagementSystem.LMS.controllers.BorrowingRecordController;
import com.LibraryManagementSystem.LMS.dtos.BorrowingRecordDto;
import com.LibraryManagementSystem.LMS.services.BorrowingRecordService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BorrowingRecordController.class)
public class BorrowingRecordControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BorrowingRecordService borrowingRecordService;

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @BeforeEach
    void setUp() {
        // Setup can be done here if needed
    }

    @Test
    void testBorrowBook() throws Exception {
        Date borrowingDate = parseDate("2024-08-08");
        BorrowingRecordDto borrowingRecordDto = new BorrowingRecordDto(1, 1, 1, borrowingDate, null);
        when(borrowingRecordService.borrowBook(1, 1)).thenReturn(borrowingRecordDto);

        mockMvc.perform(post("/api/borrow/1/patron/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.bookId").value(1))
                .andExpect(jsonPath("$.patronId").value(1));
    }

    @Test
    void testReturnBook() throws Exception {
        Date borrowingDate = parseDate("2024-08-08");
        Date returnDate = parseDate("2024-08-10");
        BorrowingRecordDto borrowingRecordDto = new BorrowingRecordDto(1, 1, 1, borrowingDate, returnDate);
        when(borrowingRecordService.returnBook(1, 1)).thenReturn(borrowingRecordDto);

        mockMvc.perform(put("/api/return/1/patron/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.bookId").value(1))
                .andExpect(jsonPath("$.patronId").value(1));
    }

    private Date parseDate(String dateString) throws ParseException {
        return dateFormat.parse(dateString);
    }
}