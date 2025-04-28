package org.example.onlinecourse.repository;

import org.example.onlinecourse.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Long> {

    boolean existsById(Long id);
}
