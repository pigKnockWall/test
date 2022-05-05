package com.example.demo.MpTest;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Student;
import com.example.demo.entity.User;
import com.example.demo.mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentTest {
    @Autowired
    private StudentMapper studentMapper;
    @Test
    public void testInsertStudent(){
        Student student = new Student();
        student.setAge(22);
        student.setEmail("84515@eekjsdjfok");
        student.setStatus("1");
        student.setName("猪撞墙");
        int i = studentMapper.insertStudent(student);
    }
    @Test
    public void testAllEq(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        Map<String,Object> param =new HashMap<>();
        param.put("name","张三");
        param.put("age",22);
        param.put("status",1);
        qw.allEq(param);
        List<Student> students = studentMapper.selectList(qw);
        students.forEach(stu-> System.out.println(stu));
        System.out.println(students);
    }
    @Test
    public void testAllEq2() {
        QueryWrapper<Student> qw = new QueryWrapper<>();
        //组装条件
        Map<String, Object> param = new HashMap<>();
        //map<key,value> key列名 , value：查询的值
        param.put("name", "张三");
        //age 是 null
        param.put("age", null);

        //allEq第二个参数为true
        qw.allEq(param, true);

        //调用MP自己的查询方法
        List<Student> students = studentMapper.selectList(qw);
        students.forEach(stu -> System.out.println(stu));
    }
    @Test
    public void testEq(){
        QueryWrapper<Student> qw =new QueryWrapper<>();
        qw.eq("name","张三");
        List<Student> students = studentMapper.selectList(qw);
        System.out.println(students);
        students.forEach(stu-> System.out.println("查询eq:"+stu));
        LambdaQueryWrapper<Student> qw2 = new LambdaQueryWrapper<>();
        qw2.eq(Student::getName,"张三").eq(Student::getAge,18);
        List<Student> students1 = studentMapper.selectList(qw2);
        System.out.println("使用lambda表达式拼装查询条件"+students1);
    }
    @Test
    public void testNe(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.ne("name","张三");
        List<Student> students = studentMapper.selectList(qw);
        students.forEach(stu-> System.out.println("普通方式条件查询"+stu));
        System.out.println("----------------lambda方式拼接查询条件----------------");
        LambdaQueryWrapper<Student> wq = new LambdaQueryWrapper<>();
        wq.ne(Student::getAge,22).eq(Student::getName,"付志强");
        List<Student> students1 = studentMapper.selectList(wq);
        students1.forEach(stu-> System.out.println(stu));
    }
    @Test
    public void testGt(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.ge("age","18");
        List<Student> students = studentMapper.selectList(qw);
        students.forEach(stu-> System.out.println("测试"+stu));
    }
    @Test
    public void testLt(){
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.le("age",18);
        List<Student> students = studentMapper.selectList(queryWrapper);
        System.out.println(students);
        students.forEach(stu-> System.out.println("测试"+stu));
    }
    @Test
    public void testNotBetween(){
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.notBetween("age",18,22);
        List<Student> students = studentMapper.selectList(queryWrapper);
        students.forEach(stu-> System.out.println(stu));
    }
    @Test
    public void testLike(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        /*qw.like("name","付");
        List<Student> students = studentMapper.selectList(qw);
        System.out.println(students);*/

        /*qw.notLike("name","付");
        List<Student> students1=studentMapper.selectList(qw);
        System.out.println(students1);*/
        qw.likeLeft("name","强");
        List<Student> students = studentMapper.selectList(qw);
        System.out.println(students);
    }
    @Test
    public void testIsNull(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.isNull("age");
        print(qw);
    }
    private void print(QueryWrapper qw){
        List<Student> students = studentMapper.selectList(qw);
        students.forEach(student -> System.out.println(student));
    }
    @Test
    public void testIsNotNull(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.isNotNull("age");
        print(qw);
    }
    @Test
    public void testIn(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.in("name","张三","李四","付志强");
        print(qw);
    }
    @Test
    public void testInSql(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.inSql("age","select age from student where id = 3");
        print(qw);
    }
    @Test
    public void testGroupByName(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.select("name,count(*) personNumbers");
        qw.groupBy("name");
        print(qw);
    }
    @Test
    public void testOr(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.eq("name","付志强").or().eq("age","18");
        print(qw);
    }
    @Test
    public void testNotExist(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.exists("select * from student where age > 90");
        print(qw);
    }
    @Test
    public void testPage(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.gt("age",22);
        IPage<Student> page = new Page<>();
        page.setCurrent(1);
        page.setSize(2);
        IPage<Student> result = studentMapper.selectPage(page,qw);
        System.out.println("测试第一"+result.toString());

        List<Student> students = result.getRecords();
        System.out.println("students.size()="+students.size());
        students.forEach(stu-> System.out.println(stu));


        System.out.println("页数"+result.getPages());
        System.out.println("总记录数"+result.getTotal());
        System.out.println("当前页码"+result.getCurrent());
        System.out.println("每页的记录数"+result.getSize());
    }
    @Test
    public void testPage2(){

        IPage<Student> iPage = new Page<>(1,3);
        IPage<Student> students = studentMapper.selectPage(iPage, null);
        System.out.println("返回总数"+students.getTotal());
        System.out.println(students.getCurrent());
        System.out.println(students.getSize());
        System.out.println(students.getRecords());
    }
    @Test
    public void testPageHelper(){

    }

    @Test
    public void testClone(){
        Student s1 = new Student(1l,"猪撞墙1",18,"1617938838Wee","0");
        System.out.println(s1);
        System.out.println(s1.getClass().getSuperclass().getInterfaces().length);
        System.out.println(Integer.toBinaryString(40));
        System.out.println(Integer.toHexString(40));
        String s2 = "fjajfa";
        System.out.println(s2.charAt(1));
        Character a = new Character('A');
        Character a2 = new Character('A');
        System.out.println(a.compareTo(a2));
        System.out.println(new Byte("15").byteValue());
        System.out.println();
    }

    @Test
    public void testSystem(){
        System.out.println("请输入字符，按回车键结束输入:");
        int c;
        try {
            c = System.in.read();    // 读取输入的字符
            while(c != '\r') {    // 判断输入的字符是不是回车
                System.out.print((char) c);    // 输出字符
                c = System.in.read();
            }
        } catch(IOException e) {
            System.out.println(e.toString());
        } finally {
            System.err.println();
        }
    }

    @Test
    public void testSystem2(){
        String jversion = System.getProperty("java.version");
        String oName = System.getProperty("os.name");
        String user = System.getProperty("user.name");
        System.out.println("Java 运行时环境版本："+jversion);
        System.out.println("当前操作系统是："+oName);
        System.out.println("当前用户是："+user);
        System.out.println(System.getProperty("java.home"));
        System.out.println(System.getProperty("user.home"));

    }
    @Test
    public void testException() {
        System.out.println("请输入您的选择：（1~3 之间的整数）");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        switch (num) {
            case 1:
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                break;
            case 3:
                System.out.println("three");
                break;
            default:
                System.out.println("error");
                break;
        }
    }

    @Test
    public void testError(){
        int i = 5;
        if (i == 0) {
            return;
        } else {
            testError();
        }
    }

    @Test
    public void testFx(){
        List list = new ArrayList();
    }
}
