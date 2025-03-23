package com.cmdglobal.lesson5;

public abstract class BankAccount {
    public String accountHolder;
    public double balance;

    public BankAccount() {
    }

    public BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public abstract void withdraw(double amount);

    public void showBalance() {
        System.out.println("AccountHolder:" + accountHolder);
        System.out.println("Balance: " + balance);
    }
    public double convertCurrency(double amount, String currency) {
        switch (currency) {
            case "USD" -> {
                return amount * 24_000;
            }
            case "EUR" -> {
                return amount * 26_000;
            }
            default -> {
                System.out.println("Currency not found!");
                return amount;
            }
        }
    }
}
