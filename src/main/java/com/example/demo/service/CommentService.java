package com.example.demo.service;

import com.example.demo.pojo.Comment;

import java.util.List;

public interface CommentService {
    boolean addComment(Comment comment);

    boolean updateComment(Comment comment);

    boolean deleteComment(Integer id);

    List<Comment> allComment();

    List<Comment> commentOfSongId(Integer songId);

    List<Comment> commentOfSongListId(Integer songListId);
}
