# 🏦 Simple Baking System

A simple Java console-based banking system project designed for practicing Object-Oriented Programming (OOP) concepts such as encapsulation, inheritance, polymorphism, and exception handling.





## 📌 Features

- Create accounts (Current Account / Savings Account)

- Deposit into an account

- Withdraw with balance validation

- Transfer between accounts

- List all accounts

- Delete an account

- Handle custom exceptions (e.g., insufficient balance, invalid account number)



## 🛠️ Tech Stack

- Java 17+

- Standard Java Libraries (no external dependencies)



## 🚀 How to Run

1. Clone the repository

```

git clone https://github.com/Doriguelo/banco-digital.git
cd simple-banking-system

```



2. Compile te project

```

javac src/**/*.java

```



3. Run the application

```

java src/Main

```



## 📖 Example Usage

When running, you will see a simple interactive menu like this:

```

=== Banking System ===
1 - Create account
2 - Deposit
3 - Withdraw
4 - Transfer
5 - List accounts
6 - Delete account
7 - Exit
=======================

Choose an option:

```

- If you try to withdraw more money than available, you will get an InsufficientBalanceException.



- If you try to deposit/withdraw/transfer to a non-existent account, you will get an IllegalArgumentException.



## 🎯 Learning Objectives

This project helps practice:



- Encapsulation → hiding account details.

- Inheritance \& Polymorphism → CurrentAccount and SavingsAccount extend Account.

- Exception Handling → custom exceptions for business rules.

- Collections API → using HashMap to store accounts.



## 📈 Future improvements

- Persist account data in a file or database

- Add authentication for customers

- Create a simple GUI (Swing/JavaFX)

