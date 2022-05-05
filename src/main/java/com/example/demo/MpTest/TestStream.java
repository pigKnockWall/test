package com.example.demo.MpTest;

import com.example.demo.entity.Person;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
public class TestStream {
    @Test
    public void testStream(){
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);

        Stream<Integer> stream2 = Stream.iterate(3, (x) -> x + 3).limit(6);
        stream2.forEach(System.out::println);

        Stream<Double> stream3 = Stream.generate(Math::random).limit(5);
        stream3.forEach(System.out::println);

    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4, 8, 9, 25, 7, 6, 11);
        //遍历输出符合条件的元素
        list.stream().filter(x->x>6).forEach(System.out::println);
        //匹配第一个
        list.stream().filter(x -> x > 6).findFirst().get();
        //匹配任意（适用于并行流）
        System.out.println(list.parallelStream().filter(x -> x > 6).findAny());
        //是否包含符合特定条件的元素
        boolean b = list.stream().anyMatch(x -> x > 6);
        System.out.println(b);
    }
    @Test
    public void testFilter(){
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));

        Optional<Person> max = personList.stream().max(Comparator.comparingInt(Person::getSalary));
        System.out.println("员工工资最大值"+max.get().getSalary());
        System.out.println(max.get());

        List<String> collect = personList.stream().filter(x -> x.getSalary() > 8000).map(Person::getName).collect(Collectors.toList());
        System.out.println("高于8000的员工姓名:"+collect);
    }
    @Test
    public void testMax(){
        List<String> list = Arrays.asList("admin", "jiangjhub", "pig", "hahahahahhaha", "a");
        Optional<String> max = list.stream().max(Comparator.comparing(String::length));
        System.out.println(max.get());
    }
    @Test
    public void testCompare(){
        List<Integer> list = Arrays.asList(7, 6, 9, 4, 11, 6);

        // 自然排序
        Optional<Integer> max = list.stream().max(Integer::compareTo);
        // 自定义排序
        Optional<Integer> max2 = list.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("自然排序的最大值：" + max.get());
        System.out.println("自定义排序的最大值：" + max2.get());
    }
    @Test
    public void testCount(){
        List<Integer> list = Arrays.asList(1, 5, 9, 7, 25, 13, 8);
        System.out.println("大于6的个数："+list.stream().filter(x -> x > 6).count());
    }
    @Test
    public void testToUpperCase(){
        String[] strArr = {"abcd","bcdd","pig","java"};
        List<String> strList = Arrays.stream(strArr).map(String::toUpperCase).collect(Collectors.toList());
        List<Integer> list = Arrays.asList(1, 2, 5, 8, 55, 15, 98);
        List<Integer> newList = list.stream().map(x -> x + 3).collect(Collectors.toList());
        System.out.println(strList);
        System.out.println(newList);
    }
    @Test
    public void testMap(){
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));

        // 不改变原来员工集合的方式
        List<Person> personListNew = personList.stream().map(person -> {
            Person personNew = new Person(person.getName(), 0, 0, null, null);
            personNew.setSalary(person.getSalary() + 10000);
            return personNew;
        }).collect(Collectors.toList());
        System.out.println("一次改动前：" + personList.get(0).getName() + "-->" + personList.get(0).getSalary()+"-->"+personList.get(0).getAge());
        System.out.println("一次改动后：" + personListNew.get(0).getName() + "-->" + personListNew.get(0).getSalary()+"-->"+personListNew.get(0).getAge());

        // 改变原来员工集合的方式
        List<Person> personListNew2 = personList.stream().map(person -> {
            person.setSalary(person.getSalary() + 10000);
            return person;
        }).collect(Collectors.toList());
        System.out.println("二次改动前：" + personList.get(0).getName() + "-->" + personListNew.get(0).getSalary());
        System.out.println("二次改动后：" + personListNew2.get(0).getName() + "-->" + personListNew.get(0).getSalary());
    }
    @Test
    public void toNewStream(){
        List<String> list = Arrays.asList("m,k,l,a", "1,3,5,7");
        System.out.println(list.stream().collect(Collectors.toList()).size());
        List<String> listNew = list.stream().flatMap(s -> {
            String[] split = s.split(",");
            Stream<String> stream = Arrays.stream(split);
            return stream;
        }).collect(Collectors.toList());
        System.out.println(list+"----->"+list.size());
        System.out.println(listNew+"----->"+listNew.size());
    }
    @Test
    public void testReduce(){
                List<Integer> list = Arrays.asList(1, 3, 2, 8, 11, 4);
                // 求和方式1
                Optional<Integer> sum = list.stream().reduce((x, y) -> x + y);
                // 求和方式2
                Optional<Integer> sum2 = list.stream().reduce(Integer::sum);
                // 求和方式3
                Integer sum3 = list.stream().reduce(0, Integer::sum);

                // 求乘积
                Optional<Integer> product = list.stream().reduce((x, y) -> x * y);

                // 求最大值方式1
                Optional<Integer> max = list.stream().reduce((x, y) -> x > y ? x : y);
                // 求最大值写法2
                Integer max2 = list.stream().reduce(1, Integer::max);

                System.out.println("list求和：" + sum.get() + "," + sum2.get() + "," + sum3);
                System.out.println("list求积：" + product.get());
                System.out.println("list求和：" + max.get() + "," + max2);
    }
    @Test
    public void testReduce2(){
                List<Person> personList = new ArrayList<Person>();
                personList.add(new Person("Tom", 8900, 23, "male", "New York"));
                personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
                personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
                personList.add(new Person("Anni", 8200, 24, "female", "New York"));
                personList.add(new Person("Owen", 9500, 25, "male", "New York"));
                personList.add(new Person("Alisa", 7900, 26, "female", "New York"));

                // 求工资之和方式1：
                Optional<Integer> sumSalary = personList.stream().map(Person::getSalary).reduce(Integer::sum);
                // 求工资之和方式2：
                Integer sumSalary2 = personList.stream().reduce(0, (sum, p) -> sum += p.getSalary(),
                        (sum1, sum2) -> sum1 + sum2);
                // 求工资之和方式3：
                Integer sumSalary3 = personList.stream().reduce(0, (sum, p) -> sum += p.getSalary(), Integer::sum);

                // 求最高工资方式1：
                Integer maxSalary = personList.stream().reduce(0, (max, p) -> max > p.getSalary() ? max : p.getSalary(),
                        Integer::max);
                // 求最高工资方式2：
                Integer maxSalary2 = personList.stream().reduce(0, (max, p) -> max > p.getSalary() ? max : p.getSalary(),
                        (max1, max2) -> max1 > max2 ? max1 : max2);

                System.out.println("工资之和：" + sumSalary.get() + "," + sumSalary2 + "," + sumSalary3);
                System.out.println("最高工资：" + maxSalary + "," + maxSalary2);

    }
    @Test
    public void testCollect(){
                List<Integer> list = Arrays.asList(1, 6, 3, 4, 6, 7, 9, 6, 20);
                List<Integer> listNew = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
                Set<Integer> set = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toSet());

                List<Person> personList = new ArrayList<Person>();
                personList.add(new Person("Tom", 8900, 23, "male", "New York"));
                personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
                personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
                personList.add(new Person("Anni", 8200, 24, "female", "New York"));

                Map<?, Person> map = personList.stream().filter(p -> p.getSalary() > 8000)
                        .collect(Collectors.toMap(Person::getName, p -> p));
                System.out.println("toList:" + listNew);
                System.out.println("toSet:" + set);
                System.out.println("toMap:" + map);
    }
}
