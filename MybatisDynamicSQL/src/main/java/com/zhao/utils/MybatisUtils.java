package com.zhao.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtils {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            // 核心配置文件路径
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            // 创建 SqlSessionFactory 实例
            sqlSessionFactory = new SqlSessionFactoryBuilder().build (inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 获取 SqlSession 连接
    public static SqlSession getSession(){
        return getSession(true);
    }

    public static SqlSession getSession(boolean flag) {
        return sqlSessionFactory.openSession(flag);
    }
}
