package org.example.onlinecourse.repository;

import org.example.onlinecourse.model.Strudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Strudent , Long> {

    boolean existsById(Long id);
}
