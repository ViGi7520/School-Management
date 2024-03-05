package com.learn.school.repository;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

import com.learn.school.model.Department;

// @Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    
}
