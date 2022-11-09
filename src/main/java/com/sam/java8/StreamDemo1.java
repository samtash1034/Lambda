package com.sam.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo1 {

    public static void main(String[] args) {

        List<String> nameList = Arrays.asList("monkey", "lion", "rabbit", "elephant", "mouse");

        String[] name = {"monkey", "lion", "rabbit", "elephant", "mouse"};

        //陣列轉成流
//        Stream.of(name).filter().map()

        Set<String> nameSet = new HashSet<>();

//        for (String name : nameList) {
//            if(name.startsWith("m")){
//                String temp = name.toUpperCase();
//            }
//        }

//        Path path = Paths.get("file.txt");
//        //kobe
//        //james
//        //文件轉成流
//        try {
//            Files.lines(path).map().map
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        //也可以用 set
        List<String> list = nameList.stream()
                .filter(s -> s.startsWith("m"))
                .map(String::toUpperCase)
                .sorted()//裡面可以寫上排序規則
                .collect(Collectors.toList());//把stream 轉成 List

        System.out.println(list);
    }
}
