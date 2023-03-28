package com.example.demo.CourseApi.Controllers;

import com.example.demo.CourseApi.Model.School;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

public class SchoolControllerTest {
    @Autowired
    SchoolController schoolController;

    @Test
    void getAllSchools() {
        List<School> getAllSchools = schoolController.getAllInActive();
        assertNotNull(getAllSchools);
    }

    @Test
    void getSchoolById() throws Exception {
        String school_name = schoolController.getSchoolById(1).getName();
        assertEquals("AA", school_name);
    }


    @Test
    void getSchoolByIdInvalid()throws  Exception{
        School schoolTest=schoolController.getSchoolById(0);
        assertEquals(null,schoolTest);

    }


    @Test
    void getSchoolByIdValid() throws Exception {
        String school_name = schoolController.getSchoolById(3).getName();
        assertEquals("UTS", school_name);
    }

//    @Test
//    void getSchoolByNameInvalid1() throws Exception {
//        School schoolTest;
//        schoolTest = schoolController.getSchoolByName("java");
//        //int id = schoolTest.getId();
//        assertEquals(null, schoolTest);
//    }

    @Test
    void getSchoolByNameInvalid2() throws Exception {
        School schoolTest;
        schoolTest = schoolController.getSchoolByName("MM");
       // int id = schoolTest.getId();
        assertEquals(null, schoolTest);
    }

    @Test
    void getSchoolByNamevalid1() throws Exception {
        School schoolTest;
        schoolTest = schoolController.getSchoolByName("AA");
       // int id = schoolTest.getId();
        assertEquals(null, schoolTest);
    }

    @Test
    void getSchoolByNamevalid2() throws Exception {
        School schoolTest;
        schoolTest = schoolController.getSchoolByName("java");
        int id = schoolTest.getId();
        assertEquals(2, id);
    }

    @Test
    void getAllActiveSchools() {
        List<School> activeSchools = schoolController.getAllActiveSchools();
        assertNotNull(activeSchools);

    }

//    @Test
//    void getAllActiveSchools_Invalid() {
//        schoolController.getAllActiveSchools();
//
//        // Call the function
//        List<School> activeSchools = schoolController.getAllActiveSchools();
//
//        // Verify that the function returns an empty list or null
//        assertNotNull(activeSchools);
//        assertTrue(activeSchools.isEmpty());
//    }


    @Test
    void getAllInActive() {
        List<School> inactiveSchools = schoolController.getAllInActive();
        assertNotNull(inactiveSchools);

    }
//    @Test  //Invalid
//    void getAllInActive_Invalid() {
//        schoolController.getAllActiveSchools();
//
//        // Call the function
//        List<School> inActiveSchools = schoolController.getAllInActive();
//
//        // Verify that the function returns an empty list or null
//        assertNotNull(inActiveSchools);
//        assertTrue(inActiveSchools.isEmpty());
//}

    @Test    //Invalid
    void testGetActiveSchoolByName_Invalid() {
        // Create a test school object
        School testSchool = new School();
        testSchool.setName("java");
        testSchool.setActive(true);
        // Add the test school to the database
//        schoolController.addSchool(testSchool);

        // Call the getAllActiveSchools() method to get a list of all active schools
        List<School> activeSchools = schoolController.getAllActiveSchools();

        // Verify that the list contains the test school we just added
        boolean containsTestSchool = activeSchools.stream().anyMatch(school -> school.getName().equals(testSchool.getName()));
        assertTrue(containsTestSchool);
    }
    @Test    //Invalid
    void testGetActiveSchoolByName_Valid() {
        // Create a test school object
        School testSchool = new School();
        testSchool.setName("ASQ");
        testSchool.setActive(true);
        // Add the test school to the database
//        schoolController.addSchool(testSchool);

        // Call the getAllActiveSchools() method to get a list of all active schools
        List<School> activeSchools = schoolController.getAllActiveSchools();

        // Verify that the list contains the test school we just added
        boolean containsTestSchool = activeSchools.stream().anyMatch(school -> school.getName().equals(testSchool.getName()));
        assertTrue(containsTestSchool);
    }
    @Test
    void getSchoolLatestRow() {

    }

    @Test
    void getSchoolCreatedAfterDate() {
    }

    @Test
    void getSchoolsByCreatedDate() {



    }

    @Test
    void getSchoolsByUpdatedDate() {
    }

    @Test
    void getLatestUpdatedDate() {
    }

    @Test
    void deleteSchoolById() {
    }

    @Test
    void deleteAllSchools() {
    }

    @Test
    void deleteAllSchoolsCreatedAfterDate() {
    }

    @Test
    void deleteSchoolBySchoolName() {
    }

    @Test
    void deleteSchoolsByCreatedDate() {
    }

    @Test
    void deleteSchoolsByUpdatedDate() {
    }

    @Test
    void createSchool() {
    }
}