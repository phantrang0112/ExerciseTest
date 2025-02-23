package com.cmdglobal.lesson;

import java.util.Scanner;

public class lesson2 {
    public static Scanner scanner = new Scanner(System.in);

    public static int addition(int x, int y) {
        return x + y;
    }

    public static int subtraction(int x, int y) {
        return x - y;
    }

    public static int multiplication(int x, int y) {
        return x * y;
    }

    public static float division(int x, int y) {
        return (float) x / y;
    }

    public static int enterInteger() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Input must is integer!");
            scanner = new Scanner(System.in);
            return enterInteger();
        }
    }

    public static int enterIntegerNotNegative() {
        int input = enterInteger();
        while (input <= 0) {
            System.out.println("Input can't be less or equal 0!");
            input = enterInteger();
        }
        return input;
    }

    public static float enterFloat() {
        try {
            return scanner.nextFloat();
        } catch (Exception e) {
            System.out.println("Input must is integer!");
            scanner = new Scanner(System.in);
            return enterFloat();
        }
    }

    public static float enterFloatNotNegative() {
        float input = enterFloat();
        while (input <= 0) {
            System.out.println("Input can't be less or equal 0!");
            input = enterFloat();
        }
        return input;
    }

    public static int enterY() {
        int y = enterInteger();
        while (y == 0) {
            System.out.println("input can't be 0!");
            y = enterInteger();
        }
        return y;
    }

    public static float convertFahrenheit(float celsius) {
        return (float) (celsius * (9 / 5)) + 32;
    }

    public static float getBMI(float weight, float height) {
        return weight / (height * height);
    }

    public static boolean checkLeapYear(int year) {
        if ((year % 4) == 0) {
            if ((year % 100) == 0) {
                return year % 400 == 0;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void exercise1() {
        System.out.println("Enter input x:");
        int x = enterInteger();
        System.out.println("Enter input y:");
        int y = enterY();
        System.out.println("Addition:" + addition(x, y));
        System.out.println("Subtraction:" + subtraction(x, y));
        System.out.println("Multiplication:" + multiplication(x, y));
        System.out.println("Division:" + division(x, y));
    }

    public static void exercise2() {
        System.out.println("Enter temperature in Celsius:");
        float celsius = enterFloat();
        System.out.println("Temperature in Fahrenheit:" + convertFahrenheit(celsius));
    }

    public static void exercise3() {
        System.out.println("Enter Weight:");
        float weight = enterFloatNotNegative();
        System.out.println("Enter height:");
        float height = enterFloatNotNegative();
        System.out.println("BMI:" + getBMI(weight, height));
    }

    public static void exercise4() {
        System.out.println("Enter an integer:");
        int input = enterInteger();
        System.out.println("After incrementing:" + input++);
        System.out.println("After decrementing:" + input--);
    }

    public static void exercise5() {
        System.out.println("Enter a year:");
        int year = enterIntegerNotNegative();
        if (checkLeapYear(year)) {
            System.out.println(year + " is a leap year.");
        } else {
            System.out.println(year + " is not a leap year.");
        }
    }

    public static void main(String[] args) {
        System.out.println("--------------------- exercise1 -------------------");
        exercise1();
        System.out.println("--------------------- exercise2 -------------------");
        exercise2();
        System.out.println("--------------------- exercise3 -------------------");
        exercise3();
        System.out.println("--------------------- exercise4 -------------------");
        exercise4();
        System.out.println("--------------------- exercise5 -------------------");
        exercise5();
    }
}
