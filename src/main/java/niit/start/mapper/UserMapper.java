package niit.start.mapper;

import niit.start.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList();

    User getUserById(int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);

    User getUserWithMap(Map<String, Object> map);

    int addUserWithMap(Map<String, Object> map);

    User getUserLike(String name);
}
