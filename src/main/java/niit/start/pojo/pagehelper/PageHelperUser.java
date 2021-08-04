package niit.start.pojo.pagehelper;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @auther: Meruem117
 */
@Data
@AllArgsConstructor
@Alias("PageHelperUser")
public class PageHelperUser {
    private int id;
    private String name;
    private String password;
    //下面两个参数名和 params 配置的名字一致
    private Integer pageNum;
    private Integer pageSize;
}
