package com.kc.hotel.controller.user;

import com.kc.hotel.model.domain.User;
import com.kc.hotel.service.CommentService;
import com.kc.hotel.common.CommonResult;
import com.kc.hotel.common.StatusCode;
import com.kc.hotel.model.domain.Comment;
import com.kc.hotel.model.dto.CommentDTO;
import com.kc.hotel.util.WebUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/user")
public class CommentController {

    @Resource
    private CommentService commentService;

    @PostMapping("/publishComment")
    public CommonResult<String> publishComment(@RequestBody CommentDTO commentDTO) {
        CommonResult<String> commonResult = new CommonResult<>();

        User user = (User) WebUtils.getSession().getAttribute("loginUser");

        if (1 != user.getState()) {
            commonResult.setCode(StatusCode.COMMON_FAIL.getCode());
            commonResult.setMessage(StatusCode.COMMON_FAIL.getMessage());
            commonResult.setData("评价失败，您还没在该店消费过!");
        }
        else {
            Comment comment = new Comment();
            BeanUtils.copyProperties(commentDTO, comment);
            comment.setUserId(user.getId());

            commentService.save(comment);

            commonResult.setCode(StatusCode.COMMON_SUCCESS.getCode());
            commonResult.setMessage(StatusCode.COMMON_SUCCESS.getMessage());
            commonResult.setData("评价成功!");
        }

        return commonResult;
    }

}
