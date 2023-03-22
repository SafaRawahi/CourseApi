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

    @Query(value="SELECT s from Student s Where s.isActive=True")                     //query to get all Student is active
    List<Student> getAllStudentsIsActive();

    @Query(value = "select st from Student st where st.isActive = 0")
    List<Student> getAllInActiveStudents();

}
