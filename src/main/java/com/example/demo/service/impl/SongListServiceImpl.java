package com.example.demo.service.impl;

import com.example.demo.dao.SongListMapper;
import com.example.demo.pojo.Song;
import com.example.demo.pojo.SongList;
import com.example.demo.service.SongListService;
import com.example.demo.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongListServiceImpl implements SongListService {
    private final SongListMapper mapper;
    public SongListServiceImpl(SongListMapper songListMapper){
        this.mapper = songListMapper;
    }

    @Override
    public boolean addSongList(SongList songList) {
        return mapper.insert(songList)>0;
    }

    @Override
    public boolean updateSongListMsg(SongList songList) {
        return mapper.updateSongListMsg(songList) > 0;
    }

    @Override
    public boolean updateSongListPic(SongList songList) {
        return mapper.updateSongListImg(songList) > 0;
    }

    @Override
    public boolean deleteSongList(Integer id) {
        return mapper.deleteSongList(id) > 0;
    }

    @Override
    public List<SongList> allSongList() {
        return mapper.allSongList();
    }

    @Override
    public List<SongList> likeTitle(String title) {
        return mapper.likeTitle(title);
    }

    @Override
    public List<SongList> likeStyle(String style) {
        return mapper.likeStyle(style);
    }

    @Override
    public List<SongList> songListOfTitle(String title) {
        return mapper.songListOfTitle(title);
    }
}
