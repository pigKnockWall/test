package com.example.demo.service;

import com.example.demo.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {
    //查询所有
    List<User> queryUserInfo();
    List<User> findAllUserByPageF(int pageNum,int pageSize);

    PageInfo<User> findAllUserByPageS(int pageNum, int pageSize);
}
