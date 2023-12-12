package com.kc.hotel.controller.user;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kc.hotel.model.domain.User;
import com.kc.hotel.service.UserService;
import com.kc.hotel.common.CommonResult;
import com.kc.hotel.common.StatusCode;
import com.kc.hotel.model.dto.LoginDTO;
import com.kc.hotel.model.dto.PasswordDTO;
import com.kc.hotel.model.dto.RegisterDTO;
import com.kc.hotel.model.dto.ReturnUserDTO;
import com.kc.hotel.util.WebUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping(value = "/register")
    public CommonResult<String> register(@RequestBody RegisterDTO registerDTO) {
        // 邮箱唯一验证
        long count = userService.count(new QueryWrapper<User>().eq("email", registerDTO.getEmail()));
        if(count > 0) {
            // 邮箱重复

            CommonResult<String> commonResult = new CommonResult<>();
            commonResult.setData("邮箱已存在");
            commonResult.setCode(StatusCode.COMMON_FAIL.getCode());
            commonResult.setMessage(StatusCode.COMMON_FAIL.getMessage());
            return commonResult;
        }
        CommonResult<String> commonResult = new CommonResult<>();

        User user = new User();
        BeanUtils.copyProperties(registerDTO, user);
        user.setPassword(SecureUtil.md5(registerDTO.getPassword()));
        // System.out.println(user);

        userService.save(user);

        commonResult.setData("注册成功");
        commonResult.setCode(StatusCode.COMMON_SUCCESS.getCode());
        commonResult.setMessage(StatusCode.COMMON_SUCCESS.getMessage());
        return commonResult;
    }

    @PostMapping(value = "/login")
    public CommonResult<String> login(@RequestBody LoginDTO loginDTO) {
        CommonResult<String> commonResult = new CommonResult<>();
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("email", loginDTO.getEmail());
        String md5Password = SecureUtil.md5(loginDTO.getPassword());
        queryWrapper.eq("password", md5Password);
        User user = userService.getBaseMapper().selectOne(queryWrapper);

        if (null != user) {

            WebUtils.getSession().setAttribute("loginUser", user);
//            System.out.println(WebUtils.getSession().getId());

            commonResult.setCode(StatusCode.COMMON_SUCCESS.getCode());
            commonResult.setMessage(StatusCode.COMMON_SUCCESS.getMessage());
            commonResult.setData("登录成功");
        } else {
            commonResult.setCode(StatusCode.COMMON_FAIL.getCode());
            commonResult.setMessage(StatusCode.COMMON_FAIL.getMessage());
            commonResult.setData("账号密码错误，请重试");
        }

        System.out.println(commonResult);
        return commonResult;
    }

    @GetMapping("/logout")
    public CommonResult<String> logout(){
        CommonResult<String> commonResult = new CommonResult<>();

        WebUtils.getSession().removeAttribute("loginUser");

        commonResult.setCode(StatusCode.COMMON_SUCCESS.getCode());
        commonResult.setMessage(StatusCode.COMMON_SUCCESS.getMessage());
        commonResult.setData("登出成功!");

        return commonResult;
    }

    @GetMapping("/userDetail")
    public CommonResult<ReturnUserDTO> userDetail() {
        CommonResult<ReturnUserDTO> commonResult = new CommonResult();
        ReturnUserDTO returnUser = new ReturnUserDTO();

        User user2 = (User) WebUtils.getSession().getAttribute("loginUser");
        if(user2 == null) {

            commonResult.setCode(StatusCode.COMMON_FAIL.getCode());
            commonResult.setMessage("登录信息过期");

            return commonResult;
        }
        User user = userService.getById(user2.getId());
        BeanUtils.copyProperties(user, returnUser);

        commonResult.setCode(StatusCode.COMMON_SUCCESS.getCode());
        commonResult.setMessage(StatusCode.COMMON_SUCCESS.getMessage());
        commonResult.setData(returnUser);

        return commonResult;
    }

    @PostMapping("/updatePassword")
    public CommonResult<String> updatePassword(@RequestBody PasswordDTO passwordDTO) {
        CommonResult<String> commonResult = new CommonResult<>();
        QueryWrapper queryWrapper = new QueryWrapper();
        System.out.println(passwordDTO);

        User user2 = (User) WebUtils.getSession().getAttribute("loginUser");
        User user = userService.getById(user2.getId());

        String md5OldPassword = SecureUtil.md5(passwordDTO.getOldPassword());

        if (!user.getPassword().equals(md5OldPassword)) {
            commonResult.setCode(StatusCode.COMMON_FAIL.getCode());
            commonResult.setMessage(StatusCode.COMMON_FAIL.getMessage());
            commonResult.setData("密码错误");

            return commonResult;
        }

        String md5NewPassword = SecureUtil.md5(passwordDTO.getNewPassword());
        user.setPassword(md5NewPassword);
        userService.updateById(user);

        commonResult.setCode(StatusCode.COMMON_SUCCESS.getCode());
        commonResult.setMessage(StatusCode.COMMON_SUCCESS.getMessage());
        commonResult.setData("修改密码成功");

        return commonResult;
    }

}
