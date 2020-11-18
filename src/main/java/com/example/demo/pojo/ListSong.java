package com.example.demo.pojo;

public class ListSong {
    private Integer id;
    private Song song;
    private SongList songList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public SongList getSongList() {
        return songList;
    }

    public void setSongList(SongList songList) {
        this.songList = songList;
    }

    @Override
    public String toString() {
        return "ListSong{" +
                "id=" + id +
                ", song=" + song +
                ", songList=" + songList +
                '}';
    }
}
