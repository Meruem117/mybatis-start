package niit.start.mapper;

import niit.start.pojo.Blog;
import niit.start.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @auther: Meruem117
 */
public class BlogMapperTest {
    @Test
    public void test() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        List<Blog> blogList = blogMapper.getBlogList();
        for (Blog blog : blogList) {
            System.out.println(blog);
        }

        sqlSession.close();
    }
}
