package com.example.demo.dao;

import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    int insert(User user);

    int insertSelective(User user);

    User selectByPrimaryKey(@Param("id") Integer id);

    int updateByPrimaryKey(User user);

    int updateByPrimaryKeySelective(User user);

    int verifyPassword(@Param("name") String name, @Param("password") String password);

    int existUserName(@Param("name") String name);

    int updateUserMsg(User user);

    int deleteUser(@Param("id") Integer id);

    List<User> allUser();

    List<User> userOfId(@Param("id") Integer id);

    List<User> loginStatus(@Param("name") String name);


}
