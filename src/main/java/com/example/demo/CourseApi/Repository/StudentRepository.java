package com.example.demo.CourseApi.Repository;

import com.example.demo.CourseApi.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query(value = "SELECT s from Student s  ")
    List<Student> getAllStudent();


    @Query(value = "SELECT st from Student st " +
            "WHERE st.school.id = :id ")                                   //getStudentsBySchoolId
    List<Student> getStudentsBySchoolId(@Param("id") Integer id);


   @Query(value = "SELECT st from Student st where st.id = :studentId")    //getStudentById
    Student getStudentById(@Param("studentId") Integer id);

    @Query(value="SELECT s from Student s Where s.isActive=True")                     // getAllStudentsIsActive
    List<Student> getAllStudentsIsActive();

    @Query(value = "select st from Student st where st.isActive = 0")        //getAllInActiveStudents
    List<Student> getAllInActiveStudents();

    @Query(value ="SELECT s From Student s Where s.id=(SELECT MAX(s.id) From Student s)")             //getLatestRowInStudent
    List<Student> getLatestRowInStudent();



}
