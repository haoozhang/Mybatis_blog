package com.zhao.mapper;

import com.zhao.mapper.UserMapper;
import com.zhao.pojo.User;
import com.zhao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {

    @Test
    public void testSelectAllUsers() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> userList = mapper.selectAllUsers();
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
