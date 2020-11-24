package com.example.demo.service;

import com.example.demo.pojo.Song;

import java.util.List;

public interface SongService {
    boolean addSong(Song song);

    boolean updateSongMsg(Song song);

    boolean updateSongUrl(Song song);

    boolean updateSongPic(Song song);

    boolean deleteSong(Integer id);

    List<Song> allSong();

    List<Song> songOfSingerId(Integer singerId);

    Song songOfId(Integer id);

    List<Song> songOfName(String name);
}
