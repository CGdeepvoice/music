package com.example.demo.dao;

import com.example.demo.pojo.Song;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongMapper {

    int insert(Song song);

    int insertSelective(Song song);

    Song selectByPrimaryKey(@Param("id") Integer id);

    int updateByPrimaryKeyWithBLOBs(Song song);

    int updateByPrimaryKey(Song song);

    int updateSongMsg(Song song);

    int updateSongUrl(Song song);

    int updateSongPic(Song song);

    int deleteSong(@Param("id") Integer id);

    List<Song> allSong();

    List<Song> songOfSingerId(@Param("singerId") Integer singerId);

    List<Song> songOfSingerName(@Param("singerName")String singerName);

    List<Song> songOfName(@Param("name") String name);
}
