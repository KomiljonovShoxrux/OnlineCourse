package org.example.onlinecourse.repository;

import org.example.onlinecourse.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepo extends JpaRepository<Instructor, Long> {


    boolean existsById(Long id);
}
