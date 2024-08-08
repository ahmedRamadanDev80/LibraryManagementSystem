package com.LibraryManagementSystem.LMS.repos;

import com.LibraryManagementSystem.LMS.entities.BorrowingRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BorrowingRecordRepo extends JpaRepository<BorrowingRecord, Integer> {
    Optional<BorrowingRecord> findByBookIdAndPatronIdAndReturnDateIsNull(Integer bookId, Integer patronId);
}