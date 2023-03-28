package com.example.demo.CourseApi.Repository;

import com.example.demo.CourseApi.Model.Course;
import com.example.demo.CourseApi.Model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Integer> {


    @Query(value = "SELECT s from Course s  ")           //getAllCourse
    List<Course> getAllCourse();
}
