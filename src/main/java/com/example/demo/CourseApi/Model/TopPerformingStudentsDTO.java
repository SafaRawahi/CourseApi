package com.example.demo.CourseApi.Model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopPerformingStudentsDTO {
    String studentName ;
    String schoolName;

    public TopPerformingStudentsDTO(String studentName, String schoolName) {
        this.studentName = studentName;
        this.schoolName = schoolName;
    }
}
