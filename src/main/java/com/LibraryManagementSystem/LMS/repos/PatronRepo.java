package com.LibraryManagementSystem.LMS.repos;
import com.LibraryManagementSystem.LMS.entities.Patron;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatronRepo extends JpaRepository<Patron, Integer> {
}