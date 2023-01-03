package com.kc.service;

import com.kc.bean.User;
import com.kc.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
@Transactional
public class UserServiceImpl  implements UserService{
   @Autowired
    private UserMapper userDao;
    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public List<User> findByPage(Integer pageNow, Integer rows) {
        int start  = (pageNow-1)*rows;
        return userDao.findByPage(start,rows);
    }

    @Override
    public Long findTotals() {
        return userDao.findTotals();
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void deleteUserById(String id) {
        userDao.deleteUserById(id);
    }
}
