package niit.start.mapper;

import niit.start.pojo.Blog;

import java.util.List;

/**
 * @auther: Meruem117
 */
public interface BlogMapper {
    List<Blog> getBlogList();

    void addBlog(Blog blog);
}
