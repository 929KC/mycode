package com.kc.cloud_takeaway.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kc.cloud_takeaway.common.BaseResponse;
import com.kc.cloud_takeaway.common.ErrorCode;
import com.kc.cloud_takeaway.common.ResultUtils;
import com.kc.cloud_takeaway.model.entity.User;
import com.kc.cloud_takeaway.service.UserService;
import com.kc.cloud_takeaway.mapper.UserMapper;
import com.kc.cloud_takeaway.utils.ValidateCodeUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.lang.invoke.LambdaMetafactory;
import java.util.Map;

/**
 * @author 929KC
 * @description 针对表【user(用户信息)】的数据库操作Service实现
 * @createDate 2023-06-22 12:15:24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Override
    public BaseResponse<ErrorCode> sendMessage(User user, HttpSession session) {
        String phone = user.getPhone();
        String code = ValidateCodeUtils.generateValidateCode4String(4).toString();
        session.setAttribute(phone, code);
        return ResultUtils.success(ErrorCode.SUCCESS);
    }

    @Override
    public BaseResponse<User> userLogin(Map map, HttpSession session) {
        String phone = map.get("phone").toString();
        String code = map.get("code").toString();
        String codeInSession = (String) session.getAttribute(phone);
        if (codeInSession != null && code.equals(codeInSession)) {
            LambdaQueryWrapper<User> query = new LambdaQueryWrapper<>();
            query.eq(User::getPhone, phone);
            User user = getOne(query);
            if (user == null) {
                user = new User();
                user.setPhone(phone);
                this.save(user);
            }
            session.setAttribute("user", user.getId());
            return ResultUtils.success(user);
        }
        return ResultUtils.error(500004,"登录失败");
    }
}




