package niit.start.mapper;

import niit.start.pojo.User;
import niit.start.utils.MyBatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {

    @Test
    public void getUserListTest() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = userMapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void getUserByIdTest() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void addUserTest() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        int res = userMapper.addUser(new User(3, "Finch", "123456"));
        System.out.println(res > 0 ? "insert succeed" : "insert fail");

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUserTest() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        int res = userMapper.updateUser(new User(2, "Finch", "234567"));
        System.out.println(res > 0 ? "update succeed" : "update fail");

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUserTest() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        int res = userMapper.deleteUser(3);
        System.out.println(res > 0 ? "delete succeed" : "delete fail");

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getUserWithMapTest() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("user_id", 3);
        map.put("user_name", "Cater");

        User user = userMapper.getUserWithMap(map);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void addUserWithMapTest() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("user_id", 3);
        map.put("user_name", "Cater");
        map.put("user_pwd", "345678");

        int res = userMapper.addUserWithMap(map);
        System.out.println(res > 0 ? "insert succeed" : "insert fail");

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getUserLike() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.getUserLike("ca");
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void getUserLimit() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("startIndex", 0);
        map.put("pageSize", 2);

        List<User> userList = userMapper.getUserLimit(map);
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    // 使用RowBounds实现分页
    @Test
    public void getUserLimitByRowBounds() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        RowBounds rowBounds = new RowBounds(0, 2);

        List<User> userList = sqlSession.selectList("niit.start.mapper.UserMapper.getUserList", null, rowBounds);
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }
    // 还可以使用MyBatis分页插件PageHelper实现分页
    // https://pagehelper.github.io/

    @Test
    public void getUserWithAnnotationTest() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = userMapper.getUserWithAnnotation();
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }
}
