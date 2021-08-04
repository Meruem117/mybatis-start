package niit.start.mapper;

import niit.start.pojo.User;
import niit.start.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @auther: Meruem117
 */
public class CacheTest {
    @Test
    public void testCache1() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        User user1 = mapper.getUserById(1);
        System.out.println(user1);
        mapper.getUserList();
        // blogMapper.getBlogList();

        // 本地的会话缓存默认开启，仅对一个会话中的数据进行缓存，缓存后将不会再次查询
        System.out.println("================");
        // 清理缓存后则会再次查询
        // sqlSession.clearCache();

        User user2 = mapper.getUserById(1);
        System.out.println(user2);
        mapper.getUserList();

        sqlSession.close();
    }

    @Test
    public void testCache2() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user1 = mapper.getUserById(1);
        System.out.println(user1);
        sqlSession.close();

        // 全局二级缓存
        System.out.println("================");

        SqlSession sqlSession2 = MyBatisUtils.getSqlSession();
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);

        User user2 = mapper2.getUserById(1);
        System.out.println(user2);
        sqlSession2.close();
    }
}
