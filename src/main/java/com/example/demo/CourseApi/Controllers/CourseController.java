package com.example.demo.CourseApi.Controllers;

import com.example.demo.CourseApi.Model.Course;
import com.example.demo.CourseApi.Model.Student;
import com.example.demo.CourseApi.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @RequestMapping(value = "getAll", method = RequestMethod.GET)                 //getAllCourse
    public List<Course> getAllStudent() {
        List<Course> courses = courseService.getAllCourse();
        return courses;
    }

    @RequestMapping(value = "getById", method = RequestMethod.GET)                    //getCourseById
    public Course getCourseById(@RequestParam Integer course_id) {
        Course course = courseService.getCourseById(course_id);
        return course;

    }

    @RequestMapping(value = "getAllCourseIsActive", method = RequestMethod.GET)              //getAllCourseIsActive
    public List<Course> getAllCourseIsActive() {
        List<Course> courseList = courseService.getAllCourseIsActive();
        return courseList;

    }



}
