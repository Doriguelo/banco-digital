package model;

public interface BankingOperations {
    void deposit(double value);
    void withDraw(double value);
    void transfer(Account destiny, double value);
}