package model;

import exception.InsufficientBalanceException;

public class SavingsAccount extends Account {

    private int freeWithDraw = 2;

    public SavingsAccount(Customer accountHolder, int number) {
        super(accountHolder, number);
    }

    @Override
    public void withDraw(double value) throws InsufficientBalanceException {
        if (freeWithDraw > 0) {
            freeWithDraw--;
            super.withDraw(value);
        } else {
            double rate = 2.0;
            super.withDraw(value + rate);
        }
    }

    @Override
    public void deposit(double value) {
        if (value < 50) {
            throw new IllegalArgumentException("Minimum savings deposit is R$ 50.");
        }
        super.deposit(value);
    }

    public void printExtract() {
        System.out.println("=== Savings Account Extract ===");
        System.out.println(super.toString());
    }
}
