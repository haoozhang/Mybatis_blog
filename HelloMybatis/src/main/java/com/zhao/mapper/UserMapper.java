package com.zhao.mapper;

import com.zhao.pojo.User;

import java.util.List;

public interface UserMapper {

    // 查询所有用户
    List<User> selectAllUsers();

}
