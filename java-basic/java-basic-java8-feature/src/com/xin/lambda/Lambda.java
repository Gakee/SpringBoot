package com.xin.lambda;

import com.xin.interf.FunctionInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * java 8 新特性的了解
 * java 8 的新特性主要是支持lambda 表达式
 */
public class Lambda {
    /*********************************************************************
     * 语法糖: 简便语法, 但是原理不变的语法
     *      eg: for-each循环
     *
     * lambda表达式的要求:
     *      1. 需要是函数式接口:
     *      即有有且仅一个抽象方法的接口;
     *
     *      2. 同时可以定义一个函数式接口(使用@FunctionalInterface)
     *
     * lambda的优点:
     *      1. 具有延迟执行效果(如果不满足条件不会执行),节省性能
     *      2. 如果参数是函数式接口可以使用lambda作为参数
     *         如果返回值是函数是接口,可以直接返回lambda简化书写
     *
     *  lambda的格式:
     *      (参数类型 参数名称) ‐> { 代码语句 }
     *      当参数类型相同时,可以直接通过反推得到,参数类型可以省略
     *      当参数只有一个时,参数类型和括号可以省略
     *      当大括号中只有一条语句是, 大括号可以省略,return也可以省略
     *
     *  常用的函数式接口
     *      1. Supplier接口(生产接口):
     *      2. 
     *
     *********************************************************************/
    public static void main(String[] args) {
        int[] arr = {8,7,9};
        // 外部比较器
        ArrayList<Student> list = new ArrayList<>();
        Student zhangsan = new Student(3, 4, "zhangsan");
        Student lisi = new Student(1, 3, "lisi");
        Student wa = new Student(1, 2, "wa");
        list.add(zhangsan);
        list.add(lisi);
        list.add(wa);
        Collections.sort(list,(o,o2)-> o2.id - o.id);
//        list.sort();
        System.out.println("list = " + list);
        //========================================================================//
        ArrayList<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher("kk",10));
        teachers.add(new Teacher("bb",7));
        teachers.add(new Teacher("k",5));
        teachers.add(new Teacher("a",11));

        Collections.sort(teachers);
        System.out.println("============================================");
        System.out.println("teachers = " + teachers);

        System.out.println("============ lambda 作为参数=================");
        /**
         * 注意: lambda作为参数的时候, lambda的参数别和参数的参数混淆
         *
         * lambda的参数是指需要重写方法的参数
         */
        start(()-> System.out.println("任务执行了.........."));

    }
    /** 返回一个外部比较器**/
    public static Comparator<String> newComparator(){
        return Comparator.comparingInt(String::length);
    }

    public static Comparator<Student> newComparator1(){ //inferred 推断
        return (a,b)->a.id - b.id;
    }



    public static void test(FunctionInterface a){
        System.out.println("?????????");
    }

    public static void start(Runnable task){
        new Thread(task).start();
    }

    static class Student{
        private Integer age;

        private Integer id;

        private String name;

        public Student(){};

        public Student(Integer age, Integer id, String name) {
            this.age = age;
            this.id = id;
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "age=" + age +
                    ", id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    static class Teacher implements Comparable{
        String name;
        Integer id;

        @Override
        public String toString() {
            return "Teacher{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Teacher(String name, Integer id) {

            this.name = name;
            this.id = id;
        }

        @Override
        public int compareTo(Object o) {
            return this.id - ((Teacher) o).id;
        }
    }



}
