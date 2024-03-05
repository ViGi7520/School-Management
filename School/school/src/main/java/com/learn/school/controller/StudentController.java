package com.learn.school.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.learn.school.model.Student;
import com.learn.school.repository.StudentRepository;
import com.learn.school.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
   
@Autowired
StudentRepository studentRepo;
@Autowired
StudentService studentService;


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    //Read
    @RequestMapping(value="/showAll", method=RequestMethod.GET)
    public List<Student> getStudent() {
        System.out.println("Function= show all");
        return studentService.getStudent();
    }
    
    //Query
    @RequestMapping(value="/showQuery", method=RequestMethod.GET)
    public List<Student> queryMethod() {
        System.out.println("Function= show all by query");
        return studentService.queryMethod();
    }
    
    //Read By name
    @RequestMapping(value="/studentByName/{firstName}", method=RequestMethod.GET)
    public List<Student> queryMethodName(@PathVariable(value="firstName")String StudentFirstName){
        // return studentService.getStudentByName();
    
        return studentRepo.getStudentByName(StudentFirstName);
    }


    //Read By Id
    @RequestMapping(value="/getById/{id}", method=RequestMethod.GET)
    public Optional<Student> getStudentById(@PathVariable(value="id") Long studentId ){
        return studentService.getStudentById(studentId);
    }
    
    //DELETE
    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public void deleteStudent(@PathVariable(value="id") Long studentId ){
    	studentService.deleteStudent(studentId);
	}

    //Delete All
    @RequestMapping(value="/deleteAll", method=RequestMethod.DELETE)
    public void deleteAll() {
        studentService.deleteAll();
    }

    //Updates
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public Student updateStudent(@PathVariable(value = "id") Long studentId, @RequestBody Student student) {
        return studentService.updateStudent(studentId, student);
    }

    //Count
    @RequestMapping(value="/count", method=RequestMethod.POST)
    public void countMethod(){
        studentService.countMethod();
        
    }
    
    // @RequestMapping(value = "/getStudentListLength", method = RequestMethod.POST)
	// public ResponseEntity<?> getStudentListLength(@RequestBody Student student) throws Exception {
	// 	logger.info("StudentController->>> getStudentListLength Start-->");
	// 	Integer count = 0;
	// 	try {

	// 		count = studentService.getStudentListLength(student);
						
	// 	} catch (Exception e) {
	// 		e.printStackTrace();
	// 		logger.error("StudentController getStudentListLength " + e.getMessage(), e);
	// 		return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
	// 	}
	// 	logger.info("StudentController->>> getStudentListLength  End-->");
	// 	return ResponseEntity.ok(count);
	// }

}
