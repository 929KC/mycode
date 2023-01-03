package com.bit.spring5.server;

import com.bit.spring5.dao.UserDao;
import com.bit.spring5.dao.UserDaoImpl;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-09 20:36
 */

public class UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(){
      userDao.update();
        System.out.println("hell");
    }


}
