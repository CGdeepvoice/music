package com.example.demo.pojo;

import java.util.Date;

public class Collect {
    private Integer id;
    private User user;
    private Byte type;
    private Song song;
    private SongList songList;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Collect{" +
                "id=" + id +
                ", user=" + user +
                ", type=" + type +
                ", song=" + song +
                ", songList=" + songList +
                ", createTime=" + createTime +
                '}';
    }
}
