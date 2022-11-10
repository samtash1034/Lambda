package com.sam.java8;

import java.util.Arrays;
import java.util.List;

public class StreamFlatMap {

    public static void main(String[] args) {

        List<String> words = Arrays.asList("hello", "world");
        words.stream()
                .map(w -> w.split(""))//stream 裡面還有 stream
                .forEach(System.out::println);

        //stream 裡面還有 stream ：分解每一個
        //java.util.stream.ReferencePipeline$Head@37a71e93
        //java.util.stream.ReferencePipeline$Head@7e6cbb7a

        //只有一個 stream ： 把兩個字母分開 (hello world)
//        [Ljava.lang.String;@728938a9
//        [Ljava.lang.String;@21b8d17c

        words.stream()
                .flatMap(w -> Arrays.stream(w.split("")))
                .forEach(System.out::print);
        //stream 裡面還有 stream 就要使用 flatMap(寫成for循環如果有兩個則用 flatMap)
        //helloworld
    }
}
