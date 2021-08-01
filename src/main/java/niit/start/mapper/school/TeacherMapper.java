package niit.start.mapper.school;

import niit.start.pojo.school.Teacher;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {
    @Select("select * from teacher")
    List<Teacher> getTeacherList();

    Teacher getTeacher(int id);

    Teacher getTeacher2(int id);
}
