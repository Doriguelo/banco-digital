package application;

import exception.InsufficientBalanceException;
import model.Account;
import model.Customer;
import service.Bank;
import service.BankService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new BankService();

        while (true) {
            System.out.println("\n=== Banking System ===");
            System.out.println("1 - Create account");
            System.out.println("2 - Deposit");
            System.out.println("3 - Withdraw");
            System.out.println("4 - Transfer");
            System.out.println("5 - List accounts");
            System.out.println("6 - Delete account");
            System.out.println("7 - Exit");
            System.out.println("=====================");
            System.out.print("Choose an option: ");

            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1 -> {
                    System.out.print("Customer's name: ");
                    String name = sc.nextLine();

                    System.out.print("Account type (Current Account / Savings Account): ");
                    String type = sc.nextLine();

                    Customer customer = new Customer();
                    customer.setName(name);

                    Account account = bank.createAccount(customer, type);
                    System.out.println("Account created successfully! Number: " + account.getNumber());
                }
                case 2 -> {
                    System.out.print("Account number: ");
                    int number = sc.nextInt();
                    System.out.print("Deposit amount: ");
                    double value = sc.nextDouble();

                    try {
                        bank.deposit(number, value);
                        System.out.println("Deposit made successfully!");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> {
                    System.out.print("Account number: ");
                    int number = sc.nextInt();
                    System.out.print("Withdrawal amount: ");
                    double value = sc.nextDouble();

                    try {
                        bank.withDraw(number, value);
                        System.out.println("Successful withdrawal!");
                    } catch (IllegalArgumentException | InsufficientBalanceException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                case 4 -> {
                    System.out.print("Source account number: ");
                    int origin = sc.nextInt();
                    System.out.print("Destination account number: ");
                    int destiny = sc.nextInt();
                    System.out.print("Transfer value: ");
                    double value = sc.nextDouble();

                    try {
                        bank.transfer(origin, destiny, value);
                        System.out.println("Transfer completed successfully!");
                    } catch (InsufficientBalanceException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                case 5 -> {
                    System.out.println("\n=== LIST OF ACCOUNTS ===");
                    bank.listAccounts();
                }
                case 6 -> {
                    System.out.print("Enter account number to delete: ");
                    int deleteNumber = sc.nextInt();

                    try {
                        bank.deleteAccount(deleteNumber);
                        System.out.println("Account " + deleteNumber + " successfully deleted!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                case 7 -> {
                    System.out.println("Exiting... Thanks for using our bank!");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid option, try again.");
            }
        }
    }
}
