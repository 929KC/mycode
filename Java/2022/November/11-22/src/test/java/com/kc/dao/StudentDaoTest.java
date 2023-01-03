package com.kc.dao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kc.mybatis.dao.StudnetImpl;
import com.kc.mybatis.dao.impl.StudentMapper;
import com.kc.mybatis.model.Student;
import com.kc.mybatis.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 929KC
 * @date 2022/11/22 13:02
 * @description:
 */
public class StudentDaoTest {
    private StudentMapper studentMapper = new StudnetImpl();
    @Test
    public void addStudentTest(){
        Student student = new Student();
        student.setId(5);
        student.setName("妙玉");
        student.setAge(19);
        int i = studentMapper.addStudent(student);
        if (i>0) {
            System.out.println("插入成功");
        }else {
            System.out.println("插入失败");
        }
    }

    @Test
    public  void getStudentListTest() {
        List<Student> studentList = studentMapper.getStudentList();
        studentList.forEach(Student->{
            System.out.print(Student);
        });
    }

    @Test
    public void deleteStudentByIdTest(){
        int i = studentMapper.deleteStudent(5);
        if (i>0) {
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }

    @Test
    public  void getStudentById(){
        Student student= studentMapper.getStudentById(1);
        System.out.println(student);
    }

    @Test
    public  void updateStudentTest(){
        Student student= new Student();
        student.setId(1);
        student.setName("妙玉");
        student.setAge(20);
        int i = studentMapper.updateStudent(student);
        System.out.println(i);
    }
    @Test
    public  void getStudentByAgeDescTest(){
         List<Student> studentList = studentMapper.getStudentByAgeDesc("asc");
         studentList.forEach(student->{
             System.out.println(student);
         });
    }
    @Test
    public  void selectByParamMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","林黛玉");
        map.put("age",16);
        List<Student> students = studentMapper.selectByParamMap(map);
        System.out.println(students);
    }

    @Test
    public void testPageHelper() throws Exception{
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        // 开启分页
        PageHelper.startPage(0, 2);
        // 执行查询语句
        List<Student> students = mapper.getStudentList();
        // 获取分页信息对象
        PageInfo<Student> pageInfo = new PageInfo<>(students,5);
        System.out.println(pageInfo);
    }
    @Test
    public  void selectAllByPageTest(){
        Integer pageNum = 2;
        Integer pageSize = 3;
        Integer startIndex = (pageNum-1)*pageSize;
         List<Student> students = studentMapper.selectAllByPage(startIndex, pageSize);
         students.forEach(student->{
             System.out.println(student);
         });
    }

}
