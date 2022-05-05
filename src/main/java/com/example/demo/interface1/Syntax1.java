package com.example.demo.interface1;

public class Syntax1 {

    public static void main(String[] args) {
        // 1.Lambda表达式的基础语法
        // Lambda是一个匿名函数 一般关注的是以下两个重点
        // 参数列表 方法体

        /**
         * （）：用来描述参数列表
         *  {}：用来描述方法体
         *  ->: Lambda运算符 读作goes to
         */
        //精简
        LambdaNoneReturnNoneParmeter Lambda11=()-> System.out.println("口你急哇");
        Lambda11.test();
        // 无参无返回

        LambdaNoneReturnNoneParmeter lambda1=()->{
            System.out.println("hello world");
        };
        lambda1.test();
        //精简
        LambdaNoneReturnSingleParmeter lambda22=a-> System.out.println("精简结果"+a);
        lambda22.test(5);
        // 无返回值 单个参数
        LambdaNoneReturnSingleParmeter lambda2=(int n)->{
            System.out.println("参数是："+n);
        };
        lambda2.test(10);

        // 无返回值 多个参数
        LambdaNoneReturnMutipleParmeter lambda3=(int a,int b)->{
            System.out.println("参数和是："+(a+b));
        };
        lambda3.test(10,12);

        // 有返回值 无参数
        LambdaSingleReturnNoneParmeter lambda4=()->{
            System.out.println("lambda4：");
            return 100;
        };
        int ret=lambda4.test();
        System.out.println("返回值是："+ret);

        // 有返回值 单个参数
        LambdaSingleReturnSingleParmeter lambda5=(int a)->{
            return a*2;
        };
        int ret2= lambda5.test(3);
        System.out.println("单个参数，lambda5返回值是:"+ret2);

        //有返回值 多个参数
        LambdaSingleReturnMutipleParmeter lambda6=(int a,int b)->{
            return a+b;
        };
        int ret3=lambda6.test(12,14);
        System.out.println("多个参数，lambda6返回值是："+ret3);
    }
}
