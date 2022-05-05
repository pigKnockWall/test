package com.example.demo.test;

/**
 * 需求：
 * 开辟一条线程 做一个数字的输出
 * @author Alan
 * @version 1.0
 * @date 2020-05-27 16:17
 */
public class Exercise5 {
    public static void main(String[] args) {

        /**
         * 通过Runnable 来实例化线程
         */
        Thread t=new Thread(()->{
            for(int i=0;i<100;i++){
                System.out.println(i);
            }
        });
        t.start();
    }
}
