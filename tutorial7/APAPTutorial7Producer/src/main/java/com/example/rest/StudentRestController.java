package com.example.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.StudentModel;
import com.example.service.StudentService;
import com.example.model.CourseModel;
import com.example.service.CourseService;


@RestController
@RequestMapping("/rest")
public class StudentRestController {

	@Autowired
	StudentService studentService;
	@Autowired
	CourseService courseService;

	@RequestMapping("/student/view/{npm}")
	public StudentModel view(@PathVariable(value = "npm") String npm) {
		StudentModel student = studentService.selectStudent(npm);
		return student;
	}
	
    @RequestMapping("/student/viewall")
    public List<StudentModel> viewall (Model model)
    {
        List<StudentModel> students = studentService.selectAllStudents ();
        return students;
    }
    
    @RequestMapping("/course/view/{id_course}")
    public CourseModel viewPathCourse (@PathVariable(value = "id_course") String id_course)
    {
        CourseModel course = courseService.selectCourse(id_course);
        return course;
    }
    
    @RequestMapping("/course/viewall")
    public List<CourseModel> viewallCourse (Model model)
    {
        List<CourseModel> courses = courseService.selectAllCourses ();
        return courses;
    }

}
