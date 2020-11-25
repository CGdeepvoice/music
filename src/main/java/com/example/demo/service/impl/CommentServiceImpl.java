package com.example.demo.service.impl;

import com.example.demo.dao.CommentMapper;
import com.example.demo.pojo.Comment;
import com.example.demo.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentMapper mapper;

    public CommentServiceImpl(CommentMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public boolean addComment(Comment comment) {
        return mapper.insert(comment) > 0;
    }

    @Override
    public boolean updateComment(Comment comment) {
        return mapper.updateCommentMsg(comment) > 0;
    }

    @Override
    public boolean deleteComment(Integer id) {
        return mapper.deleteCommit(id) > 0;
    }

    @Override
    public List<Comment> allComment() {
        return mapper.allComment();
    }

    @Override
    public List<Comment> commentOfSongId(Integer songId) {
        return mapper.commentOfSongId(songId);
    }

    @Override
    public List<Comment> commentOfSongListId(Integer songListId) {
        return mapper.commentOfSongListId(songListId);
    }
}
