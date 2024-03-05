package com.learn.school.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.school.model.Teacher;
import com.learn.school.repository.TeacherRepository;

@Service
public class TeacherService {
   
@Autowired
TeacherRepository teacherRepo;
    
    //Create
    public Teacher createTeacher(Teacher teacher){
        return teacherRepo.save(teacher);
    }
    
    //Read
    public List<Teacher> getTeacher(){
        return teacherRepo.findAll();
    }
    
    //findById
    public Optional<Teacher> getTeachersById(Long teacher_id){
        return teacherRepo.findById(teacher_id);
    }
    
    //Delete
    public void deleteTeacher(Long teacher_id){
        teacherRepo.deleteById(teacher_id);
    }
    
    //DeleteAll
    public void deleteAll(){
        teacherRepo.deleteAll();
    }
    
    //Update
    public Teacher updateTeacher(Long teacher_id, Teacher teacherDetails) {
        Teacher teacher = teacherRepo.findById(teacher_id).get();
        teacher.setFirstName(teacherDetails.getFirstName());
        teacher.setLastName(teacherDetails.getLastName());
        teacher.setDepartment(teacherDetails.getDepartment());
        
        return teacherRepo.save(teacher);                                
    }

}
