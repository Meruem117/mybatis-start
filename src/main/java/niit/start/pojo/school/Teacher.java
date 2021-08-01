package niit.start.pojo.school;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Alias("Teacher")
@Data
public class Teacher {
    private int id;
    private String name;
}
