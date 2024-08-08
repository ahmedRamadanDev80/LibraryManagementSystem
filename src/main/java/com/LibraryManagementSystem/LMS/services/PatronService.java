package com.LibraryManagementSystem.LMS.services;

import com.LibraryManagementSystem.LMS.dtos.PatronDto;
import com.LibraryManagementSystem.LMS.entities.Patron;
import com.LibraryManagementSystem.LMS.repos.PatronRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatronService {
    @Autowired
    private PatronRepo patronRepo;

    public PatronDto getPatronById(Integer id) {
        Patron patron = patronRepo.findById(id).orElseThrow(() -> new RuntimeException("No Book is founded"));

        return PatronDto.from(patron);
    }

    public List<PatronDto> getPatron() {
        List<Patron> patronFromDB = patronRepo.findAll();

        return patronFromDB.stream().map(PatronDto::from).collect(Collectors.toList());
    }

    public void addPatron(PatronDto patronDto) {
        Patron CreatedPatron = Patron.from(patronDto);
        patronRepo.save(CreatedPatron);

    }

    public  void UpdatePatron(PatronDto patronDto,Integer id) {
        Patron patron = patronRepo.findById(id).orElseThrow(() -> new RuntimeException("No Book is founded"));
        Patron UpdatedPatron = Patron.from(patronDto);
        patronRepo.save(UpdatedPatron);
    }

    public void DeletePatron(Integer id) {
        patronRepo.deleteById(id);
    }

}
