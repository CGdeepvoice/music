package com.example.demo.service.impl;

import com.example.demo.dao.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public boolean addUser(User user){
        return userMapper.insert(user) > 0;
    }

    @Override
    public boolean updateUserMsg(User user) {
        return userMapper.updateUserMsg(user) > 0;
    }

    @Override
    public boolean updateUserAvatar(User user) {
        return userMapper.updateUserAvatar(user) > 0;
    }

    @Override
    public boolean existUser(String name) {
        return userMapper.existUserName(name) > 0;
    }

    @Override
    public boolean verityPassword(String username, String password) {
        return userMapper.verifyPassword(username, password) > 0;
    }

    @Override
    public boolean deleteUser(Integer id) {
        return userMapper.deleteUser(id) > 0;
    }

    @Override
    public List<User> allUser() {
        return userMapper.allUser();
    }

    @Override
    public List<User> userOfId(Integer id) {
        return userMapper.userOfId(id);
    }

    @Override
    public List<User> loginStatus(String username) {
        return userMapper.loginStatus(username);
    }
}
