package com.cmdglobal.lesson5;

public class Main {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("An", 1000);
        savings.showBalance();
        savings.withdraw(300);
        savings.showBalance();
        savings.deposit(500);
        savings.showBalance();
        savings.deposit(10, "USD");
        savings.showBalance();

        System.out.println("--------------------");

        CurrentAccount current = new CurrentAccount("Nam", 2000);
        current.showBalance();
        current.withdraw(7000);
        current.showBalance();
        current.deposit(1000);
        current.showBalance();
        current.deposit(20, "EUR");
        current.showBalance();
    }
}
