package com.kc.hotel.controller.admin;

import com.kc.hotel.model.domain.User;
import com.kc.hotel.service.CommentService;
import com.kc.hotel.service.UserService;
import com.kc.hotel.common.CommonResult;
import com.kc.hotel.common.StatusCode;
import com.kc.hotel.model.domain.Comment;
import com.kc.hotel.model.dto.ReturnCommentDTO;
import com.kc.hotel.model.dto.ReturnUserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


// 标识为 Spring MVC 的 RestController，并指定名称为 "adminCommentController"
@RestController("adminCommentController")
// 映射请求路径为 "/admin"
@RequestMapping("/admin")
public class CommentController {

    // 注入 CommentService 和 UserService 依赖
    @Resource
    private CommentService commentService;
    @Resource
    private UserService userService;

    /**
     * 获取评论列表功能
     *
     * @return 返回评论列表的通用返回对象
     */
    @GetMapping("/listComment")
    public CommonResult<List<ReturnCommentDTO>> listComment() {
        // 创建通用返回对象
        CommonResult<List<ReturnCommentDTO>> commonResult = new CommonResult<>();
        // 创建用于存放返回评论数据的列表
        List<ReturnCommentDTO> returnCommentList = new ArrayList<>();

        // 查询所有评论
        List<Comment> commentList = commentService.list();

        // 遍历评论列表
        for (Comment comment : commentList) {
            // 创建用于返回的评论DTO对象
            ReturnCommentDTO commentDTO = new ReturnCommentDTO();
            // 根据评论中的用户ID查询对应的用户对象
            User user = userService.getById(comment.getUserId());
            // 创建用于返回的用户DTO对象
            ReturnUserDTO returnUserDTO = new ReturnUserDTO();
            // 将用户对象的属性复制到用户DTO对象
            BeanUtils.copyProperties(user, returnUserDTO);

            // 设置评论DTO对象的评论和用户属性
            commentDTO.setComment(comment);
            commentDTO.setUser(returnUserDTO);

            // 将评论DTO对象添加到返回列表中
            returnCommentList.add(commentDTO);
        }

        // 设置通用返回对象的成功信息和数据
        commonResult.setCode(StatusCode.COMMON_SUCCESS.getCode());
        commonResult.setMessage(StatusCode.COMMON_SUCCESS.getMessage());
        commonResult.setData(returnCommentList);

        // 返回通用返回对象
        return commonResult;
    }
}