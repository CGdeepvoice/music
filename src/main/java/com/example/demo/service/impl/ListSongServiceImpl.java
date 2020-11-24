package com.example.demo.service.impl;

import com.example.demo.dao.ListSongMapper;
import com.example.demo.pojo.ListSong;
import com.example.demo.service.ListSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListSongServiceImpl implements ListSongService {
    private final ListSongMapper mapper;

    public ListSongServiceImpl(ListSongMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public boolean addListSong(ListSong listSong) {
        return mapper.insert(listSong) > 0;
    }

    @Override
    public boolean updateListSong(ListSong listSong) {
        return mapper.updateListSongMsg(listSong) > 0;
    }

    @Override
    public boolean deleteListSong(Integer id) {
        return mapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public List<ListSong> allListSong() {
        return mapper.allListSong();
    }

    @Override
    public List<ListSong> listSongOfSongListId(Integer songListId) {
        return mapper.listSongOfSongListId(songListId);
    }
}
