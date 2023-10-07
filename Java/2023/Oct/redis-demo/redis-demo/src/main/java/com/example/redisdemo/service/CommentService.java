package com.example.redisdemo.service;

import com.example.redisdemo.domain.Comment;
import com.example.redisdemo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Cacheable(cacheNames = "comment",unless = "#result==null")//查询
    public Comment findById(int comment_id){
        Optional<Comment> optional = commentRepository.findById(comment_id);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    @CachePut(cacheNames = "comment",key ="#result.id")//更新
    public Comment updateComment(Comment comment){
        commentRepository.updateComment(comment.getAuthor(), comment.getAId());
        return comment;
    }

    @CacheEvict(cacheNames = "comment")//删除
    public void deleteComment(int comment_id){
        commentRepository.deleteById(comment_id);
    }


}
