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

    public void addStudent() {
        Student student = new Student();
        student.setName("Mohammed Ali");
        student.setRollNumber("1");
        studentRepository.save(student);

    }

//    public void deleteStudentById(Integer id){
//        Student studentToDelete = studentRepository.findById(id).get();
//        studentRepository.delete(studentToDelete);
//    }

    public List<Student> getStudentsBySchoolName(String schoolName){
        School school = schoolRepository.getBySchoolName(schoolName);
        Integer schoolId = school.getId();
        List<Student> studentList = studentRepository.getStudentsBySchoolId(schoolId);
        return studentList;
    }

    public List<Student> getAllStudents(){
        return studentRepository.getAllStudent();
    }
}
