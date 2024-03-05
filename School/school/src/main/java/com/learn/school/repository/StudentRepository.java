package com.learn.school.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
// import org.springframework.stereotype.Repository;

import com.learn.school.model.Student;

// @Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query ("select s FROM Student s")
    public List<Student> getAllStudentQuery();

    @Query ("select s From Student s WHERE s.firstName LIKE :n")
    public List<Student> getStudentByName (@Param("n") String StudentFirstName);

    List<Student> findByLastName(String lastName);

}
