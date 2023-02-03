package com.kc.controller;

import com.kc.domain.ResponseResult;
import com.kc.domain.entity.LoginUser;
import com.kc.domain.entity.Menu;
import com.kc.domain.entity.User;
import com.kc.domain.vo.AdminUserInfo;
import com.kc.domain.vo.RoutersVo;
import com.kc.domain.vo.UserInfoVo;
import com.kc.enums.AppHttpCodeEnum;
import com.kc.exception.SystemException;

import com.kc.service.LoginService;
import com.kc.service.MenuService;
import com.kc.service.RoleService;
import com.kc.utils.BeanCopyUtils;
import com.kc.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private RoleService roleService;

    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody User user) {
        if (!StringUtils.hasText(user.getUserName())) {
            //提示 必须要传用户名
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
        return loginService.login(user);
    }

    @GetMapping("/getInfo")
    public ResponseResult<AdminUserInfo> getInfo() {
        //获取当前的登录的用户
        LoginUser loginUser = SecurityUtils.getLoginUser();
        //根据用户id查询权限信息
        List<String> perms = menuService.selectPermsByUserId(loginUser.getUser().getId());
        //获取用户信息
        User user = loginUser.getUser();
        UserInfoVo userInfoVo = BeanCopyUtils.copyBean(user, UserInfoVo.class);
        //根据用户id查询角色信息
        List<String>  rolesKeyList =  roleService.selectRoleKeyByUserId(loginUser.getUser().getId());
        AdminUserInfo adminUserInfo = new AdminUserInfo(perms,rolesKeyList,userInfoVo);
        return ResponseResult.okResult(adminUserInfo);
    }

    @GetMapping("getRouters")
    public ResponseResult<RoutersVo> getRouters(){
        Long userId = SecurityUtils.getUserId();
        List<Menu> menus = menuService.selectRouterTreeByUserId(userId);
        return ResponseResult.okResult(new RoutersVo(menus));

    }
}