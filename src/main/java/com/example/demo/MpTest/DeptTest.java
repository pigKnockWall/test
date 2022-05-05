package com.example.demo.MpTest;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.demo.entity.Dept;
import com.example.demo.mapper.DeptMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DeptTest {
    @Autowired
    DeptMapper deptMapper;

    @Test
    public void testInsert(){
        Dept dept = new Dept();
        dept.setManager(2);
        dept.setName("景泰帝");
        dept.setMobile("1414144");
        boolean flag = dept.insert();
        System.out.println(flag);
    }
    @Test
    public void testUpdateById(){
        Dept dept = new Dept();
        dept.setMobile("16179555");
        dept.setName("猪撞墙");
        dept.setId("b764279d79e04c21af1b42fd29fb284c");
        boolean flag = dept.updateById();
        System.out.println(flag);
    }
    @Test
    public void testDeleteById(){
        Dept dept= new Dept();
        System.out.println(dept.deleteById("b764279d79e04c21af1b42fd29fb284c"));
    }
    @Test
    public void testSelectById(){
        Dept dept = new Dept();
        dept.setId("66");
        System.out.println(dept.selectById());
    }
    @Test
    public void testSelectById2(){
        Dept dept = new Dept();
        System.out.println(dept.selectById(55));
    }
    @Test
    public void testSC(){
        Integer count = deptMapper.selectCount(new LambdaQueryWrapper<Dept>().eq(Dept::getName,"猪猪"));
        System.out.println(count);
    }

}
