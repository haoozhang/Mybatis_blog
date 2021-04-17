package com.zhao.mapper;

import com.zhao.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    // 查询所有用户
    List<User> selectAllUsers();

    // 根据 id 查询用户
    User selectUserById(int id);

    // 根据用户名和密码查询用户
    // 方式一：@Param，SQL 语句直接取其中的值
    User selectUserByNP(@Param("name2") String name1, @Param("pwd2") String pwd1);
    // 方式二：使用 Map，在 SQL 语句中注明参数类型
    User selectUserByNP2(Map<String, Object> map);

    // 增加一个用户
    int addUser(User user);

    // 修改一个用户
    int updateUser(User user);

    // 删除一个用户
    int deleteUserById(int id);

    // Like 模糊查询
    List<User> selectLikeUsers(String pattern);

}
