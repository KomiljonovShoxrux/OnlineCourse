package org.example.onlinecourse.repository;

import org.example.onlinecourse.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepo extends JpaRepository<Enrollment, Long> {
    boolean existsById(Long id);
}
