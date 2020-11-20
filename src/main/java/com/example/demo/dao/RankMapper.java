package com.example.demo.dao;

import com.example.demo.pojo.Rank;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RankMapper {
    int insert(Rank rank);

    int selectScoreSum(@Param("songListId") Integer songListId);

    int selectRankNum(@Param("songListId") Integer songListId);


}
