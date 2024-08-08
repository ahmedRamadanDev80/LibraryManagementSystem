package com.LibraryManagementSystem.LMS.entities;

import com.LibraryManagementSystem.LMS.dtos.PatronDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Patron {

    @Id
    @SequenceGenerator(name = "PATRON_ID_SEQ_GENERATOR", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "PATRON_ID_SEQ_GENERATOR")
    private Integer id;
    private String name;
    private String contactInfo;

    public static Patron from(PatronDto patrondto) {
        return new Patron(
                patrondto.getId(),
                patrondto.getName(),
                patrondto.getContactInfo()
        );
    }
}