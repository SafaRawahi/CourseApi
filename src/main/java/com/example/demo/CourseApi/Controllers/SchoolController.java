package com.example.demo.CourseApi.Controllers;

import com.example.demo.CourseApi.Model.School;
import com.example.demo.CourseApi.Service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "school")
public class SchoolController {

    @Autowired
    SchoolService schoolService;

    //localhost:8080/school/getAll

    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public List<School> getAllSchools() {
        List<School> schools = new ArrayList<>();
        schools = schoolService.getAllSchools();
        return schools;
    }


    @RequestMapping(value = "getById", method = RequestMethod.GET)
    public School getSchoolById(@RequestParam Integer schoolId) {
        School school = schoolService.getSchoolById(schoolId);
        return school;
    }

    @RequestMapping(value = "getByName")
    public School getSchoolByName(@RequestParam String school_name) {
        School school = schoolService.getSchoolByName(school_name);
        return school;
    }

    @RequestMapping(value = "getAllSchoolByIsActive")
    public List<School> getAllActiveSchools() {
        List<School> activeSchoolsList = schoolService.getAllActiveSchools();
        return activeSchoolsList;
    }

//    @RequestMapping(value = "updateCreatedDateByUserInput")
//    public void setCreatedDateByUserInput(@RequestBody SchoolRequestForCreateDateUpdate data)
//            throws ParseException {
//        schoolService.setCreatedDateByUserInput(data.getDate(), data.getId());
//
//    }

    @RequestMapping(value = "getSchoolByNumberOfStudent", method = RequestMethod.POST)
    public List<School> getSchoolByNumberOfStudent(@RequestParam Integer numberOfStudent) {
        List<School> schoolList=schoolService.getSchoolByNumberOfStudent(numberOfStudent);
        return schoolList;
    }
}
