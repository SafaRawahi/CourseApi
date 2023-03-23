package com.example.demo.CourseApi.Service;


import com.example.demo.CourseApi.Model.School;
import com.example.demo.CourseApi.Repository.SchoolRepository;
import com.example.demo.CourseApi.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SchoolService {

    @Autowired
    SchoolRepository schoolRepository;

    @Autowired
    StudentRepository studentRepository;

    public List<School> getAllSchools() {                     //getAllSchools

        return schoolRepository.getAllSchools();
    }

    public School getSchoolById(Integer id) {                         //getSchoolById
        School school = schoolRepository.getSchoolById(id);
        return school;
    }

    public School getSchoolByName(String school_name) {                      //   getSchoolByName
        School school = schoolRepository.getBySchoolName(school_name);
        return school;
    }

    public List<School> getAllActiveSchools() {
        return schoolRepository.getAllActiveSchools();
    }

    public List<School> getAllInActive() {
        return schoolRepository.getAllInActive();
    }


    public void setCreatedDateByUserInput(String stringData, Integer id) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date javaDate = formatter.parse(stringData);
        School school = schoolRepository.getSchoolById(id);
        school.setCreatedDate(javaDate);
        schoolRepository.save(school);
    }

    public List<School> getSchoolLatestRow() {                   //getSchoolLatestRow
        return schoolRepository.getSchoolLatestRow();

    }

    public List<School> getSchoolCreatedAfterDate(String created_date) throws ParseException{      //getSchoolCreatedAfterDate
        DateFormat format = new SimpleDateFormat("yyyy-MM-DD");
        Date date = format.parse(created_date);
        List<School> schoolList = schoolRepository.getSchoolCreatedAfterDate(date);
        return schoolList;

    }

    public List<School> getSchoolsByCreatedDate(String createdDate) {                     //getSchoolsByCreatedDate
        List<School> school = schoolRepository.getSchoolsByCreatedDate(createdDate);
        return school;
    }

    public List<School> getSchoolsByUpdatedDate(String updatedDate) {                   //getSchoolsByUpdatedDate
        List<School> school = schoolRepository.getSchoolsByUpdatedDate(updatedDate);
        return school;
    }


//    public List<School> getLatestUpdatedSchool() {                    //getLatestUpdated
//        return schoolRepository.getSchoolLatestUpdatedData();
//    }

//    public void deleteSchoolById(Integer id) {                     // Delete by id
//        School school = schoolRepository.getSchoolById(id);
//        school.setActive(false);
//        schoolRepository.save(school);
//    }


}


