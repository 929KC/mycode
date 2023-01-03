package com.kc.controller;

import com.alibaba.druid.util.StringUtils;
import com.kc.bean.User;
import com.kc.service.UserService;
import com.kc.vo.Result;
import org.apache.catalina.mbeans.SparseUserDatabaseMBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("user")
@RestController
@CrossOrigin//解决跨域
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("getusers")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }
    @PostMapping("addOrUpdate")
    public Result addOrUpdate(@RequestBody User user){
        Result r = new Result();
        try{
            if (StringUtils.isEmpty(user.getId())) {
                userService.addUser(user);
                r.setMessage("用户信息添加成功");
            }else{
                userService.updateUser(user);
                r.setMessage("用户编辑信息成功");
            }
        }catch (Exception e){
            r.setFlag(false);
            r.setMessage("用户数据保存失败");
        }
        return r;
    }

    @GetMapping("delete")
    public Result deleteUserById(String id){
        Result r = new Result();
        try {
            userService.deleteUserById(id);
            r.setMessage("删除成功");
        }catch (Exception e){
           e.printStackTrace();
           r.setMessage("删除失败");
           r.setFlag(false);
        }
        return r;
    }
    //分页查询
    @GetMapping("findByPage")
    public Map<String,Object> findByPage(Integer pageNow,Integer pageSize){
        Map<String,Object> ret = new HashMap<>();
        pageNow = pageNow==null?1:pageNow;
        pageSize = pageSize==null?4:pageSize;
        List<User> user = userService.findByPage(pageNow, pageSize);
        Long total = userService.findTotals();
        ret.put("users",user);
        ret.put("total",total);
        return ret;
    }

}
