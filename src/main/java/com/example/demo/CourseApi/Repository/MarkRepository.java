package com.example.demo.CourseApi.Repository;

import com.example.demo.CourseApi.Model.Mark;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MarkRepository extends CrudRepository<Mark, Integer> {

    @Query(value = "SELECT m from Mark m")    //getAllMarks
    List<Mark> getAllMarks();

    @Query(value = "SELECT m from Mark m where m.id = :markId")    //getMarkById
    Mark getMarkById(@Param("markId") Integer id);

    @Query(value = "select avg(m.obtainedMarks) from Mark m where m.course.name = :courseName ")         //getAverageOfMarksByCourseName
    Integer getAverageOfMarksByCourseName(@Param("courseName") String courseName);

    @Query(value = "select sum(m.obtainedMarks) from Mark m where m.course.student.id = :studentId ")
    Integer getSumofMarkByStudentId(@Param("studentId")Integer studentId);
}

//    @Query(value = "select m from Mark m where m.isActive =true")
//    List<Mark> getAllActiveMarks();


