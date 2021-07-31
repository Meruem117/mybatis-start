package niit.start.mapper;

import niit.start.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

// 使用注解
public interface UserAnnotationMapper {
    @Select("select * from user")
    List<User> getUserList();

    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") int id);

    @Insert("insert into user(id, name, password) values (#{id}, #{name}, #{password})")
    int addUser(User user);

    @Update("update user set name = #{name}, password = #{password} where id = #{id}")
    int updateUser(User user);

    @Delete("delete from user where id = #{id}")
    int deleteUser(@Param("id") int id);
}
