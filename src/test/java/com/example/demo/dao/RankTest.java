package com.example.demo.dao;

import com.example.demo.pojo.Rank;
import com.example.demo.pojo.SongList;
import com.example.demo.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RankTest {
    @Autowired
    RankMapper rankMapper;

    @Test
    public void insert(){
        Rank rank = new Rank();
        User user = new User();
        user.setId(3);
        SongList songList = new SongList();
        songList.setId(2);
        rank.setScore(6);
        rank.setUser(user);
        rank.setSongList(songList);
        rankMapper.insert(rank);
    }

    @Test
    public void selectScoreSum(){
        int i = rankMapper.selectScoreSum(1);
        System.out.println(i);
    }
    @Test
    public void selectRankNum(){
        int i = rankMapper.selectRankNum(1);
        System.out.println(i);
    }
}
