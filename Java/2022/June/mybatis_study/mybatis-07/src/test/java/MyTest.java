import com.bit.bean.Teacher;
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
 * @createDate: 2022-06-13 14:09
 */

public class MyTest {
    @Test
    public void getTeacher()  {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teacher = mapper.getTeacher(1);
        for (Teacher teacher1 : teacher) {
            System.out.println(teacher1);
        }



    }
}
