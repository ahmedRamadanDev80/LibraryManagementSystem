package com.LibraryManagementSystem.LMS.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.LibraryManagementSystem.LMS.entities.Book;

public interface BookRepo extends JpaRepository<Book, Integer>{
}
