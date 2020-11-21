package com.example.demo.dao;

import com.example.demo.pojo.Comment;
import com.example.demo.pojo.Song;
import com.example.demo.pojo.SongList;
import com.example.demo.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentTest {
    @Autowired
    CommentMapper mapper;

    @Test
    public void insert(){
        User user = new User();
        user.setId(1);

        Song song = new Song();
        song.setId(1);

        SongList songList = new SongList();
        songList.setId(1);

        Comment comment = new Comment();
        comment.setUser(user);
        comment.setSong(song);
        comment.setSongList(songList);
        comment.setContext("真不错");
        comment.setType((byte) 1);
        comment.setCreateTime(new Date());
        comment.setUp(1);
        mapper.insert(comment);
    }

    @Test
    public void insertSelective(){
        User user = new User();
        user.setId(3);

        Song song = new Song();
        song.setId(2);

        SongList songList = new SongList();
        songList.setId(2);

        Comment comment = new Comment();
        comment.setUser(user);
        comment.setSong(song);
        comment.setSongList(songList);
        comment.setContext("针不错");
        comment.setType((byte) 1);
        comment.setCreateTime(new Date());
        comment.setUp(1);
        mapper.insertSelective(comment);
    }

    @Test
    public void updateByPrimaryKey(){
        User user = new User();
        user.setId(3);

        Song song = new Song();
        song.setId(2);

        SongList songList = new SongList();
        songList.setId(2);

        Comment comment = new Comment();
        comment.setUser(user);
        comment.setSong(song);
        comment.setSongList(songList);
        comment.setId(3);
        comment.setContext("深入理解");
        comment.setType((byte) 1);
        comment.setCreateTime(new Date());
        comment.setUp(1);
        mapper.updateByPrimaryKey(comment);
    }

    @Test
    public void updateCommentMsg(){
        User user = new User();
        user.setId(3);

        Song song = new Song();
        song.setId(2);

        SongList songList = new SongList();
        songList.setId(2);

        Comment comment = new Comment();
        comment.setUser(user);
        comment.setSong(song);
        comment.setSongList(songList);
        comment.setId(3);
        comment.setContext("深入理解");
        comment.setType((byte) 1);
        comment.setCreateTime(new Date());
        comment.setUp(2);
        mapper.updateCommentMsg(comment);
    }

    @Test
    public void deleteCommit(){
        mapper.deleteCommit(2);
    }

    @Test
    public void selectByPrimaryKey(){
        Comment comment = mapper.selectByPrimaryKey(1);
        System.out.println(comment);
    }

    @Test
    public void allComment(){
        List<Comment> comments = mapper.allComment();
        comments.forEach(System.out::println);
    }

    @Test
    public void commentOfSongId(){
        List<Comment> comments = mapper.commentOfSongId(1);
        comments.forEach(System.out::println);
    }

    @Test
    public void commentOfSongListId(){
        List<Comment> comments = mapper.commentOfSongListId(1);
        comments.forEach(System.out::println);
    }
}
