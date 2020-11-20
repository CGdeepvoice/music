package com.example.demo.dao;

import com.example.demo.pojo.Collect;
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
public class CollectTest {
    @Autowired
    CollectMapper mapper;

    @Test
    public void insert(){
        User user = new User();
        user.setId(5);

        Song song = new Song();
        song.setId(3);

        SongList songList = new SongList();
        songList.setId(2);

        Collect collect = new Collect();
        collect.setUser(user);
        collect.setSong(song);
        collect.setSongList(songList);
        collect.setType((byte) 1);
        collect.setCreateTime(new Date());
        mapper.insert(collect);
    }

    @Test
    public void insertSelective(){
        User user = new User();
        user.setId(5);

        Song song = new Song();
        song.setId(1);

        SongList songList = new SongList();
        songList.setId(2);

        Collect collect = new Collect();
        collect.setUser(user);
        collect.setSong(song);
        collect.setSongList(songList);
        collect.setType((byte) 1);
        collect.setCreateTime(new Date());
        mapper.insertSelective(collect);
    }

    @Test
    public void existSongId(){
        int i = mapper.existSongId(3, 1);
        System.out.println(i);
    }
    @Test
    public void selectByPrimaryKey(){
        Collect collect = mapper.selectByPrimaryKey(3);
        System.out.println(collect);

        List<Collect> collects = mapper.allCollect();
        for (Collect collect1 : collects) {
            System.out.println(collect1);
        }

        List<Collect> collects1 = mapper.collectOfUser(3);
        collects1.forEach(System.out::println);
    }
}
