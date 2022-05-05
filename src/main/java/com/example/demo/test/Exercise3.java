package com.example.demo.test;

import java.util.ArrayList;
import java.util.Collections;

public class Exercise3 {

    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();

        Collections.addAll(list,1,2,3,4,5,6,7,8,9);
        /**
         * list.forEach(Consumer<? super E> action)
         * api文档解释： 对 集合中的每个元素执行给定的操作，直到所有元素都被处理或动作引发异常。
         * 将集合中的每一个元素都带入到接口Consumer的方法accept中  然后方法accept指向我们的引用
         * 输出集合中的所有元素
         * list.forEach(System.out::println);
         */

        //输出集合中所有的偶数
        list.forEach(ele->{
            if(ele%2==0){
                System.out.println(ele);
            }
        });
    }
}
