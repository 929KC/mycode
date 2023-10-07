package com.example.redisdemo.repository;
import com.example.redisdemo.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface CommentRepository extends JpaRepository<Comment,Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE t_comment c SET c.author= ?1 WHERE  c.id = ?2")
    public int updateComment(String author,Integer id);

}
