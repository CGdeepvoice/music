package com.example.demo.dao;

import com.example.demo.pojo.SongList;
import net.minidev.json.JSONUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SongListTest {
    @Autowired
    SongListMapper mapper;

    @Test
    public void insert(){
        SongList songList = new SongList();
        songList.setTitle("第2个歌单222222");
        songList.setIntroduction("这就是第3个歌单的简介");
        songList.setPic("/img/song_list3.jpg");
        songList.setStyle("抒情类");
        mapper.insert(songList);
    }

    @Test
    public void insertSelective(){
        SongList songList = new SongList();
        songList.setTitle("第一个歌单");
        songList.setStyle("抒情");
        mapper.insertSelective(songList);
    }

    @Test
    public void updateByPrimaryKey(){
        SongList songList = new SongList();
        songList.setTitle("第二个歌单");
        songList.setId(2);
        songList.setStyle("抒情");
        songList.setIntroduction("this is second song list");
        songList.setPic("/img/song_list.jpg");
        mapper.updateByPrimaryKey(songList);
    }

    @Test
    public void updateSongListMsg(){
        SongList songList = new SongList();
        songList.setTitle("第二个歌单");
        songList.setId(2);
        songList.setStyle("抒情");
        mapper.updateSongListMsg(songList);
    }

    @Test
    public void updateSongListImg(){
        SongList songList = new SongList();
        songList.setId(1);
        songList.setPic("/img/song_list3.jpg");
        mapper.updateSongListImg(songList);
    }

    @Test
    public void updateByPrimaryKeyWithBLOBs(){
        SongList songList = new SongList();
        songList.setId(1);
        songList.setTitle("title3");
        songList.setPic("/img/song_list3.jpg");
        songList.setIntroduction("this is 3333");
        songList.setStyle("欧美");
        mapper.updateByPrimaryKeyWithBLOBs(songList);
    }

    @Test
    public void delete(){
        mapper.deleteSongList(3);
    }

    @Test
    public void select(){
        SongList songList = mapper.selectByPrimaryKey(1);
        System.out.println(songList);
    }

    @Test
    public void allSongList(){
        List<SongList> songLists = mapper.allSongList();
        for (SongList songList : songLists) {
            System.out.println(songList);
        }
    }

    @Test
    public void likeTitle(){
        List<SongList> songLists = mapper.likeTitle("%第二个%");
        for (SongList songList : songLists) {
            System.out.println(songList);
        }
    }

    @Test
    public void likeStyle(){
        List<SongList> songLists = mapper.likeStyle("%情%");
        for (SongList songList : songLists) {
            System.out.println(songList);
        }
    }

    @Test
    public void songListOfTitle(){
        List<SongList> songLists = mapper.songListOfTitle("第2个歌单222222");
        songLists.forEach(System.out::println);
    }
}
