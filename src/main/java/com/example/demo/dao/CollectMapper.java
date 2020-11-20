package com.example.demo.dao;

import com.example.demo.pojo.Collect;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectMapper {
    int insert(Collect collect);

    int insertSelective(Collect collect);

    int updateByPrimary(Collect collect);

    int updateCollectMsg(Collect collect);

    Collect selectByPrimaryKey(@Param("id") Integer id);

    int existSongId(@Param("userId") Integer userId, @Param("songId") Integer songId);

    int deleteCollect(@Param("userId") Integer userId, @Param("songId") Integer songId);

    List<Collect> allCollect();

    List<Collect> collectOfUser(@Param("userId") Integer userId);

}
