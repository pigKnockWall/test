package com.example.demo.test;

import lombok.Data;

@Data
public class Person {
    public String name;
    public int age;

    public Person() {
        System.out.println("Person的无参构造方法执行");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Person的有参构造方法执行");
    }
}
