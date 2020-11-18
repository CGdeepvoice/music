package com.example.demo.dao;

import com.example.demo.pojo.Singer;
import com.example.demo.pojo.Song;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SongTest {
    @Autowired
    SongMapper songMapper;

    @Test
    public void insert(){
        Singer singer = new Singer();
        singer.setId(1);
        Song song = new Song();
        song.setName("双截棍");
        song.setIntroduction("《双截棍》是因为周杰伦喜爱看中国的武打电影而创作的");
        song.setLyric("岩烧店的烟味弥漫 隔壁是国术馆");
        song.setSinger(singer);
        song.setPic("/img/双截棍.jpg");
        song.setUrl("https://y.qq.com/n/yqq/song/00218ObD0yrANX.html?ADTAG=h5_playsong&no_redirect=1");
        song.setCreateTime(new Date());
        song.setUpdateTime(new Date());
        songMapper.insert(song);
    }

    @Test
    public void insertSelective(){
        Singer singer = new Singer();
        singer.setId(2);
        Song song = new Song();
        song.setName("给你们");
        song.setIntroduction("雨一直下");
        song.setSinger(singer);
        song.setUrl("https://music.163.com/#/song?id=190499&market=baiduqk");
        song.setCreateTime(new Date());
        song.setUpdateTime(new Date());
        songMapper.insertSelective(song);

        song.setName("月亮惹的祸");
        song.setIntroduction("都是月亮惹的祸");
        song.setUrl("https://music.163.com/#/song?id=5243631");
        song.setCreateTime(new Date());
        song.setUpdateTime(new Date());
        songMapper.insertSelective(song);

        song.setName("雨一直下");
        song.setIntroduction("大人的情歌");
        song.setUrl("https://music.163.com/#/song?id=5243638");
        song.setCreateTime(new Date());
        song.setUpdateTime(new Date());
        songMapper.insertSelective(song);
    }

    @Test
    public void updateByPrimaryKeyWithBLOBs(){
        Singer singer = new Singer();
        singer.setId(2);
        Song song = new Song();
        song.setId(2);
        song.setSinger(singer);
        song.setName("用心良苦");
        song.setIntroduction("讲述的是在感情的世界里很难有公平可言，付出一切后仍然可能会有失去爱情的痛苦。");
        song.setUpdateTime(new Date());
        song.setPic("/img/用心良苦.jpg");
        song.setLyric("你的脸有几分憔悴 你的眼有残留的泪");
        song.setUrl("https://music.163.com/#/song?id=190778&market=baiduqk");
        songMapper.updateByPrimaryKeyWithBLOBs(song);
    }

    @Test
    public void updateByPrimaryKey(){
        Singer singer = new Singer();
        singer.setId(1);
        Song song = new Song();
        song.setId(1);
        song.setSinger(singer);
        song.setName("双截棍");
        song.setIntroduction("《双截棍》是因为周杰伦喜爱看中国的武打电影而创作的");
        song.setPic("/img/双截棍.png");
        song.setUpdateTime(new Date());
        songMapper.updateByPrimaryKey(song);
    }

    @Test
    public void updateSongUrl(){
        Song song = new Song();
        song.setId(2);
        song.setUrl("https://y.qq.com/n/yqq/song/002k23EZ45qiyV.html?ADTAG=h5_playsong&no_redirect=1");
        songMapper.updateSongUrl(song);
    }

    @Test
    public void updateSongPic(){
        Song song = new Song();
        song.setId(2);
        song.setPic("/img/用心良苦2.jpg");
        songMapper.updateSongPic(song);
    }

    @Test
    public void deleteSong(){
        songMapper.deleteSong(4);
    }

    @Test
    public void selectByPrimaryKey(){
        Song song = songMapper.selectByPrimaryKey(1);
        System.out.println(song);
    }

    @Test
    public void allSong(){
        List<Song> songs = songMapper.allSong();
        for (Song song : songs) {
            System.out.println(song);
        }
    }

    @Test
    public void songOfSingerId(){
        List<Song> songs = songMapper.songOfSingerId(2);
        for (Song song : songs) {
            System.out.println(song);
        }
    }

    @Test
    public void songOfSingerName(){
        List<Song> songs = songMapper.songOfSingerName("张宇");
        for (Song song : songs) {
            System.out.println(song);
        }
    }

    @Test
    public void songOfName(){
        List<Song> songs = songMapper.songOfName("给你们");
        for (Song song : songs) {
            System.out.println(song);
        }
    }
}
