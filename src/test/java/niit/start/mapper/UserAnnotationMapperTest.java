package niit.start.mapper;

import niit.start.pojo.User;
import niit.start.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserAnnotationMapperTest {

    @Test
    public void getUserList() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserAnnotationMapper mapper = sqlSession.getMapper(UserAnnotationMapper.class);

        List<User> userList = mapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void getUserById() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserAnnotationMapper mapper = sqlSession.getMapper(UserAnnotationMapper.class);

        User user = mapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void addUser() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserAnnotationMapper mapper = sqlSession.getMapper(UserAnnotationMapper.class);

        mapper.addUser(new User(5, "DD", "123456"));

        // sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUser() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserAnnotationMapper mapper = sqlSession.getMapper(UserAnnotationMapper.class);

        mapper.updateUser(new User(5, "AA", "123456"));

        // sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserAnnotationMapper mapper = sqlSession.getMapper(UserAnnotationMapper.class);

        mapper.deleteUser(5);

        // sqlSession.commit();
        sqlSession.close();
    }
}
