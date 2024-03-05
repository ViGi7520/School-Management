package com.learn.school.model;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @Column(name = "teacher_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacher_id;

    @Column(name = "firstName", nullable = false, length = 32)
    private String firstName;

    @Column(name = "lastName", nullable = false, length = 32)
    private String lastName;

    @Column(name = "department", nullable = false, length = 32)
    private String department;

    // @ManyToOne
    // private Department department;

    public Teacher(Long teacher_id, String firstName, String lastName, String department){
        this.teacher_id = teacher_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }

    public Teacher() {
    }
    
   
}
