package com.example.demo.CourseApi.Service;


import com.example.demo.CourseApi.Model.Mark;
import com.example.demo.CourseApi.Repository.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MarkService {
    @Autowired
    MarkRepository markRepository;
    @Autowired
    CourseService courseService;


    public List<Mark> getAllMarks() {
        return markRepository.getAllMarks();
    }
}
