package com.example.demo.dao;

import com.example.demo.pojo.SongList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SongListTest {
    @Autowired
    SongListMapper mapper;

    @Test
    public void insert(){
        SongList songList = new SongList();
        songList.setTitle("第一个歌单");
        songList.setIntroduction("这就是第一个歌单的简介");
        songList.setPic("/img/song_list.jpg");
        songList.setStyle("抒情");
        mapper.insert(songList);
    }
}
