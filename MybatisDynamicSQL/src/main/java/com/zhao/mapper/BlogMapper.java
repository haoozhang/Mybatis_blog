package com.zhao.mapper;

import com.zhao.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    // 增加一篇博客
    int addBlog(Blog blog);

    // If
    // 根据作者名字和博客名字来查询博客
    // 如果作者名字为空，那么只根据博客名字查询；
    // 反之，则根据作者名来查询；如果两者都为空，那么查询所有博客
    List<Blog> queryBlogIf(Map<String, String> map);

    // Where
    List<Blog> queryBlogWhere(Map<String, String> map);

    // Set
    // 更新一条博客
    int updateBlog(Map<String, String> map);

    // Choose
    List<Blog> queryBlogChoose(Map<String, Object> map);

    // Foreach
    List<Blog> queryBlogForeach(Map map);
    List<Blog> queryBlogForeach2(Map map);

}
