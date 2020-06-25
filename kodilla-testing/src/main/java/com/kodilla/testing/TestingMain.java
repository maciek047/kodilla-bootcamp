package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args){
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")){
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        Calculator calc = new Calculator();
        int a = 7;
        int b = 4;

        int addition_result = calc.add(a,b);
        int subtraction_result = calc.subtract(a,b);

        if (addition_result == (a+b)){
            System.out.println("addition OK");
        } else {
            System.out.println("addition Error!");
        }

        if (subtraction_result == (a-b)){
            System.out.println("subtraction OK");
        } else {
            System.out.println("subtraction Error!");
        }

    }
}