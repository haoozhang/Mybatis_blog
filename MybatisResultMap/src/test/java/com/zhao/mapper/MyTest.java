package com.zhao.mapper;

import com.zhao.pojo.Student;
import com.zhao.pojo.Teacher;
import com.zhao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {

    @Test
    public void testGetAllStudents1() {
        SqlSession session = MybatisUtils.getSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> studentList = mapper.getAllStudents1();
        for (Student student : studentList) {
            System.out.println(student);
        }
        session.close();
    }

    @Test
    public void testGetAllStudents2() {
        SqlSession session = MybatisUtils.getSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> studentList = mapper.getAllStudents2();
        for (Student student : studentList) {
            System.out.println(student);
        }
        session.close();
    }

    @Test
    public void testGetTeacher1() {
        SqlSession session = MybatisUtils.getSession();
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher1(1);
        System.out.println(teacher);
        session.close();
    }

    @Test
    public void testGetTeacher2() {
        SqlSession session = MybatisUtils.getSession();
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher2(1);
        System.out.println(teacher);
        session.close();
    }
}
