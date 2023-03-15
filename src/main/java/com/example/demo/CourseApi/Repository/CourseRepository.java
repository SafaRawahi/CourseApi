package com.example.demo.CourseApi.Repository;

import com.example.demo.CourseApi.Model.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Integer> {
}
