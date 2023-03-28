package com.example.demo.CourseApi.Repository;

import com.example.demo.CourseApi.Model.Course;
import com.example.demo.CourseApi.Model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Integer> {


    @Query(value = "SELECT s from Course s  ")           //getAllCourse
    List<Course> getAllCourse();

    @Query(value = "SELECT c from Course c where c.id = :course_id")    //getCourseById
    Course getCourseById(@Param("course_id") Integer id);



}
