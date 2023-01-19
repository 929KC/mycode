package com.kc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kc.domain.ResponseResult;
import com.kc.domain.entity.Comment;


/**
 * 评论表(Comment)表服务接口
 *
 * @author makejava
 * @since 2023-01-17 19:43:14
 */
public interface CommentService extends IService<Comment> {

    ResponseResult commentList(String commentType, Long articleId, Integer pageNum, Integer pageSize);

    ResponseResult addComment(Comment comment);
}
