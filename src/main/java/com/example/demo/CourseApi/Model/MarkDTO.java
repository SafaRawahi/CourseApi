package com.example.demo.CourseApi.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Data       //no need to write function or construction , to string
@AllArgsConstructor
public class MarkDTO {

    String courseName;
    Integer obtainedMarks;
    String grade;



//    public MarkDTO(String courseName, Integer obtainedMarks, String grade) {
//        this.courseName = courseName;
//        this.obtainedMarks = obtainedMarks;
//        this.grade = grade;
//    }


}
