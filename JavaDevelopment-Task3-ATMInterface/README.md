# 🏧 ATM Interface System

A console-based ATM simulation application developed using **Java** as part of the **Oasis Infobyte Java Development Internship**.

The project simulates real-world ATM functionalities such as user authentication, balance inquiry, cash withdrawal, cash deposit, fund transfer, transaction history tracking, and mini statements. The system follows Object-Oriented Programming (OOP) principles and provides a secure and interactive user experience through a menu-driven console interface.

---

# 📌 Project Overview

The ATM Interface System is designed to replicate the basic functionalities of an Automated Teller Machine (ATM).

Users can securely log in using a User ID and PIN and perform banking operations such as:

- Depositing Money
- Withdrawing Money
- Transferring Funds
- Checking Account Balance
- Viewing Transaction History
- Generating Mini Statements

The project demonstrates practical implementation of Java fundamentals, OOP concepts, collections, exception handling, and user interaction through a console application.

---

# 🚀 Features

### 🔐 Secure Login System
- User authentication using User ID and PIN.
- Maximum 3 login attempts.
- Account lock message after repeated invalid attempts.

### 💰 Deposit Money
- Add money to the account balance.
- Validates positive amounts only.

### 💸 Withdraw Money
- Withdraw funds from the account.
- Prevents overdraft and insufficient balance transactions.

### 🔄 Fund Transfer
- Transfer money to another account.
- Updates account balance automatically.

### 📊 Balance Inquiry
- Display current account balance at any time.

### 📜 Transaction History
- Maintains complete transaction history.
- Displays all transactions performed during the session.

### 🧾 Mini Statement
- Displays the last 5 transactions.
- Similar to mini statement functionality in real ATMs.

### ⏰ Transaction Timestamp
- Records date and time for every transaction.

### 🆔 Transaction IDs
- Automatically generates unique transaction IDs.

### ✔ Input Validation
- Prevents invalid numerical inputs.
- Handles exceptions gracefully.

### 🖥 Menu Driven Interface
- Clean and easy-to-use console interface.

---

# 🛠 Technologies Used

| Technology | Purpose |
|------------|----------|
| Java | Core Programming Language |
| OOP | Application Design |
| ArrayList | Transaction Storage |
| Scanner Class | User Input Handling |
| LocalDateTime | Timestamp Generation |
| Exception Handling | Input Validation |
| VS Code / IntelliJ | Development Environment |

---

# 📚 Java Concepts Used

## Classes and Objects

Used to model:

- User
- Bank Account
- Transactions
- ATM Operations

Example:

```java
User user = new User("admin", "1234", "Prince");
```

---

## Encapsulation

Private data members are accessed using public getter methods.

```java
private String userId;
private String pin;
```

---

## ArrayList

Stores transaction history dynamically.

```java
ArrayList<Transaction> history;
```

---

## Constructors

Used to initialize objects.

```java
public User(String userId, String pin, String name)
```

---

## Conditional Statements

Used for authentication and transaction validation.

```java
if(balance >= amount)
```

---

## Loops

Used to repeatedly display ATM menu.

```java
do {
   // Menu
} while(choice != 7);
```

---

## Exception Handling

Used to handle invalid user inputs.

```java
try {
    choice = scanner.nextInt();
}
catch(InputMismatchException e) {
}
```

---

# 📊 Functional Modules

## Module 1: User Authentication

- Login using User ID and PIN.
- Validates credentials.
- Limits login attempts.

---

## Module 2: Deposit

- Accept deposit amount.
- Increase account balance.
- Generate transaction record.

---

## Module 3: Withdrawal

- Check balance availability.
- Deduct amount.
- Update transaction history.

---

## Module 4: Fund Transfer

- Accept destination account number.
- Transfer amount.
- Store transaction record.

---

## Module 5: Transaction History

- Display all transactions.
- Includes timestamps and transaction IDs.

---

## Module 6: Mini Statement

- Display last five transactions.

---

# 📂 Project Structure

```text
ATMInterfaceProject
│
├── User.java
├── BankAccount.java
├── Transaction.java
├── ATM.java
└── ATMInterface.java
```

---

# 🔄 Program Flow

```text
Start
  |
  V
Login
  |
  V
Credentials Valid?
  |
  +----No----> Retry (3 Attempts)
  |
 Yes
  |
  V
Main Menu
  |
  +---- Deposit
  |
  +---- Withdraw
  |
  +---- Transfer
  |
  +---- Check Balance
  |
  +---- Transaction History
  |
  +---- Mini Statement
  |
  +---- Exit
  |
  V
End
```

---

# 📈 Flowchart

```text
 ┌─────────────┐
 │    Start    │
 └──────┬──────┘
        │
        ▼
 ┌─────────────┐
 │   Login     │
 └──────┬──────┘
        │
        ▼
 ┌─────────────┐
 │ Credentials │
 │   Valid ?   │
 └──────┬──────┘
        │
   ┌────┴────┐
   ▼         ▼
  No        Yes
   │          │
   ▼          ▼
 Retry    Main Menu
              │
              ▼
   ┌─────────────────┐
   │ Deposit         │
   │ Withdraw        │
   │ Transfer        │
   │ Balance Inquiry │
   │ History         │
   │ Mini Statement  │
   │ Exit            │
   └─────────────────┘
              │
              ▼
             End
```

---

# 🖥 Sample Output

```text
========================================
          ATM INTERFACE SYSTEM
========================================

Enter User ID: admin
Enter PIN: 1234

Welcome, Prince!

========================================
              MAIN MENU
========================================

1. Transaction History
2. Withdraw
3. Deposit
4. Transfer
5. Check Balance
6. Mini Statement
7. Quit

Enter Choice: 3

Enter Amount to Deposit: Rs 5000

Deposit Successful!
Amount Deposited : Rs 5000
```

---

# 📸 Application Screenshots

## 🔐 Login Screen

![Login Screen](screenshots/login-screen.png)

---

## 🏧 Main Menu

![Main Menu](screenshots/main-menu.png)

---

## 💰 Deposit Transaction

![Deposit](screenshots/deposit.png)

---

## 💸 Withdraw Transaction

![Withdraw](screenshots/withdraw.png)

---

## 🔄 Fund Transfer

![Transfer](screenshots/transfer.png)

---

## 📊 Balance Inquiry

![Balance](screenshots/balance.png)

---

## 📜 Transaction History

![History](screenshots/history.png)

---

## 🧾 Mini Statement

![Mini Statement](screenshots/mini-statement.png)

---

# ▶️ How to Run

### Compile Project

```bash
javac *.java
```

### Run Application

```bash
java ATMInterface
```

---

# 🎯 Learning Outcomes

Through this project, the following concepts were implemented and practiced:

- Core Java Programming
- Object-Oriented Programming
- Encapsulation
- Constructors
- Collections Framework
- Exception Handling
- Input Validation
- Transaction Management
- Console Application Development
- Problem Solving

---

# 🔮 Future Enhancements

Possible future improvements include:

- MySQL Database Integration
- Multiple User Accounts
- ATM Card Validation
- PIN Change Functionality
- Account Creation Module
- GUI using Java Swing
- JavaFX Interface
- SMS Notifications
- Email Notifications
- Receipt Generation
- Online Banking Features

---

# 👨‍💻 Author

**Prince Naware**

---

### ⭐ If you found this project useful, consider giving it a star on GitHub.