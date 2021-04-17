package com.zhao.mapper;

import com.zhao.pojo.User;
import com.zhao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest {

    @Test
    public void testSelectAllUsers() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> userList = mapper.selectAllUsers();
        for (User user : userList) {
            System.out.println(user);
        }
        session.close();
    }

    @Test
    public void testSelectUserById() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectUserById(1);
        System.out.println(user);
        session.close();
    }

    @Test
    public void testSelectUserByNP() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectUserByNP("张三", "123456");
        System.out.println(user);
        session.close();
    }

    @Test
    public void testSelectUserByNP2() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<>();
        map.put("name2", "张三");
        map.put("pwd2", "123456");
        User user = mapper.selectUserByNP2(map);
        System.out.println(user);
        session.close();
    }

    @Test
    public void testAddUser() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User(5,"赵六","zxcvbn");
        int i = mapper.addUser(user);
        System.out.println(i);
        session.commit(); // 提交事务！不写的话不会提交到数据库
        session.close();
    }

    @Test
    public void testUpdateUser() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectUserById(5);
        user.setPwd("qwerty");
        int i = mapper.updateUser(user);
        System.out.println(i);
        session.commit(); // 提交事务！不写的话不会提交到数据库
        session.close();
    }

    @Test
    public void testDeleteUser() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        int i = mapper.deleteUserById(5);
        System.out.println(i);
        session.commit(); // 提交事务！不写的话不会提交到数据库
        session.close();
    }

    @Test
    public void testSelectLike() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> userList = mapper.selectLikeUsers("%王%"); // 注意用通配符
        for (User user : userList) {
            System.out.println(user);
        }
        session.close();
    }
}
