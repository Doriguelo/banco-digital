package model;

import exception.InsufficientBalanceException;

public class CurrentAccount extends Account{

    public CurrentAccount(Customer accountHolder, int number) {
        super(accountHolder, number);
    }

    @Override
    public void withDraw(double value) throws InsufficientBalanceException {
        double rate = 1.0;
        super.withDraw(value + rate);
    }

    @Override
    public void transfer(Account destiny, double value) throws InsufficientBalanceException {
        double rate = 1.0;
        super.withDraw(value + rate);
        destiny.deposit(value);
    }

    public void printExtract() {
        System.out.println("=== Extract Current Account ===");
        System.out.println(super.toString());
    }
}
