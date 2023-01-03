package com.bit.dao;

import com.bit.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    //查询所有用户
    @Select("select *from user")
    List<User>  getUsers();
    //方法存在参数,所有的参数前面必须加:@param("id)注解
    @Select("select *from user where id=#{id}")
    User getUserById(@Param("id")int id);
    //添加用户
    @Insert("insert into user(id,name,pwd) values(#{id},#{name},#{pwd})")
    int addUser(User user);
    //更新用户信息
    @Update("update user set name=#{name},pwd=#{pwd} where id=#{id}")
    int updateUser(User user);
    //删除用户
    @Delete("delete from user where id=#{id}")
    int deleteUser(@Param("id") int id);
 }
