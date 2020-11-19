package com.example.demo.dao;

import com.example.demo.pojo.SongList;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongListMapper {
    int insert(SongList songList);

    int insertSelective(SongList songList);

    SongList selectByPrimaryKey(@Param("id") Integer id);

    int updateByPrimaryKey(SongList songList);

    int updateSongListMsg(SongList songList);

    int updateSongListImg(SongList songList);

    int updateByPrimaryKeyWithBLOBs(SongList songList);

    int deleteSongList(@Param("id") Integer id);

    List<SongList> allSongList();

    List<SongList> likeTitle(@Param("title") String title);

    List<SongList> likeStyle(@Param("style") String style);

    List<SongList> songListOfTitle(@Param("title") String title);
}
