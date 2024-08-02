package com.hauhh.service.impl;

import com.hauhh.dao.StudentDAO;
import com.hauhh.entity.Student;
import com.hauhh.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("StudentService")
public class StudentServiceImpl implements StudentService {

    private final StudentDAO studentDAO;

    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public int addStudent(Student student) {
        return studentDAO.addStudent(student);
    }

    @Override
    public int updateStudent(Student student) {
        return studentDAO.updateStudent(student);
    }

    @Override
    public int deleteStudent(String sno) {
        return studentDAO.deleteStudent(sno);
    }

    @Override
    public List<Map<String, Object>> getAllStudent() {
        return studentDAO.getAllStudent();
    }

    @Override
    public Student getStudentBySNO(String sno) {
        return studentDAO.getStudentBySNO(sno);
    }
}
