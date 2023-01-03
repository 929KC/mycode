package com.kc.mybatis.dao;

import com.kc.mybatis.dao.impl.StudentMapper;
import com.kc.mybatis.model.Student;
import com.kc.mybatis.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;


import java.util.List;
import java.util.Map;


/**
 * @author 929KC
 * @date 2022/11/22 12:22
 * @description:
 */
public class StudnetImpl implements StudentMapper {
    SqlSession sqlSession = MybatisUtil.getSqlSession();
    private  StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
    @Override
    public int addStudent(Student student) {
        int count = sqlSession.insert("addStudent", student);
        sqlSession.close();
        return count;
    }

    @Override
    public int  deleteStudent(int id) {
        int count = sqlSession.delete("deleteStudent", id);
        sqlSession.close();
        return count;
    }

    @Override
    public List<Student> getStudentList() {
        List<Student> studentList = mapper.getStudentList();
        sqlSession.close();
        return studentList;
    }

    @Override
    public Student getStudentById(int id) {
        Student student= (Student)sqlSession.selectOne("getStudentById", id);
        sqlSession.close();
        return student;
    }

    @Override
    public int updateStudent(Student student) {
        int count = sqlSession.update("updateStudent", student);
        sqlSession.close();
        return count;
    }

    @Override
    public List<Student> getStudentByAgeDesc(String sort) {
         List<Student> list = mapper.getStudentByAgeDesc(sort);
         sqlSession.close();
         return list;
    }

    @Override
    public List<Student> selectByParamMap(Map<String, Object> paramMap) {
        List<Student> students = mapper.selectByParamMap(paramMap);
        return students;
    }

    @Override
    public List<Student> selectAllByPage(Integer startIndex, Integer pageSize) {
        final List<Student> students = mapper.selectAllByPage(startIndex, pageSize);
        return students;
    }

}
