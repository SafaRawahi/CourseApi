package com.example.demo.CourseApi.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@Data
public class StudentDTO {

    String schoolName;

    String studentName;

    String rollNumber;

    public StudentDTO(String schoolName, String studentName, String rollNumber) {
        this.schoolName = schoolName;
        this.studentName = studentName;
        this.rollNumber = rollNumber;
    }
}
