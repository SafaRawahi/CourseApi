package com.example.demo.CourseApi.Service;


import com.example.demo.CourseApi.Model.School;
import com.example.demo.CourseApi.Model.Student;
import com.example.demo.CourseApi.Repository.SchoolRepository;
import com.example.demo.CourseApi.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    SchoolRepository schoolRepository;

    public List<Student> getStudentsBySchoolName(String schoolName){                 //getStudentsBySchoolName
        School school = schoolRepository.getBySchoolName(schoolName);
        Integer schoolId = school.getId();
        List<Student> studentList = studentRepository.getStudentsBySchoolId(schoolId);
        return studentList;
    }

    public List<Student> getAllStudents(){                 //getAllStudents

        return studentRepository.getAllStudent();
    }


    public Student getStudentById(Integer id) {                        //getStudentById
        Student student = studentRepository.getStudentById(id);
        return student;
    }


    }
