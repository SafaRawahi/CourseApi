package com.example.demo.CourseApi.Repository;

import com.example.demo.CourseApi.Model.Course;
import com.example.demo.CourseApi.Model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Integer> {


    @Query(value = "SELECT c from Course c  ")           //getAllCourse
    List<Course> getAllCourse();

    @Query(value = "SELECT c from Course c where c.id = :course_id")    //getCourseById
    Course getCourseById(@Param("course_id") Integer id);

    @Query(value="SELECT c from Course c where c.isActive=True")                     // getAllCourseIsActive
    List<Course> getAllCourseIsActive();
    @Query(value = "SELECT c from Course c where c.isActive = 0")        //getAllInActiveCourse
    List<Course> getAllInActiveCourse();

//    @Query(value ="SELECT  c from Course c where c.id=(SELECT MAX(s.id) From Course c)")             //getLatestRowInCourse
//    List<Course> getLatestRowInCourse();

    @Query(value = " SELECT  c from Course c where c.updatedDate = (select Max(c.updatedDate) from Course c)")      //getLatestUpdatedDateCourse
    Course getLatestUpdatedDate();

    @Query(value="SELECT  c from Course c where c.createdDate>= :createdDate")                //getCourseCreatedAfterDate
    List<Course>  getCourseCreatedAfterDate(@Param("createdDate") Date createdDate);
    @Query(value="SELECT  c from Course c where c.name = :name")               //getCourseByCourseName
    Course getCourseByCourseName(@Param("name") String name);
}
