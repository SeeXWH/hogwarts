package com.example.apitest.repository;

import com.example.apitest.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}
