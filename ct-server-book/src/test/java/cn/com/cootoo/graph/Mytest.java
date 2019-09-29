package cn.com.cootoo.graph;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author zhaoxiang
 * @create 2019/2/15
 **/
public class Mytest {

    @Test
    public void testFlapMap1() {
        String[] arr1 = {"a", "b", "c", "d"};
        String[] arr2 = {"e", "f", "c", "d"};
        String[] arr3 = {"h", "j", "c", "d"};
        System.out.println("print stm--1");
        Stream.of(arr1, arr2, arr3).flatMap(x -> Arrays.stream(x)).forEach(System.out::println);
        System.out.println("print stm--2");
        Stream.of(arr1, arr2, arr3).flatMap(Arrays::stream).forEach(System.out::println);
        System.out.println("print stm--3");
        Stream.of(arr1, arr2, arr3).flatMap(Arrays::stream).distinct().forEach(System.out::println);
        System.out.println("print stm--4");
        Stream.of(arr1, arr2, arr3).flatMap(Arrays::stream).distinct().sorted().forEach(System.out::println);

    }

}
