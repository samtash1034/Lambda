package com.sam.java8;


import com.sam.model.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortList {

    public static void main(String[] args) {
        List<String> cities = Arrays.asList(
                "Milan",
                "london",
                "San Francisco",
                "Tokyo",
                "New Delhi"
        );
        System.out.println(cities);
        //[Milan, london, San Francisco, Tokyo, New Delhi]

        cities.sort(String.CASE_INSENSITIVE_ORDER);//insensitive：大小寫 不敏感
        System.out.println(cities);
        //[london, Milan, New Delhi, San Francisco, Tokyo]

        cities.sort(Comparator.naturalOrder());//自然排序(大寫排完再換小寫)
        System.out.println(cities);
        //[Milan, New Delhi, San Francisco, Tokyo, london]

        //Comparator：排序器

        Employee e1 = new Employee(1, 23, "M", "Rick", "Beethovan");
        Employee e2 = new Employee(2, 13, "F", "Martina", "Hengis");
        Employee e3 = new Employee(3, 43, "M", "Ricky", "Martin");
        Employee e4 = new Employee(4, 26, "M", "Jon", "Lowman");
        Employee e5 = new Employee(5, 19, "F", "Cristine", "Maria");
        Employee e6 = new Employee(6, 15, "M", "David", "Feezor");
        Employee e7 = new Employee(7, 68, "F", "Melissa", "Roy");
        Employee e8 = new Employee(8, 79, "M", "Alex", "Gussin");
        Employee e9 = new Employee(9, 15, "F", "Neetu", "Singh");
        Employee e10 = new Employee(10, 45, "M", "Naveen", "Jain");

        List<Employee> employees = Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);

        employees.sort(
                Comparator.comparing(Employee::getGender)//性別排序
                        .reversed()//先正序
                        .thenComparingInt(Employee::getAge)//在性別裡面對年齡排序(小到大)
                        .reversed()//年齡和性別 reversed(大到小)
        );

        //都是正序，不加reversed
        //都是倒敘，最後面加一個reversed
        //先倒序(加 reversed)，然後正序
        //先是正序(加 reversed)，然後倒序(reversed)

        employees.forEach(System.out::println);

        //自訂義排序規則
        employees.sort((em1,em2) -> {
            if(em1.getAge() == em2.getAge()){
                return 0;
            }
            return em1.getAge() - em2.getAge() > 0 ? -1:1;// -1 表示倒數
        });
        employees.forEach(System.out::println);
        System.out.println("-----------");
        employees.forEach(System.out::println);//年齡大到小
    }
}
