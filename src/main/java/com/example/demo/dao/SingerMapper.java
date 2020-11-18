package com.example.demo.dao;

import com.example.demo.pojo.Singer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SingerMapper {

    int insert(Singer singer);

    int insertSelective(Singer singer);

    Singer selectByPrimaryKey(@Param("id") Integer id);

    int updateByPrimaryKey(Singer singer);

    int updateByPrimaryMsg(Singer singer);

    int updateSingerPic(Singer singer);

    int deleteSinger(Integer id);

    List<Singer> allSinger();

    List<Singer> singerOfName(String name);

    List<Singer> singerOfSex(@Param("sex") Integer sex);
}
