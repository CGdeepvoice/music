package com.example.demo.pojo;

public class Rank {
    private Long id;
    private SongList songList;
    private User user;
    private Integer score;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SongList getSongList() {
        return songList;
    }

    public void setSongList(SongList songList) {
        this.songList = songList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Rank{" +
                "id=" + id +
                ", songList=" + songList +
                ", user=" + user +
                ", score=" + score +
                '}';
    }
}
