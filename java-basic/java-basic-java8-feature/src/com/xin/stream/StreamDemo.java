package com.xin.stream;

import com.xin.domain.User;

import java.time.Year;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * java 8 新特性学习
 *      Stream : 方便对集合进行操作
 */
public class StreamDemo {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("Hello World!");
        int[] arr = {1,2,3,4,7};
        for(int i = 0;i < arr.length;i++){
            System.out.println("===" + arr[i]);
        }

        System.out.println("================ 关于数组初始化 ================");

        int[] ints = new int[5];
        /**
         * java 中的数组会默认进行初始化; 不同于c语言中的数组
         */
        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
        }
        /**************************************************
         * 黑马:
         *
         *
         *
         **************************************************/

        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User(i, "number:" + String.valueOf(i));
            users.add(user);
        }

        Stream<User> stream = users.stream();
        /**
         *
         */
        System.out.println("===================== 函数式接口 =====================");
        consumerString(
                x -> System.out.println(x.toUpperCase()),
                x -> System.out.println(x.toLowerCase()),
                "wuJiaQi"
        );

        String s = supplierString(
                () -> "hello"
        );
        System.out.println("s = " + s);

        // 有点不清晰
        int calculate = Calculate(10, 11,
                (a, b) -> a + b
        );


    }
    // 生产是接口
    public static String supplierString(Supplier<String> s){
        return s.get();
    }

    // 消费式接口
    public static void consumerString(Consumer<String> one, Consumer<String> two, String xString) {
        one.andThen(two).accept(xString);
    }

    // 自定义函数式接口
    public static int Calculate(int c,int d,Calculate a){
       return a.Calculate(c,d);
    }

}
@FunctionalInterface
interface Calculate{
    int Calculate(int a, int b);
}
