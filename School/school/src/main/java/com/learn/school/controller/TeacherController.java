package com.learn.school.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.learn.school.model.Teacher;
import com.learn.school.repository.TeacherRepository;
import com.learn.school.service.TeacherService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@RestController
@RequestMapping("/teacher")
public class TeacherController {
    
@Autowired
TeacherRepository teacherRepository;
@Autowired 
TeacherService teacherService;

    //Create
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Teacher createTeacher(@RequestBody Teacher teacher){
        return teacherService.createTeacher(teacher);
    }
    
    //Read
    @RequestMapping(value="/showAll", method=RequestMethod.GET)
    public List<Teacher> getTeacher() {
        return teacherService.getTeacher();
    }
 
    //Read By Id
    @RequestMapping(value="/getById/{id}", method=RequestMethod.GET)
	public Optional<Teacher> getTeachersById(@PathVariable(value="id") Long teacherId ){
		return teacherService.getTeachersById(teacherId);
	}

    //DELETE
    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public void deleteTeacher(@PathVariable(value="id") Long teacherId ){
    	teacherService.deleteTeacher(teacherId);
	}

    @RequestMapping(value="/deleteAll", method=RequestMethod.DELETE)
    public void deleteAll() {
        teacherService.deleteAll();
    }
    
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public Teacher updateTeacher(@PathVariable(value = "id") Long teacherId, @RequestBody Teacher teacher) {
        return teacherService.updateTeacher(teacherId, teacher);
    }

}
