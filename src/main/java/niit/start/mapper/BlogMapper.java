package niit.start.mapper;

import niit.start.pojo.Blog;

import java.util.List;
import java.util.Map;

/**
 * @auther: Meruem117
 */
public interface BlogMapper {
    List<Blog> getBlogList();

    void addBlog(Blog blog);

    List<Blog> getBlogWithIf(Map<String, Object> map);

    List<Blog> getBlogWithChoose(Map<String, Object> map);

    List<Blog> getBlogWithWhere(Map<String, Object> map);

    List<Blog> getBlogWithWhereInclude(Map<String, Object> map);

    void updateBlogWithSet(Map<String, Object> map);

    List<Blog> getBlogWithForEach(Map<String, Object> map);
}
