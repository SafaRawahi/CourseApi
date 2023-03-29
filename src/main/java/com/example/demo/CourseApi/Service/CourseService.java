package com.example.demo.CourseApi.Service;

import com.example.demo.CourseApi.Model.Course;
import com.example.demo.CourseApi.Model.Student;
import com.example.demo.CourseApi.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public List<Course> getAllCourseIsActive() {                          //getAllCourseIsActive
        return courseRepository.getAllCourseIsActive();
    }

    public List<Course> getAllInActiveCourse() {
        List<Course> AllInActiveCourse = courseRepository.getAllInActiveCourse();     //getAllInActiveCourse
        return AllInActiveCourse;
    }

//    public List<Course> getLatestRowInCourse() {                            //getLatestRowInCourse
//        return courseRepository.getLatestRowInCourse();
//
//    }

    public Course getLatestUpdatedDate() {                            //getLatestUpdatedDateCourse
        Course course = courseRepository.getLatestUpdatedDate();
        return course;

    }


    public List<Course> getCourseCreatedAfterDate(String StringCreatedDate) throws ParseException {                //getCourseCreatedAfterDate
        DateFormat format = new SimpleDateFormat("yyyy-MM-DD");
        Date date = format.parse(StringCreatedDate);
        List<Course> courseList = courseRepository.getCourseCreatedAfterDate(date);
        return courseList;
    }

    public Course getCourseByCourseName(String name){                        //getCourseByCourseName
        Course course=courseRepository.getCourseByCourseName(name);
        return course;
    }
    public List<Course> getCourseByCreatedDate(String createdDate) {                     //getCourseByCreatedDate
        List<Course> courses = courseRepository.getCourseByCreatedDate(createdDate);
        return courses;
    }
    public List<Course> getCourseByUpdatedDate(String updatedDate) {                   //getCourseByUpdatedDate
        List<Course> courses = courseRepository.getCourseByUpdatedDate(updatedDate);
        return courses;
    }
}
