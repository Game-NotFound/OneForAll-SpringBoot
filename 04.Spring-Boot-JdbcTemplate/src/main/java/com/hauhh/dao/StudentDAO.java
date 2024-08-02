package com.hauhh.dao;

import com.hauhh.entity.Student;

import java.util.List;
import java.util.Map;

public interface StudentDAO {

    int addStudent(Student student);
    int updateStudent(Student student);
    int deleteStudent(String sno);
    List<Map<String, Object>> getAllStudent();
    Student getStudentBySNO(String sno);

}
