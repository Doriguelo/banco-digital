package service;

import exception.InsufficientBalanceException;
import model.Account;
import model.CurrentAccount;
import model.Customer;
import model.SavingsAccount;
import util.AccountNumberGenerator;

import java.util.HashMap;
import java.util.Map;

public class BankService implements Bank{

    private Map<Integer, Account> accounts = new HashMap<>();

    @Override
    public Account createAccount(Customer customer, String type) {
        int number = AccountNumberGenerator.generateNumber();
        Account account;

        if (type.trim().equalsIgnoreCase("Current Account")) {
            account = new CurrentAccount(customer, number);
        } else {
            account = new SavingsAccount(customer, number);
        }
        accounts.put(number, account);
        return account;
    }

    @Override
    public Account searchAccount(int number) {
        return accounts.get(number);
    }

    @Override
    public void listAccounts() {
        accounts.values()
                .forEach(System.out::println);
    }

    @Override
    public void deleteAccount(int number) {
        Account removed = accounts.remove(number);
        if (removed == null) {
            throw new IllegalArgumentException("Account " + number + " not found!");
        }
    }

    @Override
    public void deposit(int number, double value) {
        Account account = searchAccount(number);
        if (account != null) {
            account.deposit(value);
        } else {
            throw new IllegalArgumentException("Account: " + number + " not found!");
        }
    }

    @Override
    public void withDraw(int number, double value) throws InsufficientBalanceException {
        Account account = searchAccount(number);
        if (account != null) {
            account.withDraw(value);
        } else {
        throw new IllegalArgumentException("Account " + number + " not found!");
        }
    }

    @Override
    public void transfer(int origin, int destiny, double value) throws InsufficientBalanceException {
        Account originAccount = searchAccount(origin);
        Account destinyAccount = searchAccount(destiny);

        if (originAccount != null && destinyAccount != null) {
            originAccount.transfer(destinyAccount, value);
        }
    }
}
