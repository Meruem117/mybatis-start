package niit.start.pojo.school;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Alias("Teacher")
@Data
public class Teacher {
    private int id;
    private String name;
    // 一对多查询添加
    private List<Student> students;
}
