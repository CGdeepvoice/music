package com.example.demo.service.impl;

import com.example.demo.dao.AdminMapper;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    private final AdminMapper adminMapper;

    public AdminServiceImpl(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public boolean verityPassWd(String name, String password) {
        return adminMapper.verifyPassword(name, password) > 0;
    }
}
