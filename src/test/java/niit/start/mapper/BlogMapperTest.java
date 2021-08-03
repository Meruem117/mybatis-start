package niit.start.mapper;

import niit.start.pojo.Blog;
import niit.start.utils.IDUtils;
import niit.start.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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

    @Test
    public void getBlogWithIf() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("title", "NEW");
        map.put("views", 0);

        List<Blog> blogList = blogMapper.getBlogWithIf(map);
        for (Blog blog : blogList) {
            System.out.println(blog);
        }

        sqlSession.close();
    }

    @Test
    public void getBlogWithChoose() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        HashMap<String, Object> map = new HashMap<String, Object>();
        // map.put("title", "NEW");
        // map.put("views", 0);

        List<Blog> blogList = blogMapper.getBlogWithChoose(map);
        for (Blog blog : blogList) {
            System.out.println(blog);
        }

        sqlSession.close();
    }

    @Test
    public void getBlogWithWhere() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        HashMap<String, Object> map = new HashMap<String, Object>();
        // map.put("author","JACK");
        map.put("title", "NEW");
        map.put("views", 0);

        List<Blog> blogList = blogMapper.getBlogWithWhere(map);
        for (Blog blog : blogList) {
            System.out.println(blog);
        }

        sqlSession.close();
    }

    @Test
    public void getBlogWithWhereInclude() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("author", "JACK");
        map.put("title", "NEW");
        map.put("views", 0);

        List<Blog> blogList = blogMapper.getBlogWithWhereInclude(map);
        for (Blog blog : blogList) {
            System.out.println(blog);
        }

        sqlSession.close();
    }

    @Test
    public void updateBlogWithSet() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("id", "009baddaf83d491c9bcb431f87ee9b39");
        map.put("views", 200);

        blogMapper.updateBlogWithSet(map);

        sqlSession.close();
    }

    @Test
    public void getBlogWithForEach() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        HashMap<String, Object> map = new HashMap<String, Object>();
        ArrayList<String> list = new ArrayList<String>();
        list.add("JACK");
        // list.add("Hexo");
        map.put("authors", list);

        List<Blog> blogList = blogMapper.getBlogWithForEach(map);
        for (Blog blog : blogList) {
            System.out.println(blog);
        }

        sqlSession.close();
    }
}
