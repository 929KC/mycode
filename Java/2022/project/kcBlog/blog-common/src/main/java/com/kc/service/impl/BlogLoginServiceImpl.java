package com.kc.service.impl;

import com.kc.domain.ResponseResult;
import com.kc.domain.entity.LoginUser;
import com.kc.domain.entity.User;
import com.kc.domain.vo.BlogUserLoginVo;
import com.kc.domain.vo.UserInfoVo;
import com.kc.service.BlogLoginService;
import com.kc.utils.BeanCopyUtils;
import com.kc.utils.JwtUtil;
import com.kc.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class BlogLoginServiceImpl implements BlogLoginService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisCache redisCache;
    @Override
    public ResponseResult login(User user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if (Objects.isNull(authenticate)) {
            throw  new RuntimeException("用户名和密码错误");
        }
        //获取userId,生成token
        LoginUser loginUser =(LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);
        //将信息存入redis
        redisCache.setCacheObject("bloglogin:"+userId,loginUser);
        //把token和userInfo封装返回
        //把User转换成UserInfo
        UserInfoVo userInfoVo = BeanCopyUtils.copyBean(loginUser.getUser(), UserInfoVo.class);
        BlogUserLoginVo vo = new BlogUserLoginVo(jwt,userInfoVo);
        return ResponseResult.okResult(vo);
    }

    @Override
    public ResponseResult logout() {
        //获取token解析获取userId
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser LoginUser = (LoginUser)authentication.getPrincipal();
        //获取userId
        Long userId = LoginUser.getUser().getId();
        //删除redis中的用户信息
        redisCache.deleteObject("bloglogin:"+userId);
        return ResponseResult.okResult();
    }
}
