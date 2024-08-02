package com.hauhh.dao.impl;

import com.hauhh.dao.StudentDAO;
import com.hauhh.entity.Student;
import com.hauhh.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository("StudentDAO")
public class StudentDAOImpl implements StudentDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addStudent(Student student) {
        String sql = "INSERT INTO Student(sno, sname, ssex) VALUES(:sno, :name, :sex)";
        NamedParameterJdbcTemplate npjt = new NamedParameterJdbcTemplate(Objects.requireNonNull(this.jdbcTemplate.getDataSource()));
        return npjt.update(sql, new BeanPropertySqlParameterSource(student));
    }

    @Override
    public int updateStudent(Student student) {
        String sql = "UPDATE STUDENT SET sname = ?, ssex = ? WHERE sno = ?";
        Object[] args = {student.getName(), student.getSex(), student.getSno()};
        int[] argTypes = {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
        return this.jdbcTemplate.update(sql, args, argTypes);
    }

    @Override
    public int deleteStudent(String sno) {
        String sql = "DELETE FROM STUDENT WHERE sno = ?";
        Object[] args = {sno};
        int[] argTypes = {Types.VARCHAR};
        return this.jdbcTemplate.update(sql, args, argTypes);
    }

    @Override
    public List<Map<String, Object>> getAllStudent() {
        String sql = "SELECT * FROM STUDENT";
        return this.jdbcTemplate.queryForList(sql);
    }

    @Override
    public Student getStudentBySNO(String sno) {
        String sql = "SELECT * FROM STUDENT WHERE sno = ?";
        Object[] args = {sno};
        int[] argTypes = {Types.VARCHAR};
        List<Student> studentList = this.jdbcTemplate.query(sql, args, argTypes, new StudentMapper());
        if(!studentList.isEmpty()){
            return studentList.get(0);
        } else {
            return null;
        }
    }
}
