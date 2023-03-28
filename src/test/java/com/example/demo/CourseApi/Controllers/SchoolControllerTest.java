package com.example.demo.CourseApi.Controllers;

import com.example.demo.CourseApi.Model.School;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

public class SchoolControllerTest {
@Autowired
SchoolController schoolController;

    @Test
    void getAllSchools(){
    }

    @Test
    void getSchoolById() throws Exception {
        String school_name = schoolController.getSchoolById(1).getName();
        assertEquals("AA", school_name);
    }

    @Test
    void getSchoolByIdInvalid() throws Exception {
    String school_name = schoolController.getSchoolById(2).getName();
    assertEquals("ASQ", school_name);
}
    @Test
    void getSchoolByIdInvalidResult() throws Exception {
        String school_name = schoolController.getSchoolById(2).getName();
        assertEquals("Muscat", school_name);
    }
    @Test
    void getSchoolByIdValid() throws Exception {
        String school_name = schoolController.getSchoolById(3).getName();
        assertEquals("UTS", school_name);
    }

    @Test
    void getSchoolByNameInvalid1() throws Exception {
        School schoolTest;
        schoolTest= schoolController.getSchoolByName("java");
        int id=schoolTest.getId();
        assertEquals(4,id);
    }
    @Test
    void getSchoolByNameInvalid2() throws Exception {
        School schoolTest;
        schoolTest= schoolController.getSchoolByName("UTS");
        int id=schoolTest.getId();
        assertEquals(1,id);
    }
    @Test
    void getSchoolByNamevalid1() throws Exception {
        School schoolTest;
        schoolTest= schoolController.getSchoolByName("AA");
        int id=schoolTest.getId();
        assertEquals(1,id);
    }

    @Test
    void getSchoolByNamevalid2() throws Exception {
        School schoolTest;
        schoolTest= schoolController.getSchoolByName("java");
        int id=schoolTest.getId();
        assertEquals(2,id);
    }

    @Test
    void getAllActiveSchools() {
        List<School> activeSchools = schoolController.getAllActiveSchools();
        assertNotNull(activeSchools);
        assertTrue(activeSchools.size() > 0);

    }

    @Test
    void getAllInActive() {
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