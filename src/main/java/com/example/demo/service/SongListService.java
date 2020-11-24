package com.example.demo.service;

import com.example.demo.pojo.SongList;

import java.util.List;

public interface SongListService {
    boolean addSongList(SongList songList);

    boolean updateSongListMsg(SongList songList);

    boolean updateSongListPic(SongList songList);

    boolean deleteSongList(Integer id);

    List<SongList> allSongList();

    List<SongList> likeTitle(String title);

    List<SongList> likeStyle(String style);

    List<SongList> songListOfTitle(String title);
}