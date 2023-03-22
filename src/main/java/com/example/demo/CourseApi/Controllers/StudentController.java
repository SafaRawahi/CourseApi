package com.example.demo.CourseApi.Controllers;

import com.example.demo.CourseApi.Model.Student;
import com.example.demo.CourseApi.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "student")
public class StudentController {


    @Autowired
    StudentService studentService;

    @RequestMapping(value = "getAll", method = RequestMethod.GET)                 //get All
    public List<Student> getAllStudent() {
        List<Student> students = studentService.getAllStudents();
        return students;
    }

    @RequestMapping(value = "getBySchoolName", method = RequestMethod.GET)
    public List<Student> getStudentsBySchoolName(@RequestParam String schoolName) {     //get by school name
        return studentService.getStudentsBySchoolName(schoolName);
    }

    @RequestMapping(value="getById", method =RequestMethod.GET)                   // getStudentById
    public Student getStudentById(@RequestParam Integer studentId){
        Student student= studentService.getStudentById(studentId);
        return student;
    }



}