package com.example.demo.dao;

import com.example.demo.pojo.Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentMapper {
    int insert(Comment comment);

    int insertSelective(Comment comment);

    int updateByPrimaryKey(Comment comment);

    int updateCommentMsg(Comment comment);

    int deleteCommit(@Param("id") Integer id);

    Comment selectByPrimaryKey(@Param("id") Integer id);

    List<Comment> allComment();

    List<Comment> commentOfSongId(@Param("songId")Integer songId);

    List<Comment> commentOfSongListId(@Param("songListId") Integer songListId);
}
