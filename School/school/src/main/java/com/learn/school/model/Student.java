package com.learn.school.model;

// import java.time.LocalDate;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "students")
public class Student {
    
    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long student_id;

    @Column(name = "firstName", nullable = false, length = 32)
    private String firstName;

    @Column(name = "lastName", nullable = false, length = 32)
    private String lastName;

    @Column(name = "department", nullable = false, length = 32)
    private String department;
    
    // @ManyToOne
    // private Department department;

    // @Column(name = "department", nullable = false, length = 32)
    // private String department;

    public Student(Long student_id, String firstName, String lastName, String department) {
        this.student_id = student_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }

    public Student() {
    }

   
}
