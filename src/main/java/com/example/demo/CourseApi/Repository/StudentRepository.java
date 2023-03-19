package com.example.demo.CourseApi.Repository;

import com.example.demo.CourseApi.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query(value = "SELECT s from Student s  ")
    List<Student> getAllStudent();


//    @Query(value = "SELECT st from Student st " +
//            "WHERE st.school.id = :id ")
//    List<Student> getStudentsBySchoolId(@Param("id") Integer id);
//
//    @Query(value = "SELECT DISTINCT school_id FROM student", nativeQuery = true)
//    List<Integer> getDistinctSchoolIdsFromStudent();
//
//    @Query(value = "SELECT COUNT(id) From student where school_id = ?1", nativeQuery = true)
//    Integer getCountOfStudentsBySchoolId(Integer schoolId);
}
