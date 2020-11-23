package com.example.demo.service;

import com.example.demo.pojo.Singer;

import java.util.List;

public interface SingerService {
    boolean addSinger(Singer singer);

    boolean updateSingerMsg(Singer singer);

    boolean updateSingerPic(Singer singer);

    boolean deleteSinger(Integer id);

    List<Singer> allSinger();

    List<Singer> singerOfName(String name);

    List<Singer> singOfSex(Integer sex);
}
