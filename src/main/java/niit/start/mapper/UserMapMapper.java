package niit.start.mapper;

import niit.start.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapMapper {
    User getUserWithMap(Map<String, Object> map);

    int addUserWithMap(Map<String, Object> map);

    List<User> getUserLimit(Map<String, Integer> map);

    User getUserById(int id);
}
