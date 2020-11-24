package com.example.demo.service;

import com.example.demo.pojo.ListSong;

import java.util.List;

public interface ListSongService {
    boolean addListSong(ListSong listSong);

    boolean updateListSong(ListSong listSong);

    boolean deleteListSong(Integer id);

    List<ListSong> allListSong();

    List<ListSong> listSongOfSongListId(Integer songId);
}
