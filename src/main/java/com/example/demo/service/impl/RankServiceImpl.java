package com.example.demo.service.impl;

import com.example.demo.dao.RankMapper;
import com.example.demo.pojo.Rank;
import com.example.demo.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RankServiceImpl implements RankService {
    private final RankMapper mapper;

    public RankServiceImpl(RankMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public int rankOfSongListId(Integer songListId) {
        return mapper.selectScoreSum(songListId) / mapper.selectRankNum(songListId);
    }

    @Override
    public boolean addRank(Rank rank) {
        return mapper.insert(rank) > 0;
    }
}
