package com.example.demo.dao;

import com.example.demo.pojo.ListSong;
import com.example.demo.pojo.Song;
import com.example.demo.pojo.SongList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.PushBuilder;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ListSongTest {
    @Autowired
    ListSongMapper listSongMapper;

    @Test
    public void insert(){
        Song song = new Song();
        song.setId(1);
        Song song1 = new Song();
        song1.setId(2);
        SongList songList = new SongList();
        songList.setId(1);
        ListSong listSong = new ListSong();
        listSong.setSong(song);
        listSong.setSongList(songList);
        listSongMapper.insert(listSong);
        listSong.setSong(song1);
        listSongMapper.insert(listSong);
    }

    @Test
    public void updateByPrimaryKey(){
        Song song = new Song();
        song.setId(1);
        SongList songList = new SongList();
        songList.setId(2);
        ListSong listSong = new ListSong();
        listSong.setSong(song);
        listSong.setSongList(songList);
        listSong.setId(1);
        listSongMapper.updateByPrimaryKey(listSong);
    }

    @Test
    public void updateListSongMsg(){
        ListSong listSong = new ListSong();
        listSong.setId(2);
        SongList songList = new SongList();
        songList.setId(2);
        listSong.setSongList(songList);
        listSongMapper.updateListSongMsg(listSong);
    }

    @Test
    public void deleteByPrimaryKey(){
        listSongMapper.deleteByPrimaryKey(3);
    }

    @Test
    public void selectByPrimaryKey(){
        ListSong i = listSongMapper.selectByPrimaryKey(1);
        System.out.println(i);
    }

    @Test
    public void allListSong(){
        List<ListSong> listSongs = listSongMapper.allListSong();
        listSongs.forEach(System.out::println);
    }

    @Test
    public void listSongOfSongId(){
        List<ListSong> listSongs = listSongMapper.listSongOfSongId(2);
        listSongs.forEach(System.out::println);
    }

    @Test
    public void listSongOfSongListId(){
        List<ListSong> listSongs = listSongMapper.listSongOfSongListId(2);
        listSongs.forEach(System.out::println);
    }
}
