package com.sam.java8;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortMap {

    public static void main(String[] args) {

        String key = "key";
        HashMap<String, Integer> map = new HashMap<String, Integer>(){{
           put(key, 1);
        }};
        //參數：向map裡面put的鍵、向map裡面put的值、如果鍵發生重複，如何處理值。可以是一個函數，也可以寫成lambda表達式
        map.merge(key, 2, (oldVal, newVal) -> oldVal + newVal);
        System.out.println(map);////{key=3}

        Map<String, Integer> codes = new HashMap<>();
        codes.put("United States", 1);
        codes.put("Germany", 49);
        codes.put("France", 33);
        codes.put("China", 86);
        codes.put("Pakistan", 92);

        //按照 map 的鍵進行排序
        Map<String, Integer> sortedMap = codes.entrySet().stream()//Map類型轉換為Stream流類型。
                .sorted(Map.Entry.comparingByKey())//使用sorted方法排序，排序的依據是Map.Entry.comparingByKey()，也就是按照Map的鍵排序
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (oldVal, newVal) -> oldVal,
                                LinkedHashMap::new
                        )
                );
        //將排序後的 Map 印出
        sortedMap.entrySet().forEach(System.out::println);
    }
}
