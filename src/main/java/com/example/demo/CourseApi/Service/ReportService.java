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
import java.util.*;

@Service
public class ReportService {
    public static final String pathToReports = "C:\\Users\\user017\\Downloads\\reports";
    @Autowired
    private SchoolRepository schoolRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    MarkRepository markRepository;
    @Autowired
    CourseRepository courseRepository;


    public String generateReport() throws FileNotFoundException, JRException {
        List<School> schoolList = schoolRepository.getAllSchools();

        File file = ResourceUtils.getFile("classpath:School_Report.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(schoolList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "MyName");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\schools.pdf");
        return "Report generated : " + pathToReports + "\\schools.pdf";
    }

    public String generateStudentReport() throws FileNotFoundException, JRException {
        List<Student> studentList = studentRepository.getAllStudent();
        List<StudentDTO> studentDTOList = new ArrayList<>();

        for (Student studentlist : studentList) {
            String schoolName = studentlist.getSchool().getName();
            String studentName = studentlist.getName();
            String rollNumber = studentlist.getRollNumber();
            StudentDTO studentDTO = new StudentDTO(schoolName, studentName, rollNumber);
            studentDTOList.add(studentDTO);
        }
        File file = new File("C:\\Users\\user017\\IdeaProjects\\demo.CourseApi\\src\\main\\resources\\Student_Report.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(studentDTOList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "MyName");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\student.pdf");
        return "Report generated : " + pathToReports + "\\student.pdf";
    }


    public String generateMarksReport() throws FileNotFoundException, JRException {
        List<Mark> marksList = markRepository.getAllMarks();
        List<MarkDTO> markDTOList = new ArrayList<>();

        for (Mark marklist : marksList) {
            String courseName = marklist.getCourse().getName();
            Integer obtainedMarks = marklist.getObtainedMarks();
            String grad = marklist.getGrade();
            MarkDTO markDTO = new MarkDTO(courseName, obtainedMarks, grad);
            markDTOList.add(markDTO);
        }
        File file = new File("C:\\Users\\user017\\IdeaProjects\\demo.CourseApi\\src\\main\\resources\\Mark_Report.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(markDTOList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "MyName");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\Mark.pdf");
        return "Report generated : " + pathToReports + "\\Mark.pdf";
    }

    public String generateAverageMarkReport() throws JRException {
        List<Course> courseList = courseRepository.getAllCourse();
        List<CourseDTO> courseDTOList = new ArrayList<>();
        for (Course course : courseList) {
            String courseName = course.getName();
            Integer averageMark = markRepository.getAverageOfMarksByCourseName(courseName);
            courseDTOList.add(new CourseDTO(courseName, averageMark));

        }

        File file = new File("C:\\Users\\user017\\IdeaProjects\\demo.CourseApi\\src\\main\\resources\\Course_Report.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(courseDTOList);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("CreatedBy", "MyName");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\Course.pdf");
        return "Report generated : " + pathToReports + "\\Course.pdf";


    }

    public String generateTopPerformingStudentsReport() throws JRException {
        List<School> schoolList = schoolRepository.getAllSchools();
        Map<School, Student> schoolStudentMap = new HashMap<>();
        List<TopPerformingStudentsDTO> topPerformingStudentDTOList = new ArrayList<>();


        for (School school : schoolList) {
            List<Student> studentList = studentRepository.getStudentsBySchoolId(school.getId());
            Integer highestMark = 0;
            Student studentWithHighestMarks = new Student();
            for (Student student : studentList) {
                Integer studentId = student.getId();
                Integer studentTotalMark = markRepository.getSumOfMarkByStudentId(studentId);
                if (studentTotalMark != null && studentTotalMark > highestMark) {
                    highestMark = studentTotalMark;
                    studentWithHighestMarks = student;
                }
            }

            schoolStudentMap.put(school, studentWithHighestMarks);
            topPerformingStudentDTOList.add(new TopPerformingStudentsDTO(school.getName(), studentWithHighestMarks.getName()));
        }
        File file = new File("C:\\Users\\user017\\IdeaProjects\\demo.CourseApi\\src\\main\\resources\\TopPerformingStudents.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(topPerformingStudentDTOList);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("CreatedBy", "MyName");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\TopPerformingStudents.pdf");
        return "Report generated : " + pathToReports + "\\TopPerformingStudents.pdf";
    }

    public String generateOverAllStudentPerformance() throws Exception {
    List<Student> studentList= studentRepository.getAllStudent();
    List<StudentOverAllPerformanceDTO> studentOverAllPerformanceDTOList=new ArrayList<>();
    for (Student student : studentList){
        String studentName = student.getName();
        String studentRollNumber = student.getRollNumber();
        Integer averageMark = markRepository.getAvgOfMarksByStudentId(student.getId());
        StudentOverAllPerformanceDTO studentOverAllPerformanceDTO = new StudentOverAllPerformanceDTO(studentName,studentRollNumber,averageMark);
        studentOverAllPerformanceDTOList.add(studentOverAllPerformanceDTO);
    }

        File file = new File("C:\\Users\\user017\\IdeaProjects\\demo.CourseApi\\src\\main\\resources\\OverAllStudentPerformance.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(studentOverAllPerformanceDTOList);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("CreatedBy", "MyName");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\OverAllStudentPerformance.pdf");
        return "Report generated : " + pathToReports + "\\OverAllStudentPerformance.pdf";
    }



}
