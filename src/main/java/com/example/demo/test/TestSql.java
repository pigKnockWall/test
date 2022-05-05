package com.example.demo.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class TestSql {
    public static void main(String[] args) {
        // 初始化list
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(21);
        list.add(1);
        list.add(3);
        list.add(3);
        list.add(3);

        // set中存放的是不可重复的元素
        HashSet<Integer> set = new HashSet<Integer>();
        // 这里存放的是所有重复的元素，如果你只想知道是哪几个数字重复了，不需要知道具体重复了几次，可以用HashSet
        List<Integer> repeatElements = new ArrayList<Integer>();

        for (int i=0;i<list.size();i++) {
            int value = list.get(i);

            if (set.contains(value)) {
                // 重复元素
                repeatElements.add(value);
            }
            else {
                set.add(value);
            }
        }

        // 输出重复的元素
        for (int i=0;i<repeatElements.size();i++) {
            System.out.println(repeatElements.get(i));
        }
    }

}

