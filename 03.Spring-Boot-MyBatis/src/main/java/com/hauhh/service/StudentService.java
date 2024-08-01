package com.hauhh.service;

import com.hauhh.entity.Student;

public interface StudentService {

    int addStudent(Student student);

    int updateStudent(Student student);

    int deleteStudentBySNO(String sno);

    Student getStudentBySNO(String sno);

}
