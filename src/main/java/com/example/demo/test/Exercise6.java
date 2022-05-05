package com.example.demo.test;

import java.util.ArrayList;

/**
 * 删除集合中满足条件的元素
 * @author Alan
 * @version 1.0
 * @date 2020-05-27 16:05
 */
public class Exercise6 {

    public static void main(String[] args) {
        ArrayList<Person> list=new ArrayList<>();

        list.add(new Person("张三",10));
        list.add(new Person("李四",12));
        list.add(new Person("王五",13));
        list.add(new Person("赵六",14));
        list.add(new Person("李雷",11));
        list.add(new Person("韩梅梅",8));
        list.add(new Person("jack",10));

        //删除集合中年龄大于12的元素
        /**
         * 之前迭代器的做法
         * ListIterator<Person> it = list.listIterator();
         * while (it.hasNext()){
         *   Person ele=it.next();
         *   if(ele.age>12){
         *         it.remove();
         *   }
         * }
         */

        /**
         * lambda实现
         * 逻辑
         * 将集合中的每一个元素都带入到接口Predicate的test方法中，
         * 如果返回值是true，则删除这个元素
         */
        list.removeIf(ele->ele.age>10);
        System.out.println(list);
    }
}