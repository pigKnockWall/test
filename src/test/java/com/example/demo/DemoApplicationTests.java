package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void test1(){
       List<String> list = new ArrayList<>();
    }

    @Test
    void printDate(){
        Date today = new Date();
        System.out.println(today);
    }

}
