package com.zhao.mapper;

import com.zhao.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    // 根据 id 查询用户
    User selectUserById(int id);

    // 分页查询用户
    List<User> selectUserLimit(Map<String, Integer> map);

}
