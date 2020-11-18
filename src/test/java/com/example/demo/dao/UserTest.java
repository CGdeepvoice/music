package com.example.demo.dao;

import com.example.demo.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.PushBuilder;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void insert(){
        User user = new User();
        user.setUsername("dddasd");
        user.setPassword("123456");
        user.setSex((byte) 1);
        user.setPhoneNum("17301592000");
        user.setEmail("774553620@qq.com");
        Calendar calendar = new GregorianCalendar(1994, 5, 24);
        Date date = calendar.getTime();
        user.setBirth(date);
        user.setIntroduction("this is a short introduction");
        user.setLocation("南京");
        user.setAvator("/img/1.jpg");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());

        int i = userMapper.insert(user);
        System.out.println(i);
    }

    @Test
    public void insertSelective(){
        User user = new User();
        user.setUsername("陈葛");
        user.setPassword("123123qwe");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        int i = userMapper.insertSelective(user);
        System.out.println(i);
    }

    @Test
    public void selectByPrimaryKey(){
        User user = userMapper.selectByPrimaryKey(3);
        System.out.println(user);
    }

    @Test
    public void updateByPrimaryKey(){
        User user = new User();
        user.setId(4);
        user.setUsername("dddasd");
        user.setPassword("123456");
        user.setSex((byte) 1);
        user.setPhoneNum("17301592000");
        user.setEmail("774553620@qq.com");
        Calendar calendar = new GregorianCalendar(1994, 5, 24);
        Date date = calendar.getTime();
        user.setBirth(date);
        user.setIntroduction("this is a short introduction啊啊啊啊啊");
        user.setLocation("新疆");
        user.setAvator("/img/1.jpg");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());

        int i = userMapper.updateByPrimaryKey(user);
        System.out.println(i);
    }

    @Test
    public void updateByPrimaryKeySelective(){
        User user = new User();
        user.setId(1);
        user.setUsername("xxxjjj");
        int i = userMapper.updateByPrimaryKeySelective(user);
        System.out.println(i);
    }

    @Test
    public void verifyPassword(){
        int ddd = userMapper.verifyPassword("ddd", "123456");
        System.out.println(ddd);
    }

    @Test
    public void existUserName(){
        int name = userMapper.existUserName("陈葛");
        System.out.println(name);
    }

    @Test
    public void updateUserMsg(){
        User user = new User();
        user.setId(5);
        user.setPassword("cjasd");
        int i = userMapper.updateUserMsg(user);
        System.out.println(i);
    }

    @Test
    public void deleteUser(){
        int i = userMapper.deleteUser(4);
        System.out.println(i);
    }

    @Test
    public void allUser(){
        List<User> users = userMapper.allUser();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void userOfId(){
        List<User> users = userMapper.userOfId(1);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void loginStatus(){
        List<User> list = userMapper.loginStatus("ddd");
        for (User user : list) {
            System.out.println(user);
        }
    }
}
