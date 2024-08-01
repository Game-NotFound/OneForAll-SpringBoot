package com.hauhh.controller;

import com.hauhh.entity.Student;
import com.hauhh.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/queryStudent")
    public Student queryStudentByID(@RequestParam("sno") String sno){
        return this.studentService.getStudentBySNO(sno);
    }



}
