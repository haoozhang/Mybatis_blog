package com.zhao.mapper;

import com.zhao.pojo.Teacher;

public interface TeacherMapper {

    // 根据 id 查询老师即对应学生的信息
    Teacher getTeacher1(int id);

    // 根据 id 查询老师即对应学生的信息
    Teacher getTeacher2(int id);
}
