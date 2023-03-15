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

    public School getSchoolByName(String schoolName) {
        School school = schoolRepository.getBySchoolName(schoolName);
        return school;
    }

    public List<School> getAllActiveSchools() {

        return schoolRepository.getAllActiveSchools();
    }

    public void setCreatedDateByUserInput(String stringData, Integer id) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date javaDate = formatter.parse(stringData);
        School school = schoolRepository.getSchoolById(id);
        school.setCreatedDate(javaDate);
        schoolRepository.save(school);
    }

    public List<School> getSchoolByNumberOfStudent(Integer numberOfStudent ) {
        List<Integer> typesOfSchoolIdsInStudent = studentRepository.getDistinctSchoolIdsFromStudent();
        //{1,2 }

        List<Integer> schoolIdsThatUserWants = new ArrayList<>();

        for (Integer idOfSchool : typesOfSchoolIdsInStudent) {
            Integer count = studentRepository.getCountOfStudentsBySchoolId(idOfSchool);
            if (numberOfStudent == count) {
                schoolIdsThatUserWants.add(idOfSchool);
            }
        }

        List<School> schoolThatUserWasLookingFor = schoolRepository.findAllById(schoolIdsThatUserWants);
        return schoolThatUserWasLookingFor;
    }

}
