package com.LibraryManagementSystem.LMS.repos;

import com.LibraryManagementSystem.LMS.entities.BorrowingRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowingRecordRepo extends JpaRepository<BorrowingRecord, Integer> {
}