package com.learn.school.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.learn.school.model.Department;
import com.learn.school.repository.DepartmentRepository;
import com.learn.school.service.DepartmentService;


@RestController
@RequestMapping("/department")
public class DepartmentController {

@Autowired
DepartmentRepository departmentRepo;
@Autowired
DepartmentService departmentService;

@RequestMapping(value = "/create", method = RequestMethod.POST)
public Department createStudent(@RequestBody Department department) {
    return departmentService.createStudent(department);
}

//Read
@RequestMapping(value="/showAll", method=RequestMethod.GET)
public List<Department> getStudent() {
    System.out.println("Function= show all");
    return departmentService.getStudent();
}

//Read By Id
@RequestMapping(value="/getById/{id}", method=RequestMethod.GET)
public Optional<Department> getStudentById(@PathVariable(value="id") Long departmentId ){
    return departmentService.getStudentById(departmentId);
}

//DELETE
@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
public void deleteStudent(@PathVariable(value="id") Long departmentId ){
    departmentService.deleteStudent(departmentId);
}

//Delete All
@RequestMapping(value="/deleteAll", method=RequestMethod.DELETE)
public void deleteAll() {
    departmentService.deleteAll();
}

@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
public Department updateStudent(@PathVariable(value = "id") Long departmentId, @RequestBody Department department) {
    return departmentService.updateStudent(departmentId, department);
}
}
