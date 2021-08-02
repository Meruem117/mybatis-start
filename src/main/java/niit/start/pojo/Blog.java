package niit.start.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @auther: Meruem117
 */
@Data
public class Blog {
    private int id;
    private String title;
    private String author;
    private Date createTime;
    private int views;
}
