package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Student;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;

    public IPage<Student> findByPage(Page<Student> page){
        return  studentMapper.selectPage(page, null);
    }

}
