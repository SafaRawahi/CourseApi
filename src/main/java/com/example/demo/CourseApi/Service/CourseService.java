package com.example.demo.CourseApi.Service;

import com.example.demo.CourseApi.Model.Course;
import com.example.demo.CourseApi.Model.Student;
import com.example.demo.CourseApi.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public List<Course> getAllCourse(){                 //getAllCourse

        return courseRepository.getAllCourse();
    }
    public Course getCourseById(Integer course_id) {                        //getCourseById
        Course course = courseRepository.getCourseById(course_id);
        return course;
    }
}
