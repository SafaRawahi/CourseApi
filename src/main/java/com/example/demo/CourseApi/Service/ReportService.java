package com.example.demo.CourseApi.Service;

import com.example.demo.CourseApi.Model.*;
import com.example.demo.CourseApi.Repository.CourseRepository;
import com.example.demo.CourseApi.Repository.MarkRepository;
import com.example.demo.CourseApi.Repository.SchoolRepository;
import com.example.demo.CourseApi.Repository.StudentRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {
    public static final String pathToReports = "C:\\Users\\user017\\Downloads\\reports";
    @Autowired
    private SchoolRepository schoolRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    MarkRepository markRepository;
    public String generateReport() throws FileNotFoundException, JRException {
        List<School> schoolList = schoolRepository.getAllSchools();

        File file = ResourceUtils.getFile("classpath:School_Report.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(schoolList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "MyName");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,paramters , dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports+"\\schools.pdf");
        return "Report generated : " + pathToReports+"\\schools.pdf";
    }

    public String generateStudentReport() throws FileNotFoundException, JRException {
        List<Student> studentList = studentRepository.getAllStudent();
        List<StudentDTO> studentDTOList =new ArrayList<>();

        for (Student studentlist :studentList)
        {
            String schoolName= studentlist.getSchool().getName();
            String studentName= studentlist.getName();
            String rollNumber = studentlist.getRollNumber();
            StudentDTO studentDTO=new StudentDTO(schoolName,studentName,rollNumber);
            studentDTOList.add(studentDTO);
        }
        File file = new File("C:\\Users\\user017\\IdeaProjects\\demo.CourseApi\\src\\main\\resources\\Student_Report.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(studentDTOList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "MyName");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,paramters , dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports+"\\student.pdf");
        return "Report generated : " + pathToReports+"\\student.pdf";
    }


    public String generateMarksReport() throws FileNotFoundException, JRException {
        List<Mark> marksList = markRepository.getAllMarks();
        List<MarkDTO> markDTOList =new ArrayList<>();

        for (Mark marklist : marksList)
        {
            String courseName= marklist.getCourse().getName();
            Integer obtainedMarks= marklist.getObtainedMarks();
            String grad = marklist.getGrade();
            MarkDTO markDTO=new MarkDTO(courseName,obtainedMarks,grad);
            markDTOList.add(markDTO);
        }
        File file = new File("C:\\Users\\user017\\IdeaProjects\\demo.CourseApi\\src\\main\\resources\\Mark_Report.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(markDTOList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "MyName");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,paramters , dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports+"\\Mark.pdf");
        return "Report generated : " + pathToReports+"\\Mark.pdf";
    }





}
