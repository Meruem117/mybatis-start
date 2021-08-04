package niit.start.mapper.pagehelper;

import niit.start.pojo.User;
import niit.start.pojo.pagehelper.PageHelperUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @auther: Meruem117
 */
public interface PageHelperMapper {
    List<User> selectByPageNumSize(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    List<PageHelperUser> selectByPageHelperUser(PageHelperUser user);
}
