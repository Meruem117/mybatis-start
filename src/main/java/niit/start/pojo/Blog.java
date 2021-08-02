package niit.start.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @auther: Meruem117
 */
@Data
public class Blog {
    private String id;
    private String title;
    private String author;
    // mybatis-config里settings配置映射，对应表格create_time字段
    private Date createTime;
    private int views;
}
