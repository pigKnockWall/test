package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public List<User> queryUserInfo() {
        return userMapper.queryUserInfo();
    }

    @Override
    public List<User> findAllUserByPageF(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> lists = userMapper.queryUserInfo();
        return lists;

    }

    @Override
    public PageInfo<User> findAllUserByPageS(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> lists = userMapper.queryUserInfo();
        PageInfo<User> pageInfo = new PageInfo<>(lists);
        return pageInfo;
    }
}
