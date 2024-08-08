package com.LibraryManagementSystem.LMS.controllers;

import com.LibraryManagementSystem.LMS.dtos.BorrowingRecordDto;
import com.LibraryManagementSystem.LMS.services.BorrowingRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BorrowingRecordController {
    @Autowired
    private BorrowingRecordService borrowingRecordService;

    @PostMapping("/borrow/{bookId}/patron/{patronId}")
    public ResponseEntity<BorrowingRecordDto> borrowBook(
            @PathVariable Integer bookId,
            @PathVariable Integer patronId) {
        BorrowingRecordDto borrowingRecordDTO = borrowingRecordService.borrowBook(bookId, patronId);
        return ResponseEntity.ok(borrowingRecordDTO);
    }
}
