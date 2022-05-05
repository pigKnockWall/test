package com.example.demo.MpTest;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    //定义StudentMapper
    @Autowired
    private UserMapper userMapper;


    @Test
    public void testInsertStudent() {
        User user = new User();
        user.setName("ZAIXIA");
        user.setEmail("15878454");
        user.setAge(10);

        int rows = userMapper.insert(user);
        System.out.println("inserStudent rows:" + rows);
        System.out.println(user.getId());
    }
    @Test
    public void testUpdate(){
        User user = new User();
        user.setAge(22);
        user.setEmail("123456789");
        user.setName("牛德华");
        userMapper.updateById(user);
    }
    @Test
    public void testDelete(){
        int count = userMapper.deleteById(2);
        System.out.println(count);
    }
    @Test
    public void testDeleteByMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("id",3);
        map.put("name","ZAIXIA");
        userMapper.deleteByMap(map);
    }
    @Test
    public void testDeleteByBatchId(){
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(6);
        userMapper.deleteBatchIds(list);
    }
    @Test
    public void testDeleteByLambda(){
        List<Integer> ids = Stream.of(1,2,3,4,5).collect(Collectors.toList());

    }
    @Test
    public void testSelectById(){
        User user = userMapper.selectById(6);
        if(Objects.nonNull(user)){
            System.out.println(user);
        }
    }
    @Test
    public void testSelectByBatchId(){
        List<Integer> list = Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toList());
        List<User> users = userMapper.selectBatchIds(list);
        System.out.println(users);
        for (User user :
                users) {
            System.out.println(user);
        }
    }
    @Test
    public void testSelectByMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","猪撞墙");
        map.put("email","猪猪侠");
        List<User> users = userMapper.selectByMap(map);
        System.out.println(users);
    }
}

