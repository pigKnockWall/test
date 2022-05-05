package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Student;
import com.example.demo.entity.User;
import com.example.demo.service.StudentService;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentService studentService;

    @Resource
    private UserService userService;
    @GetMapping("/findPage")
    public IPage<Student> findPage(int pageNo ,int pageSize){
        Page<Student> page = new Page<>(pageNo,pageSize);
        System.out.println(page.getCurrent());
        System.out.println(page.getTotal());
        System.out.println(page.getRecords());
        System.out.println(page.getSize());
        //System.out.println(page.getSize(),page.getRecords(),page.getCurrent());
        return studentService.findByPage(page);
    }
    @GetMapping("/testPageHelper1")
    public PageInfo<User> testPageHelper1(){
        PageInfo<User> queryResult = userService.findAllUserByPageS(1, 5);
        return queryResult;
    }

    @GetMapping("/testPageHelper2")
    public List<User> testPageHelper2(){
        List<User> queryResult = userService.findAllUserByPageF(1, 5);
        return queryResult;
    }


}
