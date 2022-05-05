package com.example.demo.test;

import com.example.demo.interface2.PersonCreater;
import com.example.demo.interface2.PersonCreater2;

import java.util.ArrayList;

public class Syntax4 {
    public static void main(String[] args) {

       /* PersonCreater creater=()->new Person();
        creater.getPerson();

        //引用的是Person的无参构造
        //PersonCreater接口的方法指向的是Person的方法
        PersonCreater creater1=Person::new; //等价于上面的()->new Person()
        //实际调用的是Person的无参构造 相当于把接口里的getPerson()重写成new Person()。
        Person a=creater1.getPerson();

        //引用的是Person的有参构造
        PersonCreater2 creater2=Person::new;
        Person b=creater2.getPerson("张三",18);*/

        //需求：已知在一个ArrayList中有若干各Person对象，将这些Person对象按照年龄进行降序排列
        ArrayList<Person> list=new ArrayList<>();


        list.add(new Person("张三",10));
        list.add(new Person("李四",12));
        list.add(new Person("王五",13));
        list.add(new Person("赵六",14));
        list.add(new Person("李雷",11));
        list.add(new Person("韩梅梅",8));
        list.add(new Person("jack",10));

        System.out.println("排序前："+list);

        //将排列的依据传入 具体的方法指向的是 内部元素的age相减 sort会依据结果的正负进行降序排列
        //sort 使用提供的 Comparator对此列表进行排序以比较元素。
        list.sort((o1, o2) -> o2.age-o1.age);

        System.out.println("排序后："+list);
    }
}
