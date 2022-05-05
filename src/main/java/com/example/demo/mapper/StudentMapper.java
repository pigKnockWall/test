package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Student;

import java.util.List;

public interface StudentMapper extends BaseMapper<Student> {
        //自定义方法
        public int insertStudent(Student student);
        public Student selectStudentById(Integer id);
        public List<Student> selectByName(String name);

}
