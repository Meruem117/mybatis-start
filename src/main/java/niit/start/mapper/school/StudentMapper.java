package niit.start.mapper.school;

import niit.start.pojo.school.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {
    @Select("select * from student")
    List<Student> getStudentList();

    List<Student> getStudents();

    List<Student> getStudents2();
}
