package com.example.demo.CourseApi.Repository;

import com.example.demo.CourseApi.Model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
@Repository
public interface SchoolRepository extends JpaRepository<School, Integer> {

    @Query(value = "SELECT s from School s")                     //getAllSchools
    List<School> getAllSchools();

    @Query(value = "SELECT s from School s where s.id = :schoolId")          //getSchoolById
    School getSchoolById(@Param("schoolId") Integer id);

    @Query(value = "SELECT s from School s " +
            "WHERE s.name = :school_name")                                //getBySchoolName
    School getBySchoolName(@Param("school_name") String school_name);

    @Query(value = "SELECT s from School s where s.isActive = true")   //getAllActiveSchools
    List<School> getAllActiveSchools();

    @Query(value = "SELECT s from School s where s.isActive = false")    //getAllInActive
    List<School> getAllInActive();

    @Query(value = "SELECT s from School s where s.id = (SELECT Max(s.id) FROM School s)")    //getSchoolLatestRow
    List<School> getSchoolLatestRow();

    @Query(value="SELECT s From School s Where s.createdDate>= :created_date")                //getSchoolCreatedAfterDate
    List<School>  getSchoolCreatedAfterDate(@Param("created_date") Date created_date);


    @Query(value = "select * from school where created_date like CONCAT (?1, '%') ", nativeQuery = true)      //getSchoolByCreatedDate
    List<School> getSchoolsByCreatedDate(String createdDate);


    @Query(value = "select * from school where updated_date like CONCAT (?1, '%') ", nativeQuery = true)    //getSchoolsByUpdatedDate
    List<School> getSchoolsByUpdatedDate(String updatedDate);



    @Query(value = " select s from School s where s.updatedDate = (select Max(s.updatedDate) from School s)")      //getLatestUpdatedDate
    School getLatestUpdatedDate();

    @Modifying
    @Transactional
    @Query(value = "Update School s Set s.isActive =false")
    void deleteAllSchoolsByIsActiveFalse();

}


