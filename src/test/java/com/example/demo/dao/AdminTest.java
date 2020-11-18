package com.example.demo.dao;

import com.example.demo.pojo.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminTest {
    @Autowired
    AdminMapper mapper;

    @Test
    public void insert(){
        Admin admin = new Admin();
        admin.setName("admin");
        admin.setPassword("123456");

        int n = mapper.insert(admin);
        System.out.println(n);
    }

    @Test
    public void insertSelective(){
        Admin admin = new Admin();
        admin.setName("chenge");
        admin.setPassword("123456");

        int n = mapper.insertSelective(admin);
        System.out.println(n);
    }

    @Test
    public void selectByPrimaryKey(){
        Admin admin = mapper.selectByPrimaryKey(1);
        System.out.println(admin);
    }

    @Test
    public void updateByPrimaryKeySelective(){
        Admin admin = new Admin();
        admin.setId(2);
        admin.setPassword("123123");
        int i = mapper.updateByPrimaryKeySelective(admin);
        System.out.println(i);
    }

    @Test
    public void updateByPrimaryKey(){
        Admin admin = new Admin();
        admin.setId(1);
        admin.setName("root");
        admin.setPassword("123123");
        int i = mapper.updateByPrimaryKey(admin);
        System.out.println(i);
    }

    @Test
    public void verifyPassword(){
        int root = mapper.verifyPassword("root", "123123");
        System.out.println(root);

        root = mapper.verifyPassword("root", "123456");
        System.out.println(root);
    }

    @Test
    public void deleteByPrimaryKey(){
        int i = mapper.deleteByPrimaryKey(2);
        System.out.println(i);
    }
}
