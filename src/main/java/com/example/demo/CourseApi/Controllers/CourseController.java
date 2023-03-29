package com.example.demo.CourseApi.Controllers;

import com.example.demo.CourseApi.Model.Course;
import com.example.demo.CourseApi.Model.Student;
import com.example.demo.CourseApi.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
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

    @RequestMapping(value = "getAllInActiveCourse", method = RequestMethod.GET)     //getAllInActiveCourse
    public List<Course> getAllInActiveCourse() {
        List<Course> AllInActiveCourse = new ArrayList<>();
        AllInActiveCourse = courseService.getAllInActiveCourse();
        return AllInActiveCourse;
    }

//    @RequestMapping(value = "getLatestRowInCourse", method = RequestMethod.GET)        //getLatestRowInCourse
//    public List<Course> getLatestRowInCourse() {
//        List<Course> courseList = courseService.getLatestRowInCourse();
//        return courseList;
//    }

    @RequestMapping(value = "getLatestUpdatedDate", method = RequestMethod.GET)              // getLatestUpdatedDateCourse
    public Course getLatestUpdatedDate() {
        Course course = courseService.getLatestUpdatedDate();
        return course;
    }

    @RequestMapping(value = "getCourseCreatedAfterDate" , method = RequestMethod.GET)
    public List<Course> getCourseCreatedAfterDate(@RequestParam String createdDate) throws ParseException {         //getCourseCreatedAfterDate
        List<Course> courseList =new ArrayList<>();
        courseList=courseService.getCourseCreatedAfterDate(createdDate);
        return courseList;
    }

    @RequestMapping(value = "getByCourseName",method =RequestMethod.GET )                //getCourseByCourseName
    public Course getCourseByCourseName(@RequestParam String name) {
        Course course= courseService.getCourseByCourseName(name);
        return course;
    }

    @RequestMapping(value = "getCourseByCreatedDate", method = RequestMethod.GET)                      //getCourseByCreatedDate
    public List<Course> getCourseByCreatedDate(String createdDate) throws ParseException {
        List<Course> courses = courseService.getCourseByCreatedDate(createdDate);
        return courses;
    }

    @RequestMapping(value = "getCourseByUpdatedDate", method = RequestMethod.GET)                  //getCourseByUpdatedDate
    public List<Course> getCourseByUpdatedDate(String updatedDate) throws ParseException {
        List<Course> courses = courseService.getCourseByUpdatedDate(updatedDate);
        return courses;
    }
    @RequestMapping(value = "getCourseByStudentId", method = RequestMethod.GET)                  //getCourseByStudentId
    public List<Course> getCourseByStudentId(@RequestParam Integer studentId) {
        List<Course> courses = courseService.getCourseByStudentId(studentId);
        return courses;
    }
    @RequestMapping(value = "getAllActiveCoursesForAStudent", method = RequestMethod.GET)         //getAllActiveCoursesForAStudent
    public List<Course> getAllActiveCoursesForAStudent(@RequestParam Integer studentId) {
        List<Course> courses = courseService.getAllActiveCoursesForAStudent(studentId);
        return courses;
    }

}
