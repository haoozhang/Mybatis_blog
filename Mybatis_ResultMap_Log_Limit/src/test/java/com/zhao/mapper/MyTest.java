package com.zhao.mapper;

import com.zhao.pojo.User;
import com.zhao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MyTest {

    @Test
    public void testSelectUserById() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectUserById(1);
        System.out.println(user);
        session.close();
    }

    static Logger logger = Logger.getLogger(MyTest.class);

    @Test
    public void testLog4j() {
        logger.info("info：进入testLog4j方法");
        logger.debug("debug：进入testLog4j方法");
        logger.error("error: 进入testLog4j方法");
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectUserById(1);
        System.out.println(user);
        session.close();
    }

    @Test
    public void testSelectUserLimit() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        Map<String, Integer> map = new HashMap<>();
        map.put("startIndex", 1);
        map.put("pageSize", 2);
        List<User> userList = mapper.selectUserLimit(map);
        for (User user : userList) {
            System.out.println(user);
        }
        session.close();
    }
}
