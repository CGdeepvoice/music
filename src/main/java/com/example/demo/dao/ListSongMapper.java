package com.example.demo.dao;

import com.example.demo.pojo.ListSong;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListSongMapper {
    int insert(ListSong listSong);

    int updateByPrimaryKey(ListSong listSong);

    int updateListSongMsg(ListSong listSong);

    ListSong selectByPrimaryKey(@Param("id") Integer id);

    int deleteByPrimaryKey(@Param("id") Integer id);

    List<ListSong> allListSong();

    List<ListSong> listSongOfSongId(@Param("songId") Integer id);

    List<ListSong> listSongOfSongListId(@Param("songListId") Integer id);
}
