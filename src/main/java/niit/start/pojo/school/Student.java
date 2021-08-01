package niit.start.pojo.school;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Alias("Student")
@Data
public class Student {
    private int id;
    private String name;
    private Teacher teacher;
}
