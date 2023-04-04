package com.example.demo.CourseApi.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Data
public class MarkDTO {

    String courseName;
    Integer obtainedMarks;
    String grade;
    public MarkDTO(String courseName, Integer obtainedMarks, String grade) {
        this.courseName = courseName;
        this.obtainedMarks = obtainedMarks;
        this.grade = grade;
    }


}
