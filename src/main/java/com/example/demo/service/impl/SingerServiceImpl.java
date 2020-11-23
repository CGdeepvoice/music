package com.example.demo.service.impl;

import com.example.demo.dao.SingerMapper;
import com.example.demo.pojo.Singer;
import com.example.demo.service.SingerService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SingerServiceImpl implements SingerService {
    private final SingerMapper singerMapper;

    public SingerServiceImpl(SingerMapper singerMapper){
        this.singerMapper = singerMapper;
    }

    @Override
    public boolean addSinger(Singer singer) {
        return singerMapper.insert(singer)>0;
    }

    @Override
    public boolean updateSingerMsg(Singer singer) {
        return singerMapper.updateByPrimaryMsg(singer) > 0;
    }

    @Override
    public boolean updateSingerPic(Singer singer) {
        return singerMapper.updateSingerPic(singer) > 0;
    }

    @Override
    public boolean deleteSinger(Integer id) {
        return singerMapper.deleteSinger(id) > 0;
    }

    @Override
    public List<Singer> allSinger() {
        return singerMapper.allSinger();
    }

    @Override
    public List<Singer> singerOfName(String name) {
        return singerMapper.singerOfName(name);
    }

    @Override
    public List<Singer> singOfSex(Integer sex) {
        return singerMapper.singerOfSex(sex);
    }
}
