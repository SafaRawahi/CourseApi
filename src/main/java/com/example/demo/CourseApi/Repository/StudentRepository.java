package com.example.demo.CourseApi.Repository;

import com.example.demo.CourseApi.Model.School;
import com.example.demo.CourseApi.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query(value = "SELECT s from Student s  ")
    List<Student> getAllStudent();


    @Query(value = "SELECT st from Student st " +
            "WHERE st.school.id = :id ")                                   //getStudentsBySchoolId
    List<Student> getStudentsBySchoolId(@Param("id") Integer id);


   @Query(value = "SELECT st from Student st where st.id = :studentId")    //getStudentById
    Student getStudentById(@Param("studentId") Integer id);

    @Query(value="SELECT s from Student s Where s.isActive=True")                     // getAllStudentsIsActive
    List<Student> getAllStudentsIsActive();

    @Query(value = "select st from Student st where st.isActive = 0")        //getAllInActiveStudents
    List<Student> getAllInActiveStudents();

    @Query(value ="SELECT s From Student s Where s.id=(SELECT MAX(s.id) From Student s)")             //getLatestRowInStudent
    List<Student> getLatestRowInStudent();

    @Query(value="SELECT s From Student s Where s.createdDate>= :createdDate")                //getStudentCreatedAfterDate
    List<Student>  getStudentCreatedAfterDate(@Param("createdDate") Date createdDate);

    @Query(value="SELECT s from Student s Where s.name = :student_Name")          //getStudentByStudentName
    Student getStudentByStudentName(@Param("student_Name") String student_Name);

//    @Query(value ="SELECT s from Student s where s.createdDate= :createdDate")         //getStudentByCreatedDate
//    Student getStudentByCreatedDate(@Param("createdDate") Date createdDate);

    @Query(value = "select * from Student where created_date like CONCAT (?1, '%') ", nativeQuery = true)      //getStudentByCreatedDate
    List<Student> getStudentByCreatedDate(String createdDate);
    @Query(value = "select * from Student where updated_date like CONCAT (?1, '%') ", nativeQuery = true)    //getStudentByUpdatedDate
    List<Student>  getStudentByUpdatedDate(String updatedDate);

}
