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
        comment.setUp(1);
        mapper.insert(comment);
    }
}
