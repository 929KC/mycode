package com.kc.bitblog.controller;


import com.kc.bitblog.common.AppVariable;
import com.kc.bitblog.common.HttpResult;
import com.kc.bitblog.model.domain.Userinfo;
import com.kc.bitblog.model.vo.UserinfoVo;
import com.kc.bitblog.service.ArticleService;
import com.kc.bitblog.service.UserService;
import com.kc.bitblog.utils.PasswordEncryptionUtils;
import com.kc.bitblog.utils.UserSessionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ArticleService articleService;

    @PostMapping("/register")
    public HttpResult register(Userinfo userinfo) {
        if (userinfo == null || !StringUtils.hasLength(userinfo.getUsername()) ||
                !StringUtils.hasLength(userinfo.getPassword())) {
            return HttpResult.fail(-1, "非法参数");
        }
        userinfo.setPassword(PasswordEncryptionUtils.encypt(userinfo.getPassword()));
        return HttpResult.success(userService.register(userinfo));
    }

    @PostMapping("/login")
    public HttpResult login(String username, String password, HttpServletRequest request) {
        if (!StringUtils.hasLength(username) ||
                !StringUtils.hasLength(password)) {
            return HttpResult.fail(-1, "非法请求");
        }
        Userinfo user = userService.getUserByName(username);
        if (user != null && user.getId() > 0) {
            if (PasswordEncryptionUtils.check(password, user.getPassword())) {
                user.setPassword("");
                HttpSession session = request.getSession(true);
                session.setAttribute(AppVariable.USER_SESSION_KEY, user);
                return HttpResult.success(user);
            }
        }
        return HttpResult.success(0, null);
    }

    @PostMapping("/showinfo")
    public HttpResult showinfo(HttpServletRequest request) {
        UserinfoVo userinfoVo = new UserinfoVo();
        Userinfo userinfo = UserSessionUtils.getUserinfo(request);
        if (userinfo != null) {
            return HttpResult.fail(-1, "非法请求");
        }
        BeanUtils.copyProperties(userinfo, userinfoVo);
        userinfoVo.setArtCount(articleService.getArtCountByUid(userinfo.getId()));
        return HttpResult.success(userinfoVo);
    }

    @PostMapping("/logout")
    public HttpResult logout(HttpSession session) {
        session.removeAttribute(AppVariable.USER_SESSION_KEY);
        return HttpResult.success(1);
    }

    @RequestMapping("/getuserbyid")
    public HttpResult getuserbyid(Integer id) {
        if (id == null || id < 0) {
            return HttpResult.fail(-1, "非法参数");
        }
        Userinfo userinfo = userService.getUserById(id);
        if (userinfo == null || userinfo.getId() < 0) {
            return HttpResult.fail(-1, "非法参数");
        }
        userinfo.setPassword("");
        UserinfoVo userinfoVo = new UserinfoVo();
        BeanUtils.copyProperties(userinfo, userinfoVo);
        userinfoVo.setArtCount(articleService.getArtCountByUid(id));
        return HttpResult.success(userinfoVo);
    }

}
