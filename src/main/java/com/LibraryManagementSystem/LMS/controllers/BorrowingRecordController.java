package com.LibraryManagementSystem.LMS.controllers;

import com.LibraryManagementSystem.LMS.dtos.BorrowingRecordDto;
import com.LibraryManagementSystem.LMS.services.BorrowingRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/return/{bookId}/patron/{patronId}")
    public ResponseEntity<BorrowingRecordDto> returnBook(
            @PathVariable Integer bookId,
            @PathVariable Integer patronId) {
        BorrowingRecordDto borrowingRecordDTO = borrowingRecordService.returnBook(bookId, patronId);
        return ResponseEntity.ok(borrowingRecordDTO);
    }
}
