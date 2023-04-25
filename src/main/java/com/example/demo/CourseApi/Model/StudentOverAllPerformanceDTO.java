package com.example.demo.CourseApi.Model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentOverAllPerformanceDTO {

    String studentName ;
    String studentRollNumber;
    Integer averageMark;

    public StudentOverAllPerformanceDTO(String studentName, String studentRollNumber, Integer averageMark) {
        this.studentName = studentName;
        this.studentRollNumber = studentRollNumber;
        this.averageMark = averageMark;
    }
}
