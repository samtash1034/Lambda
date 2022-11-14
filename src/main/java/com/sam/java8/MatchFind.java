package com.sam.java8;

import com.sam.model.Employee;

import java.util.Arrays;
import java.util.List;

//stream 查找與匹配元素
public class MatchFind {

    public static void main(String[] args) {
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

        boolean isExistAgeThan70 = false;
        for (
                Employee employee : employees) {
            if (employee.getAge() > 70) {
                isExistAgeThan70 = true;
                break;
            }
        }

        System.out.println(isExistAgeThan70);

        isExistAgeThan70 = employees.stream()
                .anyMatch(e -> e.getAge() >= 80);
        System.out.println(isExistAgeThan70);

        //謂詞的用法
        isExistAgeThan70 = employees.stream().anyMatch(Employee.ageGreaterThan70);
        System.out.println(isExistAgeThan70);

        isExistAgeThan70 = employees.stream()
                .allMatch(e -> e.getAge() > 10);
        System.out.println("1：" + isExistAgeThan70);

        isExistAgeThan70 = employees.stream()
                .noneMatch(e -> e.getAge() < 18);//只要有一個存在返回 false
        System.out.println(isExistAgeThan70);

        Employee employee = employees.stream()
                .filter(e -> e.getAge() > 40)
                .findFirst()
                .orElse(null);

        //findAny findFirst 都是返回 optional

//                .isPresent()//返回boolean
//        .ifPresent(e -> System.out.println(e));//印出來
//        System.out.println(first.get());//不存在則拋異常
//        System.out.println(first.orElse(null));//不存在回傳 null
//        System.out.println(isExistAgeThan70);
    }

}
