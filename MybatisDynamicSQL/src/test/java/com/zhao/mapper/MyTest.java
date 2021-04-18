package com.zhao.mapper;

import com.zhao.pojo.Blog;
import com.zhao.utils.IdUtil;
import com.zhao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class MyTest {

    @Test
    public void testAddBlog() {
        SqlSession session = MybatisUtils.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IdUtil.genId());
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        mapper.addBlog(blog);

        blog.setId(IdUtil.genId());
        blog.setTitle("Java如此简单");
        mapper.addBlog(blog);

        blog.setId(IdUtil.genId());
        blog.setTitle("Spring如此简单");
        mapper.addBlog(blog);

        blog.setId(IdUtil.genId());
        blog.setTitle("微服务如此简单");
        mapper.addBlog(blog);

        session.close();
    }

    @Test
    public void testQueryBlogIf() {
        SqlSession session = MybatisUtils.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        Map<String, String> map = new HashMap<String, String>();
        map.put("title", "Mybatis如此简单");
        map.put("author", "狂神说");
        List<Blog> blogs = mapper.queryBlogIf(map);

        System.out.println(blogs);
        session.close();
    }

    @Test
    public void testQueryBlogWhere() {
        SqlSession session = MybatisUtils.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        Map<String, String> map = new HashMap<String, String>();
        map.put("title", "Mybatis如此简单");
        map.put("author", "狂神说");
        List<Blog> blogs = mapper.queryBlogWhere(map);

        System.out.println(blogs);
        session.close();
    }

    @Test
    public void testUpdateBlogSet() {
        SqlSession session = MybatisUtils.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("title","动态SQL");
        map.put("author","秦疆");
        map.put("id","9018bb4d8a374c49aa30fed022d55d34");

        mapper.updateBlog(map);
        session.close();
    }

    @Test
    public void testQueryBlogChoose(){
        SqlSession session = MybatisUtils.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        HashMap<String, Object> map = new HashMap<String, Object>();
        //map.put("title","Java如此简单");
        map.put("author","狂神说");
        map.put("views",9999);
        List<Blog> blogs = mapper.queryBlogChoose(map);
        System.out.println(blogs);
        session.close();
    }

    @Test
    public void testQueryBlogForeach() {
        SqlSession session = MybatisUtils.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        List<String> ids = new ArrayList<>();
        ids.add("1");
        ids.add("2");
        ids.add("3");
        Map<String, Object> map = new HashMap<>();
        map.put("ids", ids);

        List<Blog> blogList = mapper.queryBlogForeach2(map);
        //List<Blog> blogList = mapper.queryBlogForeach2(map);
        for (Blog blog : blogList) {
            System.out.println(blog);
        }
        session.close();
    }

}
