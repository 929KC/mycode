package com.kc.hotel.controller.admin;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kc.hotel.service.AdminService;
import com.kc.hotel.common.CommonResult;
import com.kc.hotel.common.StatusCode;
import com.kc.hotel.model.domain.Admin;
import com.kc.hotel.model.dto.AdminLoginDTO;
import com.kc.hotel.util.WebUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

// 标识为 Spring MVC 的 RestController，并指定名称为 "adminAdminController"
@RestController("adminAdminController")
// 映射请求路径为 "/admin"
@RequestMapping("/admin")
public class AdminController {

    // 注入 AdminService 依赖
    @Resource
    private AdminService adminService;

    /**
     * 登录功能
     *
     * @param adminLoginDTO 登录时接收的数据对象
     * @return 登录结果的通用返回对象
     */
    @PostMapping(value = "/login")
    public CommonResult<Admin> login(@RequestBody AdminLoginDTO adminLoginDTO) {
        // 创建通用返回对象
        CommonResult<Admin> commonResult = new CommonResult<>();

        // 创建查询条件
        QueryWrapper queryWrapper = new QueryWrapper();
        // 设置查询条件：管理员名等于传入的用户名
        queryWrapper.eq("admin_name", adminLoginDTO.getUserName());
        // 将密码进行 MD5 加密后设置为查询条件
        String md5Password = SecureUtil.md5(adminLoginDTO.getPassword());
        queryWrapper.eq("password", md5Password);

        // 根据查询条件查询管理员对象
        Admin admin = adminService.getOne(queryWrapper);

        // 如果查询到管理员对象
        if (null != admin) {
            // 设置管理员名
            admin.setAdmin_name(adminLoginDTO.getUserName());
            // 将登录成功的管理员对象存入 Session 中
            WebUtils.getSession().setAttribute("loginAdmin", admin);

            // 设置通用返回对象的成功信息和数据
            commonResult.setCode(StatusCode.COMMON_SUCCESS.getCode());
            commonResult.setMessage(StatusCode.COMMON_SUCCESS.getMessage());
            commonResult.setData(admin);
        } else {
            // 如果未查询到管理员对象，设置通用返回对象的失败信息
            commonResult.setCode(StatusCode.COMMON_FAIL.getCode());
            commonResult.setMessage("账号或密码错误");
            commonResult.setData(null);
        }

        // 返回通用返回对象
        return commonResult;
    }

    /**
     * 注销功能
     *
     * @return 注销结果的通用返回对象
     */
    @GetMapping("/logout")
    public CommonResult<String> logout() {
        // 创建通用返回对象
        CommonResult<String> commonResult = new CommonResult<>();

        // 移除 Session 中的登录管理员对象
        WebUtils.getSession().removeAttribute("loginAdmin");

        // 设置通用返回对象的成功信息和数据
        commonResult.setCode(StatusCode.COMMON_SUCCESS.getCode());
        commonResult.setMessage(StatusCode.COMMON_SUCCESS.getMessage());
        commonResult.setData("登出成功!");

        // 返回通用返回对象
        return commonResult;
    }
}