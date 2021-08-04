package niit.start.mapper.pagehelper;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import niit.start.mapper.UserMapper;
import niit.start.pojo.User;
import niit.start.pojo.pagehelper.PageHelperUser;
import niit.start.utils.MyBatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @auther: Meruem117
 */
public class PageHelperTest {

    @Test
    public void testPageHelper() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list;

        //第一种，RowBounds方式的调用
        /*RowBounds rowBounds = new RowBounds(0, 2);
        list = sqlSession.selectList("niit.start.mapper.UserMapper.getUserList", null, rowBounds);*/

        //第二种，Mapper接口方式的调用，推荐这种使用方式。
        PageHelper.startPage(1, 2);
        list = mapper.getUserList();

        //第三种，Mapper接口方式的调用，推荐这种使用方式。
        /*PageHelper.offsetPage(0, 2);
        list = mapper.getUserList();*/

        //第四种，参数方法调用
        //需要Mapper接口方法，不需要在xml处理后两个参数
        //配置supportMethodsArguments=true
        /*PageHelperMapper pageHelperMapper = sqlSession.getMapper(PageHelperMapper.class);
        list = pageHelperMapper.selectByPageNumSize(1, 2);*/

        //第五种，参数对象 - 存疑
        //如果 pageNum 和 pageSize 存在于 User 对象中，只要参数有值，也会被分页
        /*PageHelperMapper pageHelperMapper = sqlSession.getMapper(PageHelperMapper.class);
        PageHelperUser pageHelperUser = new PageHelperUser(0, "", "", 0, 0);
        List<PageHelperUser> list2 = pageHelperMapper.selectByPageHelperUser(pageHelperUser);*/

        //第六种，ISelect 接口方式
        //jdk8 lambda用法
        // Page<User> page = PageHelper.startPage(1, 2).doSelectPage(() -> mapper.getUserList());
        //也可以直接返回PageInfo，注意doSelectPageInfo方法和doSelectPage
        // PageInfo<Object> pageInfo = PageHelper.startPage(1, 2).doSelectPageInfo(() -> mapper.getUserList());
        // System.out.println(pageInfo);
        //count查询，返回一个查询语句的count数
        // long total = PageHelper.count(() -> mapper.getUserList());
        // System.out.println(total);

        for (User user : list) {
            System.out.println(user);
        }

        sqlSession.close();
    }
}
