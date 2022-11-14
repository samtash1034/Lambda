package com.sam.java8;

import com.sam.model.Employee;

import java.util.Arrays;
import java.util.List;

public class ReduceDemo {

    public static void main(String[] args) {

        //List 整數累加
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer total = numbers.stream()//reduce；減少
                //identity：0(初始值)
                .reduce(0, (subtotal, element) -> subtotal + element);
        System.out.println(total);

        Integer total1 = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println(total1);

        List<String> letters = Arrays.asList("a", "b", "c", "d", "e");
        String str = letters.stream()
                .reduce("", (subtotal, element) -> subtotal.concat(element));
        System.out.println(str);

        String str1 = letters.parallelStream()
                .reduce("", String::concat);
        System.out.println(str1);

        Employee e1 = new Employee(1,23,"M","Rick","Beethovan");
        Employee e2 = new Employee(2,13,"F","Martina","Hengis");
        Employee e3 = new Employee(3,43,"M","Ricky","Martin");
        Employee e4 = new Employee(4,26,"M","Jon","Lowman");
        Employee e5 = new Employee(5,19,"F","Cristine","Maria");
        Employee e6 = new Employee(6,15,"M","David","Feezor");
        Employee e7 = new Employee(7,68,"F","Melissa","Roy");
        Employee e8 = new Employee(8,79,"M","Alex","Gussin");
        Employee e9 = new Employee(9,15,"F","Neetu","Singh");
        Employee e10 = new Employee(10,45,"M","Naveen","Jain");


        List<Employee> employees = Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);

        Integer total3 = employees.parallelStream()//並行效率較高(當資料量大時)
                .map(Employee::getAge)//累加年齡
                .reduce(0, Integer::sum, Integer::sum);
        //初始值、累加器、合併器
        System.out.println(total3);

        Integer total4 = employees.parallelStream()
                .reduce(0, (subtotal, emp) -> subtotal + emp.getAge(), Integer::sum);//使用合併器(Integer::sum) 把 employee 類型轉成 int

        System.out.println(total4);

        /*
            合併器作用：
            1.把累加器的累加結果合併起來
            2.累加結果和類型不匹配的時候，做一個類型轉換
         */
    }

}
