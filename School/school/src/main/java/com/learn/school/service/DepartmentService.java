package com.learn.school.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.school.model.Department;
import com.learn.school.repository.DepartmentRepository;

@Service
public class DepartmentService {

@Autowired
DepartmentRepository departmentRepo;

public Department createStudent(Department department) {
    return departmentRepo.save(department);
}

public List<Department> getStudent(){
    return departmentRepo.findAll();
}

public Optional<Department> getStudentById(Long department_id){
   return departmentRepo.findById(department_id); 
}

public void deleteStudent(Long department_id){
    departmentRepo.deleteById(department_id);
}

public void deleteAll(){
    departmentRepo.deleteAll();
}

public Department updateStudent(Long department_id, Department departmentDetails) {
    Department department = departmentRepo.findById(department_id).get();
    // department.setDepartment_id(department_id);
    department.setDepartment(departmentDetails.department);
    department.setTeacher(departmentDetails.teacher);
    
    return departmentRepo.save(department);                                
}

}
