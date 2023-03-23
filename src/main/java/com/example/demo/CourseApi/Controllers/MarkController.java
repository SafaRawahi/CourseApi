package com.example.demo.CourseApi.Controllers;


import com.example.demo.CourseApi.Model.Mark;
import com.example.demo.CourseApi.Service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "mark")
public class MarkController {
    @Autowired
    MarkService markService;

    @RequestMapping(value = "getAll", method = RequestMethod.GET)     //getAllMarks
    public List<Mark> getAllMarks() {
        List<Mark> marks = new ArrayList<>();
        marks = markService.getAllMarks();
        return marks;
    }

    @RequestMapping(value = "getById", method = RequestMethod.GET)              //getMarkById
    public Mark getMarkById(@RequestParam Integer markId) {
        Mark mark = markService.getMarkById(markId);
        return mark;


    }
}