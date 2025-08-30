package service;

import exception.InsufficientBalanceException;
import model.Account;
import model.Customer;

public interface Bank {
    Account createAccount(Customer customer, String type);
    Account searchAccount(int number);
    void listAccounts();
    void deleteAccount(int number);
    void deposit(int number, double value);
    void withDraw(int number, double value) throws InsufficientBalanceException;
    void transfer(int origin, int destiny, double value) throws InsufficientBalanceException;
}
