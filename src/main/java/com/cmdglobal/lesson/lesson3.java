package com.cmdglobal.lesson;

import java.util.Random;

public class lesson3 {
    public static void printName(int number) {
        if (number == 0) {
            System.out.println(number);
        } else if (number % 3 == 0 && number % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (number % 3 == 0) {
            System.out.println("Fizz");
        } else if (number % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(number);
        }

    }

    public static int checkGuesss(int trueNumber) {

        int index = 1;
        System.out.println("Enter your guess:");
        int guess = lesson2.enterIntegerNotNegative();
        do  {
            float temp = (float) guess / trueNumber;
            if (temp > 1) {
                System.out.println("Too high! Try again.");
            } else if (temp < 1) {
                System.out.println("Too low! Try again.");
            }
            index++;
            System.out.println("Enter your guess:");
            guess = lesson2.enterIntegerNotNegative();

        }while ((guess != trueNumber));
        System.out.println("Correct! The number was: " + guess);
        return index;
    }

    public static void exercise3() {
        System.out.println("Welcome to the Guess the Number Game!");
        System.out.println("Choose a difficulty level:\n" +
                "1. Easy (1-50)\n" +
                "2. Medium (1-100)\n" +
                "3. Hard (1-1000)\n" +
                "Enter your choice (1/2/3): ");

        int chose = lesson2.enterIntegerNotNegative();
        Random random = new Random();
        int trueNumber = 0;
        int index = 0;
        switch (chose) {
            case 1 -> {
                trueNumber = random.nextInt(50);
                index = checkGuesss(trueNumber);
                System.out.println("It took you " + index + " attempts.");
            }
            case 2 -> {
                trueNumber = random.nextInt(100);
                index = checkGuesss(trueNumber);
                System.out.println("It took you " + index + " attempts.");
            }
            case 3 -> {
                trueNumber = random.nextInt(1000);
                index = checkGuesss(trueNumber);
                System.out.println("It took you " + index + " attempts.");
            }
        }
    }

    // Check range grade:
    public static void exercise2() {
        System.out.println("Enter grade: ");
        int grade = lesson2.enterInteger();
        String result = switch (grade / 10) {
            case 10, 9 -> "A";
            case 8 -> "B";
            case 7 -> "C";
            case 6 -> "D";
            default -> "F";
        };
        System.out.println("Your grade is " + result);
    }

    // check multiple 3 or 5
    public static void exercise1() {
        for (int i = 0; i < 100; i++) {
            printName(i);
        }
    }

    public static void main(String[] args) {
        System.out.println("--------------------exercise1-------------------");
        exercise1();
        System.out.println("--------------------exercise2-------------------");
        exercise2();
        System.out.println("--------------------exercise3-------------------");
        exercise3();
    }
}
