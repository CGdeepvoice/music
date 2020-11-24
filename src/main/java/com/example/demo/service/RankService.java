package com.example.demo.service;

import com.example.demo.pojo.Rank;

public interface RankService {
    int rankOfSongListId(Integer songListId);

    boolean addRank(Rank rank);
}
