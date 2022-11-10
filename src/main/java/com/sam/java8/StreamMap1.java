package com.sam.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMap1 {

    public static void main(String[] args) {

        List<String> alpha = Arrays.asList("Monkey", "Lion", "Giraffe", "Lemur");

        //不使用Stream
        List<String> alphaUpper = new ArrayList<>();
        for (String s : alpha) {
            alphaUpper.add(s.toUpperCase());
        }

        System.out.println(alphaUpper);

        List<String> collect = alpha.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        //效果是一樣的
        List<String> collect1 = alpha.stream()
                .map(x -> x.toUpperCase())
                .collect(Collectors.toList());

        System.out.println(collect);
        System.out.println(collect1);

        /*
            MAP：
            資料的轉換。當你有一個方法(method)它的用途會將某個輸入資料轉換成另一個資料輸出時，map 可以讓你使用這個方法。
         */

        alpha.stream()
                .mapToDouble(String::length)
                .forEach(System.out::println);
    }
}
