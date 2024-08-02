package com.hauhh.controller;

import com.hauhh.entity.Student;
import com.hauhh.service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "/queryStudent", method = RequestMethod.GET)
    public Student getStudentBySNO(String sno) {
        return studentService.getStudentBySNO(sno);
    }

    @RequestMapping(value = "/getAllStudent", method = RequestMethod.GET)
    public List<Map<String, Object>> queryAllStudent() {
        return this.studentService.getAllStudent();
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.GET)
    public int saveStudent(String sno,String name,String sex) {
        Student student = new Student();
        student.setSno(sno);
        student.setName(name);
        student.setSex(sex);
        return this.studentService.addStudent(student);
    }

    @RequestMapping(value = "/deleteStudent", method = RequestMethod.GET)
    public int deleteStudentBySno(String sno) {
        return this.studentService.deleteStudent(sno);
    }

}
