package service;

import model.Account;
import model.Customer;

import java.util.List;

public interface Bank {
    Account createAccount(Customer customer, String type);
    Account searchAccount(int number);
    List<Account> listAccounts();
    void deleteAccount(int number);
}
