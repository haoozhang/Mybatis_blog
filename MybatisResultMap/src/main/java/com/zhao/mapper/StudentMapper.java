package com.zhao.mapper;

import com.zhao.pojo.Student;

import java.util.List;

public interface StudentMapper {

    // 获取所有学生及对应老师的信息
    List<Student> getAllStudents1();

    // 获取所有学生及对应老师的信息
    List<Student> getAllStudents2();
}
