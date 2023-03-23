package com.example.demo.CourseApi.Controllers;

import com.example.demo.CourseApi.Model.School;
import com.example.demo.CourseApi.Model.Student;
import com.example.demo.CourseApi.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
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

    @RequestMapping(value = "getById", method = RequestMethod.GET)                    //getStudentById
    public Student getStudentById(@RequestParam Integer studentId) {
        Student student = studentService.getStudentById(studentId);
        return student;

    }

    @RequestMapping(value = "getAllStudentsIsActive", method = RequestMethod.GET)              //getAllStudentsIsActive
    public List<Student> getAllStudentsIsActive() {
        List<Student> studentList = studentService.getAllStudentsIsActive();
        return studentList;

    }

    @RequestMapping(value = "getAllInActiveStudents", method = RequestMethod.GET)     //getAllInActiveStudents
    public List<Student> getAllInActiveStudents() {
        List<Student> AllInActiveStudents = new ArrayList<>();
        AllInActiveStudents = studentService.getAllInActiveStudents();
        return AllInActiveStudents;
    }

    @RequestMapping(value = "getLatestRowInStudent", method = RequestMethod.GET)        //getLatestRowInStudent
    public List<Student> getLatestRowInStudent() {
        List<Student> studentList = studentService.getLatestRowInStudent();

        return studentList;
    }
    @RequestMapping(value = "getStudentCreatedAfterDate" , method = RequestMethod.GET)
    public List<Student> getStudentCreatedAfterDate(@RequestParam String createdDate) throws ParseException {         //getStudentCreatedAfterDate
        List<Student> studentList=new ArrayList<>();
        studentList=studentService.getStudentCreatedAfterDate(createdDate);
        return studentList;
    }
    @RequestMapping(value = "getByStudentName",method =RequestMethod.GET )                //getStudentByStudentName
    public Student getStudentByStudentName(@RequestParam String student_Name) {
        Student student= studentService.getStudentByStudentName(student_Name);
        return student;
    }


    @RequestMapping(value = "getStudentByCreatedDate", method = RequestMethod.GET)                      //getStudentByCreatedDate
    public List<Student> getStudentByCreatedDate(String createdDate) throws ParseException {
        List<Student> student = studentService.getStudentByCreatedDate(createdDate);
        return student;
    }

    @RequestMapping(value = "getStudentsByUpdatedDate", method = RequestMethod.GET)                  //getStudenByUpdatedDate
    public List<Student> getStudenByUpdatedDate(String updatedDate) throws ParseException {
        List<Student> student = studentService.getStudentByUpdatedDate(updatedDate);
        return student;
    }

    @RequestMapping(value = "getStudentByRollNumber",method =RequestMethod.GET )                //getStudentByRollNumber
    public Student getStudentByRollNumber(@RequestParam String roll_Number) {
        Student student= studentService.getStudentByRollNumber(roll_Number);
        return student;
    }
    @RequestMapping(value = "getLatestUpdatedDate", method = RequestMethod.GET)              // getLatestUpdatedDate
    public Student getLatestUpdatedDate() {
        Student student = studentService.getLatestUpdatedDate();
        return student;
    }

}