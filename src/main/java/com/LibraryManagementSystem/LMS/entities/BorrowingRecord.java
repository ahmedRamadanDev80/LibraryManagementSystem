package com.LibraryManagementSystem.LMS.entities;
import com.LibraryManagementSystem.LMS.dtos.BorrowingRecordDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BorrowingRecord {
    @Id
    @SequenceGenerator(name = "BORROWINGRECORD_ID_SEQ_GENERATOR", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "BORROWINGRECORD_ID_SEQ_GENERATOR")
    private Integer id;

    @ManyToOne
    private Book book;

    @ManyToOne
    private Patron patron;

    private Date borrowingDate;
    private Date returnDate;

    public static BorrowingRecord from(BorrowingRecordDto borrowingDTO, Book book, Patron patron) {
        return new BorrowingRecord(
                borrowingDTO.getId(),
                book,
                patron,
                borrowingDTO.getBorrowingDate(),
                borrowingDTO.getReturnDate()
        );
    }
}