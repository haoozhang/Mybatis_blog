package com.zhao.mapper;

import com.zhao.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    // 查询所有用户
    @Select("select id, name, pwd as password from user")
    public List<User> selectAllUsers();

    // 根据 id 查询用户
    @Select("select id, name, pwd as password from user where id = #{id}")
    User selectUserById(int id);

    // 增加一个用户
    @Insert("insert into user (id, name, pwd) values (#{id}, #{name}, #{password})")
    int addUser(User user);

    // 修改一个用户
    @Update("update user set name = #{name}, pwd = #{password} where id = #{id}")
    int updateUser(User user);

    // 删除一个用户
    @Delete("delete from user where id = #{id}")
    int deleteUserById(int id);

}
