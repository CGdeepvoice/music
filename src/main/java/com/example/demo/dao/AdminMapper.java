package com.example.demo.dao;

import com.example.demo.pojo.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(Admin record);
    int insertSelective(Admin record);
    Admin selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Admin record);
    int updateByPrimaryKey(Admin record);
    int verifyPassword(@Param("name") String name, @Param("password") String password);
}
