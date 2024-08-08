package com.LibraryManagementSystem.LMS.controllers;

import com.LibraryManagementSystem.LMS.dtos.PatronDto;
import com.LibraryManagementSystem.LMS.services.PatronService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patrons")
public class PatronController {
    @Autowired
    private PatronService patronService;

    @GetMapping("/{id}")
    public PatronDto getPatronById(@PathVariable Integer id){

        return  patronService.getPatronById(id);
    }

    @GetMapping
    public List<PatronDto> getPatron(){
        return patronService.getPatron();
    }

    @PostMapping
    public ResponseEntity<String> addPatron(@Valid @RequestBody PatronDto patronDto){
        try{

            patronService.addPatron(patronDto);
            return ResponseEntity.ok("Patron added");
        }
        catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePatron(@Valid @RequestBody PatronDto patronDto, @PathVariable Integer id){
        patronService.UpdatePatron(patronDto,id);
        return ResponseEntity.ok("Patron Updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatron(@PathVariable Integer id){
        patronService.DeletePatron(id);
        return ResponseEntity.ok("Patron Deleted");
    }

}