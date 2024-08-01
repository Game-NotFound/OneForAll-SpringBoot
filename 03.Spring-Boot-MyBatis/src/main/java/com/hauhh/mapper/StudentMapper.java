package com.hauhh.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import com.hauhh.entity.Student;

@Component
@Mapper
public interface StudentMapper {

	@Insert("INSERT INTO student(sno, sname, ssex) values(#{sno},#{name},#{sex})")
	int add(Student student);
	
	@Update("update student set sname=#{name}, ssex=#{sex} WHERE sno=#{sno}")
	int update(Student student);

	@Delete("DELETE FROM Student WHERE sno=#{sno}")
	int deleteByID(String sno);

	@Select("SELECT * FROM Student WHERE sno=#{sno}")
	@Results({
			@Result(property = "sno", column = "sno", javaType = String.class),
			@Result(property = "name", column = "sname", javaType = String.class),
			@Result(property = "sex", column = "ssex", javaType = String.class)
	})
	Student queryStudentByID(String sno);
	
}
