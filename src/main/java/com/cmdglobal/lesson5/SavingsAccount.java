package com.cmdglobal.lesson5;

public class SavingsAccount extends BankAccount implements Transaction {
    private static final double MIN_BALANCE = 500;

    public SavingsAccount(String accountHolder, double balance) {
        super(accountHolder, balance);
    }


    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("amount must be greater than 0!");
        }

    }

    public void deposit(double amount, String currency) {
        double convertedAmount = convertCurrency(amount, currency);
        balance += convertedAmount;
        System.out.println("Deposited " + convertedAmount + " after currency conversion.");
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0) {
            if (balance - amount >= MIN_BALANCE) {
                balance -= amount;
                System.out.println("Withdrawn " + amount + " from Current Account.");
            } else {
                System.out.println("Withdrawal declined. Overdraft limit exceeded.");
            }
        } else {
            System.out.println("amount must be greater than 0!");
        }
    }


}
