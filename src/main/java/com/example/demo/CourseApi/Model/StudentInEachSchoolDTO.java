package com.example.demo.CourseApi.Model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class StudentInEachSchoolDTO {
    String schoolName;

    public StudentInEachSchoolDTO(String schoolName, Integer totalNumberOfStudents) {
        this.schoolName = schoolName;
        this.totalNumberOfStudents = totalNumberOfStudents;
    }

    Integer totalNumberOfStudents;
}
