package com.sam.java8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamState {

    public static void main(String[] args) {
//        串行的好處是可以保證順序，但是通常情況下處理速度慢一些
//        並行的好處是對於元素的處理速度快一些（通常情況下），但是順序無法保證。這可能會導致進行一些有狀態操作的時候，最後得到的不是你想要的結果。

        //有狀態操作
        //parallel(平行)：通常stream都是一個取一個輸出，但parallel就可能一次取幾個然後隨機取，因此可能會導致順序不同
        //parallel 效能比較好，因為一次取多個
        //所以 parallel 不適合放在 有狀態操作
        //沒寫的話默認是 sequential(順序的)

        List<String> limitN = Stream.of("Monkey", "Lion", "Giraffe", "Lemur")
                .sequential()
                .limit(2)//取前面
                .collect(Collectors.toList());
        System.out.println(limitN);

        List<String> skipN = Stream.of("Monkey", "Lion", "Giraffe", "Lemur")
                .skip(2)//跳過前面
                .collect(Collectors.toList());
        System.out.println(skipN);

        List<String> uniqueAnimals = Stream.of("Monkey", "Lion", "Giraffe", "Lemur", "Lion")
                .distinct()
                .collect(Collectors.toList());
        System.out.println(uniqueAnimals);

        List<String> alphabeticOrder = Stream.of("Monkey", "Lion", "Giraffe", "Lemur")
                .parallel() //可能會導致順序亂掉( stream
                .sorted()
                .collect(Collectors.toList());
        System.out.println(alphabeticOrder);

//        從處理性能的角度，parallel()更適合處理ArrayList，而不是LinkedList。
//        因為ArrayList從數據結構上講是基於數組的，可以根據索引很容易的拆分為多個


        //使用普通for循環，執行效率是Stream串行流的2倍。也就是說普通for循環性能更好。
        //Stream並行(parallel) 流計算是普通for循環執行效率的4-5倍。
        //Stream並行流計算> 普通for循環> Stream串行流計算
    }
}
