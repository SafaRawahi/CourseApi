package com.example.demo.CourseApi.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data

public class CourseDTO {
    String courseName;
    Integer obtainedMarks;
    String grade;
    Integer averageMark;

    public CourseDTO( Integer obtainedMarks, String grade) {

        this.obtainedMarks = obtainedMarks;
        this.grade = grade;

    }

    public CourseDTO(String courseName, Integer averageMark) {
        this.courseName = courseName;
        this.averageMark = averageMark;
    }
}
