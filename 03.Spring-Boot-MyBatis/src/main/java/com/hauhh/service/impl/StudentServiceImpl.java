package com.hauhh.service.impl;

import com.hauhh.entity.Student;
import com.hauhh.mapper.StudentMapper;
import com.hauhh.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentMapper studentMapper;

    @Autowired
    public StudentServiceImpl(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public int addStudent(Student student) {
        return this.studentMapper.add(student);
    }

    @Override
    public int updateStudent(Student student) {
        return this.studentMapper.update(student);
    }

    @Override
    public int deleteStudentBySNO(String sno) {
        return this.studentMapper.deleteByID(sno);
    }

    @Override
    public Student getStudentBySNO(String sno) {
        return this.studentMapper.queryStudentByID(sno);
    }
}
