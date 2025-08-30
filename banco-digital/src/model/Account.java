package model;

import exception.InsufficientBalanceException;

public abstract class Account implements BankingOperations {

    private static final int DEFAULT_AGENCY = 1;

    protected int agency;
    protected int number;
    protected double balance;
    protected Customer accountHolder;

    public Account(Customer accountHolder, int number) {
        this.agency = Account.DEFAULT_AGENCY;
        this.number = number;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
    }

    @Override
    public void deposit(double value) {
        if (value <= 0.0) {
            throw new IllegalArgumentException("Value must be greater than zero!");
        }
        setBalance(getBalance() + value);
    }

    @Override
    public void withDraw(double value) throws InsufficientBalanceException {
        if (value > getBalance()) {
            throw new InsufficientBalanceException("Insufficient balance to withdraw R$ " + value);
        }
        if (value <= 0.0) {
            throw new IllegalArgumentException("Value must be greater than zero!");
        }
        setBalance(getBalance() - value);
    }

    @Override
    public void transfer(Account destiny, double value) throws InsufficientBalanceException {
        if (value <= 0.0) {
            throw new IllegalArgumentException("Value must be greater than zero!");
        }
        if (value > this.getBalance()) {
            throw new InsufficientBalanceException("Insufficient balance to transfer R$ " + value);
        }
        this.setBalance(this.getBalance() - value);
        destiny.setBalance(destiny.getBalance() + value);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Agency: " + agency + " | Account number: " + number + " | Balance: " + balance + " | Account holder: " + accountHolder;
    }
}