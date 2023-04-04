package com.example.demo.CourseApi.Controllers;

import com.example.demo.CourseApi.Model.School;
import com.example.demo.CourseApi.Service.SchoolService;
import com.example.demo.CourseApi.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "school")
public class SchoolController {

    @Autowired
    SchoolService schoolService;

    //localhost:8080/school/getAll
    @Autowired
    SlackClient slackClient;

    @RequestMapping(value = "getAll", method = RequestMethod.GET)       //getAll
    public List<School> getAllSchools() {
        List<School> schools = new ArrayList<>();
        schools = schoolService.getAllSchools();
        slackClient.sendMessage("hello");
        return schools;
    }



    @RequestMapping(value = "getById", method = RequestMethod.GET)     //getById
    public School getSchoolById(@RequestParam Integer schoolId) {
        School school = schoolService.getSchoolById(schoolId);
        return school;
    }

    @RequestMapping(value = "getByName")
    public School getSchoolByName(@RequestParam String school_name) {         //getByName
        School school = schoolService.getSchoolByName(school_name);
        return school;
    }

    @RequestMapping(value = "getAllSchoolByIsActive")
    public List<School> getAllActiveSchools() {                                  //getAllSchoolByIsActive
        List<School> activeSchoolsList = schoolService.getAllActiveSchools();
        return activeSchoolsList;
    }

    @RequestMapping(value = "getAllInActive")
    public List<School> getAllInActive() {                                    //getAllInActive
        List<School> InActiveSchoolsList = schoolService.getAllInActive();
        return InActiveSchoolsList;
    }

    @RequestMapping(value = "getSchoolLatestRow")                            //getSchoolLatestRow
    public List<School> getSchoolLatestRow() {
        List<School> schoolLatestRowList = schoolService.getSchoolLatestRow();
        return schoolLatestRowList;
    }


    @RequestMapping(value = "getSchoolCreatedAfterDate", method = RequestMethod.GET)
    public List<School> getSchoolCreatedAfterDate(@RequestParam String created_date) throws ParseException {     //getSchoolCreatedAfterDate
        List<School> schoolList = new ArrayList<>();
        schoolList = schoolService.getSchoolCreatedAfterDate(created_date);
        return schoolList;
    }

    @RequestMapping(value = "getSchoolsByCreatedDate", method = RequestMethod.GET)                      //getSchoolByCreatedDate
    public List<School> getSchoolsByCreatedDate(String createdDate) throws ParseException {
        List<School> school = schoolService.getSchoolsByCreatedDate(createdDate);
        return school;
    }

    @RequestMapping(value = "getSchoolsByUpdatedDate", method = RequestMethod.GET)                  //getSchoolsByUpdatedDate
    public List<School> getSchoolsByUpdatedDate(String updatedDate) throws ParseException {
        List<School> school = schoolService.getSchoolsByUpdatedDate(updatedDate);
        return school;
    }



@RequestMapping(value = "getLatestUpdatedDate", method = RequestMethod.GET)              // getLatestUpdatedDate
public School getLatestUpdatedDate() {
    School school = schoolService.getLatestUpdatedDate();
    return school;
}

    @RequestMapping(value = "deleteSchoolById", method = RequestMethod.POST)           //deleteSchoolById
    public String deleteSchoolById(@RequestParam Integer schoolId) {
        schoolService.deleteSchoolById(schoolId);
        return"Recored updated successfully";

    }

    @RequestMapping(value = "deleteAll", method = RequestMethod.POST)                     //deleteAllSchool
    public String deleteAllSchools() {
        schoolService.deleteAllSchool();
        return"Recored updated successfully";
    }

    @RequestMapping(value = "deleteAllSchoolsCreatedAfterDate", method = RequestMethod.POST)                          //deleteAllSchoolsCreatedAfterDate
    public String deleteAllSchoolsCreatedAfterDate(@RequestParam String createdDate)throws ParseException{
        schoolService.deleteAllSchoolsCreatedAfterDate(createdDate);
        return"Recored updated successfully";
    }
    @RequestMapping(value = "deleteSchoolBySchoolName",method = RequestMethod.GET)             //deleteSchoolBySchoolName
    public String deleteSchoolBySchoolName(@RequestParam String schoolName) {
        schoolService.deleteSchoolBySchoolName(schoolName);
        return"Recored updated successfully";
    }
    @RequestMapping(value = "deleteSchoolsByCreatedDate", method = RequestMethod.POST)                //deleteSchoolsByCreatedDate
    public String deleteSchoolsByCreatedDate(@RequestParam String createdDate) {
        schoolService.deleteSchoolsByCreatedDate(createdDate);
        return"Recored updated successfully";
    }

    @RequestMapping(value = "deleteSchoolsByUpdatedDate", method = RequestMethod.POST)               //deleteSchoolsByUpdatedDate
    public String deleteSchoolsByUpdatedDate(@RequestParam String updatedDate) {
        schoolService.deleteSchoolsByUpdatedDate(updatedDate);
        return"Recored updated successfully";
    }


    @RequestMapping(value = "createSchool", method = RequestMethod.POST)                             //createSchool
    public List<School> createSchool(@RequestParam String schoolName) {
        List<School> schools = new ArrayList<>();
        schools = schoolService.getAllSchools();
        schoolService.createSchool(schoolName);

        return schools;
    }

}