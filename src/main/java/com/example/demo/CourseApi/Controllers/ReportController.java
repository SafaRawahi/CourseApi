package com.example.demo.CourseApi.Controllers;


import com.example.demo.CourseApi.Service.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
@RequestMapping(value = "report")
public class ReportController {
    @Autowired
    ReportService reportService;
    @RequestMapping(value = "schoolReport")
    public String generateSchoolsReport() throws JRException, FileNotFoundException {
        return reportService.generateReport();
    }
    @RequestMapping(value = "studentReport", method = RequestMethod.GET)
    public void  generateStudentReport() throws JRException, FileNotFoundException {
         reportService.generateStudentReport();
    }
    @RequestMapping(value = "markReport", method = RequestMethod.GET)
    public void  generateMarksReport() throws JRException, FileNotFoundException {
        reportService.generateMarksReport();
    }
}
