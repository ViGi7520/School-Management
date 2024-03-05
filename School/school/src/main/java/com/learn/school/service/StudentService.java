package com.learn.school.service;

// import java.io.File;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.school.model.Student;
import com.learn.school.repository.StudentRepository;

@Service
public class StudentService {
    
@Autowired
StudentRepository studentRepo;

    public Student createStudent(Student student) {
        return studentRepo.save(student);
    }

    public List<Student> getStudent(){
        return studentRepo.findAll();
    }

    public Optional<Student> getStudentById(Long student_id){
       return studentRepo.findById(student_id); 
    }

    public void deleteStudent(Long student_id){
        studentRepo.deleteById(student_id);
    }

    public void deleteAll(){
        studentRepo.deleteAll();
    }

    public Student updateStudent(Long student_id, Student studentDetails) {
        Student student = studentRepo.findById(student_id).get();
        student.setFirstName(studentDetails.getFirstName());
        student.setLastName(studentDetails.getLastName());
        student.setDepartment(studentDetails.getDepartment());
        
        return studentRepo.save(student);                                
    }

    //query test
    public List<Student> queryMethod(){
        System.out.println("queryMethod");
       return studentRepo.getAllStudentQuery();
       
    }

    //name filter query
    public List<Student> getStudentByName() {
        return studentRepo.getStudentByName(null);
    }

    public void countMethod(){
        long count = studentRepo.count();
        System.out.println(count);
    }

    // @Override
	// public Integer getStudentListLength(Student student) throws Exception {
	// 	// logger.info("StudentServiceImp->>> getStudentListLength start-->");
		
	// 	String query = "select count(c.studentId) from Student c  ";
		
	// 	query = getQueryCriteriaStudent(student, query);							
		
	// 	// logger.info("StudentServiceImp->>> getStudentListLength end-->");
	// 	return genericService.getObjectListLength(query);
	// }

    

}
