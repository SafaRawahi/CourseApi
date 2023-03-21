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

    public List<School> getAllSchools() {

        return schoolRepository.getAllSchools();
    }

    public School getSchoolById(Integer id) {
        School school = schoolRepository.getSchoolById(id);
        return school;
    }

    public School getSchoolByName(String school_name) {
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



    public School getSchoolByCreatedDate(Date createdDate) {           //getSchoolByCreatedDate

        School school = schoolRepository.getSchoolByCreatedDate(createdDate);
        return school;
    }


    public School getSchoolByUpdatedDate(Date updatedDate) {                      //get School By updated Date
        School school = schoolRepository.getSchoolByUpdatedDate(updatedDate);
        return school;
    }


//    public List<School> getLatestUpdatedSchool() {                    //getLatestUpdated
//        return schoolRepository.getSchoolLatestUpdatedData();
//    }



}


