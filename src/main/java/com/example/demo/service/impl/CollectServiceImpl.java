package com.example.demo.service.impl;

import com.example.demo.dao.CollectMapper;
import com.example.demo.pojo.Collect;
import com.example.demo.pojo.User;
import com.example.demo.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    private CollectMapper mapper;

    @Override
    public boolean addCollection(Collect collect) {
        return mapper.insert(collect) > 0;
    }

    @Override
    public boolean existSongId(Integer userId, Integer songId) {
        return mapper.existSongId(userId, songId) > 0;
    }

    @Override
    public boolean updateCollectMsg(Collect collect) {
        return mapper.updateCollectMsg(collect) > 0;
    }

    @Override
    public boolean deleteCollect(Integer userId, Integer songId) {
        return mapper.deleteCollect(userId, songId) > 0;
    }

    @Override
    public List<Collect> allCollect() {
        return mapper.allCollect();
    }

    @Override
    public List<Collect> collectOfUser(Integer userId) {
        return mapper.collectOfUser(userId);
    }
}
