package com.xin.optional;

import java.util.Optional;

/**
 * java 8 新特性学习
 *      optional的使用
 *      optional是从其他Google的guava工具中引入的一个新的特性
 *      主要用于避免空指针异常
 *
 * @author Y1nzm
 * @Date 2019/12/24
 */
public class OptionalDemo {

    public static void main(String[] args) {
        System.out.println("学习开始了~~~~~~~~~~~~~~");
        Integer integer = 7888;
        Integer integer1 = null;

        // 值可以为null
        Optional.ofNullable(integer1).ifPresent(System.out::println);
        Optional.ofNullable(integer).ifPresent(System.out::println);

        Integer integer2 = Optional.ofNullable(integer1).orElse(0);
        System.out.println("integer2 = " + integer2);

        // 值不能为空
        //Optional.of(integer).ifPresent(System.out::println);

        Optional<Integer> demo = Optional.ofNullable(integer1);
        demo.orElseThrow(()-> new RuntimeException());


    }
}
