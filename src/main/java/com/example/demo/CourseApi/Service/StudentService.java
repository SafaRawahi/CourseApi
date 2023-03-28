package com.example.demo.CourseApi.Service;


import com.example.demo.CourseApi.Model.School;
import com.example.demo.CourseApi.Model.Student;
import com.example.demo.CourseApi.Repository.SchoolRepository;
import com.example.demo.CourseApi.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    public List<Student> getAllStudentsIsActive() {                          //get all Student is Active
        return studentRepository.getAllStudentsIsActive();

    }
    public List<Student> getAllInActiveStudents() {
        List<Student> allInActiveStudents = studentRepository.getAllInActiveStudents();     //getAllInActiveStudents
        return allInActiveStudents;
    }

    public List<Student> getLatestRowInStudent() {                            //getLatestRowInStudent
        return studentRepository.getLatestRowInStudent();

    }
    public List<Student> getStudentCreatedAfterDate(String StringCreatedDate) throws ParseException {                //getStudentCreatedAfterDate
        DateFormat format = new SimpleDateFormat("yyyy-MM-DD");
        Date date = format.parse(StringCreatedDate);
        List<Student> studentList = studentRepository.getStudentCreatedAfterDate(date);
        return studentList;
    }
    public Student getStudentByStudentName(String student_Name){                        //getStudentByStudentName
        Student student=studentRepository.getStudentByStudentName(student_Name);
        return student;
    }

    public List<Student> getStudentByCreatedDate(String createdDate) {                     //getStudentByCreatedDate
        List<Student> student = studentRepository.getStudentByCreatedDate(createdDate);
        return student;
    }
    public List<Student> getStudentByUpdatedDate(String updatedDate) {                   //getStudentByUpdatedDate
        List<Student> student = studentRepository.getStudentByUpdatedDate(updatedDate);
        return student;
    }
    public Student getStudentByRollNumber(String roll_Number){                        //getStudentByPhoneNumber
        Student student=studentRepository.getStudentByRollNumber(roll_Number);
        return student;
    }
    public Student getLatestUpdatedDate() {                            //getLatestUpdatedDate
        Student student = studentRepository.getLatestUpdatedDate();
        return student;

    }
    public void deleteStudentById(Integer Id) {                   // deleteStudentById
        Student student= studentRepository.getStudentById(Id);
        student.setIsActive(false);
        studentRepository.save(student);
    }
    public void deleteAllStudent() {                                //deleteAllStudent
        studentRepository.deleteAllStudentByIsActiveFalse();
    }

    public void deleteAllStudentsCreatedAfterDate(String createdDate)throws ParseException{          //deleteAllStudentsCreatedAfterDate
        DateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(createdDate);
        List<Student> studentList =studentRepository.deleteAllStudentsCreatedAfterDate(date);
        studentList.stream().forEach(x -> x.setActive(true));
        studentRepository.saveAll(studentList);
    }
    public void deleteStudentByStudentName(String student_Name) {                    //deleteStudentByStudentName
        Student student = studentRepository.getStudentByStudentName(student_Name);
        student.setActive(true);
        studentRepository.save(student);
    }
    public void deleteStudentsByCreatedDate(String createdDate) {                  //deleteStudentsByCreatedDate
        List<Student> studentList = studentRepository.getStudentByCreatedDate(createdDate);
        studentList.stream().forEach(x -> x.setIsActive(false));
        studentRepository.saveAll(studentList);
    }

    public void deleteStudentsByUpdatedDate(String updatedDate) {                        //deleteStudentsByUpdatedDate
        List<Student> studentList = studentRepository.getStudentByUpdatedDate(updatedDate);
        studentList.stream().forEach(x -> x.setIsActive(false));
        studentRepository.saveAll(studentList);
    }
    public void createStudent(String student_Name) {                          //createStudent
        Student student=  new Student();
        student.setName(student_Name);
        student.setCreatedDate(new Date());
        student.setIsActive(Boolean.TRUE);
        studentRepository.save(student);
    }


}
