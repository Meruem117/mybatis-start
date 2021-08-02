package niit.start.mapper;

import niit.start.pojo.Blog;
import niit.start.utils.IDUtils;
import niit.start.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * @auther: Meruem117
 */
public class BlogMapperTest {
    @Test
    public void getBlogList() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        List<Blog> blogList = blogMapper.getBlogList();
        for (Blog blog : blogList) {
            System.out.println(blog);
        }

        sqlSession.close();
    }

    @Test
    public void addBlog() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDUtils.generateId());
        blog.setTitle("New");
        blog.setAuthor("JACK");
        blog.setCreateTime(new Date());
        blog.setViews(0);

        blogMapper.addBlog(blog);

        sqlSession.close();
    }
}
