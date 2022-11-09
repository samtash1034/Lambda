package com.sam.java8;

import java.util.Arrays;
import java.util.List;

public class LambdaDemo1 {

    interface Printer{
        void printer(String val);
    }

    public void printSomething(String something, Printer printer){
        printer.printer(something);
    }

    public static void main(String[] args) {

        LambdaDemo1 lambdaDemo1 = new LambdaDemo1();
        String something = "today is tuesday";

//        Printer printer = new Printer() {
//            @Override
//            public void printer(String val) {
//                System.out.println(val);
//            }
//        };

//        Printer printer = (String val) -> {
//            System.out.println(val);
//        };

        //省略類型他會自己去推斷
//        Printer printer = (val) -> {
//            System.out.println(val);
//        };

        //只有一個參數可以把()拿掉
//        Printer printer = val -> {
//            System.out.println(val);
//        };

        //方法裡面只有一行可以這樣寫
//        Printer printer = val -> System.out.println(val);


//        lambdaDemo1.printSomething(something, printer);

//        lambdaDemo1.printSomething(something, val -> System.out.println(val));
        lambdaDemo1.printSomething(something, System.out::println);


    }
}
