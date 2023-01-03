package com.bit.spring.service;

import com.bit.spring.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-15 15:05
 */
@Service
public class UserService {
    @Autowired//根据类型进行注入
    @Qualifier(value="usrDaoImpl1")//根据属性名称靖进行注入
   // @Resource//根据类型注入
   // @Resource(name="usrDaoImpl1")//根据属性名称靖进行注入
    private UserDao userDao;

    public void useDao(){
        userDao.print();
        System.out.println("成功使用");
    }
}
