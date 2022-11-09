package com.sam.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.function.Predicate;

@Data
@AllArgsConstructor
public class Employee {

    private Integer id;
    private Integer age;
    private String gender;
    private String firstName;
    private String lastName;

    //謂詞邏輯
    public static Predicate<Employee> ageGreaterThan70 = x -> x.getAge() > 70;
    public static Predicate<Employee> genderM = x -> x.getGender().equals("M");
}
