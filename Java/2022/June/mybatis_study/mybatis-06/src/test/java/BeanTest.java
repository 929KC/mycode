import com.bit.bean.Student;
import com.bit.bean.Teacher;
import com.bit.dao.StudentMapper;
import com.bit.dao.TeacherMapper;
import com.bit.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-13 12:01
 */

public class BeanTest {
//    @Test
//    public void getTeacher() {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
//        Teacher teacher = mapper.getTeacher(1);
//        System.out.println(teacher);
//        sqlSession.close();
//    }


    @Test
    public void getStudent() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> student = mapper.getStudent();
        for (Student student1 : student) {
            System.out.println(student1);
        }
        sqlSession.close();
    }

}
