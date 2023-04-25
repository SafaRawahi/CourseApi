package com.example.demo.CourseApi.Model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter

public class CourseWithGradesDTO {
    String courseName;
    String grade;

    public CourseWithGradesDTO(String courseName, String grade, Integer countOfMarks) {
        this.courseName = courseName;
        this.grade = grade;
        this.countOfMarks = countOfMarks;
    }

    Integer countOfMarks;
}
