package com.zhao.mapper;

import com.zhao.pojo.User;
import com.zhao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {

    @Test
    public void testSelectUserById() {
        SqlSession session = MybatisUtils.getSession();
        SqlSession session2 = MybatisUtils.getSession();

        UserMapper mapper = session.getMapper(UserMapper.class);
        UserMapper mapper2 = session2.getMapper(UserMapper.class);

        User user = mapper.selectUserById(1);
        System.out.println(user);
        session.close();

        User user2 = mapper2.selectUserById(1);
        System.out.println(user2);
        System.out.println(user==user2);

        session2.close();
    }

}
