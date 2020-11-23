package com.example.demo.service;

import com.example.demo.pojo.User;

import java.util.List;

public interface UserService {
    boolean addUser(User user);

    boolean updateUserMsg(User user);

    boolean updateUserAvatar(User user);

    boolean existUser(String name);

    boolean verityPassword(String username, String password);

    boolean deleteUser(Integer id);

    List<User> allUser();

    List<User> userOfId(Integer id);

    List<User> loginStatus(String username);

}
