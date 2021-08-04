package niit.start.mapper.school;

import niit.start.mapper.school.StudentMapper;
import niit.start.mapper.school.TeacherMapper;
import niit.start.pojo.school.Student;
import niit.start.pojo.school.Teacher;
import niit.start.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class SchoolTest {
    @Test
    public void getStudentList() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> studentList = studentMapper.getStudentList();
        for (Student student : studentList) {
            System.out.println(student);
        }

        sqlSession.close();
    }

    @Test
    public void getTeacherList() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);

        List<Teacher> teacherList = teacherMapper.getTeacherList();
        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }

        sqlSession.close();
    }

    @Test
    public void testStudentWithTeacher() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> list = mapper.getStudents();
        for (Student s : list) {
            System.out.println(s);
        }

        sqlSession.close();
    }

    @Test
    public void testStudentWithTeacher2() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> list = mapper.getStudents2();
        for (Student s : list) {
            System.out.println(s);
        }

        sqlSession.close();
    }

    @Test
    public void testTeacherWithStudents() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        Teacher t = mapper.getTeacher(1);
        System.out.println(t);

        sqlSession.close();
    }

    @Test
    public void testTeacherWithStudents2() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        Teacher t = mapper.getTeacher2(1);
        System.out.println(t);

        sqlSession.close();
    }
}
