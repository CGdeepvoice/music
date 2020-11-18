package com.example.demo.dao;

import com.example.demo.pojo.Singer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SingerTest {
    @Autowired
    SingerMapper singerMapper;

    @Test
    public void insert(){
        Singer singer = new Singer();
        singer.setName("周杰伦");
        singer.setSex((byte) 1);
        Calendar calendar = new GregorianCalendar(1979, 1, 18);
        Date date = calendar.getTime();
        singer.setBirth(date);
        singer.setIntroduction("祖籍福建省泉州市永春县，中国台湾流行乐男歌手、原创音乐人、演员、导演、编剧");
        singer.setLocation("台湾");
        singer.setPic("/img/周杰伦.jpg");
        singerMapper.insert(singer);
    }

    @Test
    public void insertSelective(){
        Singer singer = new Singer();
        singer.setName("李健");
        singerMapper.insertSelective(singer);
    }

    @Test
    public void selectByPrimaryKey(){
        Singer singer = singerMapper.selectByPrimaryKey(1);
        System.out.println(singer);
    }

    @Test
    public void updateByPrimaryKey(){
        Singer singer = new Singer();
        singer.setName("张宇");
        singer.setId(2);
        singer.setSex((byte) 1);
        Calendar calendar = new GregorianCalendar(1967, 3, 30);
        Date date = calendar.getTime();
        singer.setBirth(date);
        singer.setIntroduction("中国台湾流行乐男歌手、音乐创作人、主持人、演员。");
        singer.setLocation("台湾");
        singer.setPic("/img/张宇.jpg");
        int i = singerMapper.updateByPrimaryKey(singer);
        System.out.println(i);
    }

    @Test
    public void updateByPrimaryMsg(){
        Singer singer = new Singer();
        singer.setId(1);
        Calendar calendar = new GregorianCalendar(1979, 0, 18);
        Date date = calendar.getTime();
        singer.setBirth(date);
        int i = singerMapper.updateByPrimaryMsg(singer);
        System.out.println(i);
    }

    @Test
    public void updateSingerPic(){
        Singer singer = new Singer();
        singer.setId(1);
        singer.setPic("/img/周杰伦new.jpg");
        singerMapper.updateSingerPic(singer);
    }

    @Test
    public void deleteSinger(){
        singerMapper.deleteSinger(3);
    }

    @Test
    public void allSinger(){
        List<Singer> singers = singerMapper.allSinger();
        for (Singer singer : singers) {
            System.out.println(singer);
        }
    }

    @Test
    public void singerOfName(){
        List<Singer> singers = singerMapper.singerOfName("张宇");
        for (Singer singer : singers) {
            System.out.println(singer);
        }
    }

    @Test
    public void singerOfSex(){
        List<Singer> singers = singerMapper.singerOfSex(1);
        for (Singer singer : singers) {
            System.out.println(singer);
        }
    }
}
