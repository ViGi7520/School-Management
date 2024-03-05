package com.learn.school.model;

// import java.util.List;
// import com.learn.school.model.Student;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Department {
    
    @Id
    @Column(name = "department_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long department_id;

    @Column(name = "department", nullable = false, length = 32)
    public String department;
    
    @Column(name = "teacher", nullable = false, length = 32)
    public String teacher;

    
    public Department(Long department_id, String department, String teacher) {
        this.department_id = department_id;
        this.department = department;
        this.teacher = teacher;
    }

    public Department(){
    }

   

}

    // @OneToMany(mappedBy = "department")
	// private List<Student> students;

    // @OneToMany(mappedBy = "department")
    // private Student student;

    // @OneToMany(mappedBy = "department")
    // private List<Teacher> teacher;

    // @ManyToOne(targetEntity = Student.class, fetch = FetchType.EAGER)
	// @JoinColumn(name = "studentId")
	// // @Audited
	// private Student student;

	// @Column(name = "studentId", insertable = false, updatable = false)
	// // @Audited
	// private Long studentId;
