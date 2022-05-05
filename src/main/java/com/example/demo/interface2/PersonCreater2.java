package com.example.demo.interface2;

import com.example.demo.test.Person;

public interface PersonCreater2{
    //通过Person的有参构造实现
    Person getPerson(String name, int age);
}
