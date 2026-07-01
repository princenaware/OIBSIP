import java.util.ArrayList;

public class ATM {

    private User user;
    private BankAccount account;
    private ArrayList<Transaction> history;

    public ATM(User user, BankAccount account) {

        this.user = user;
        this.account = account;
        this.history = new ArrayList<>();
    }

    // Login Authentication
    public boolean login(String userId, String pin) {

        return user.getUserId().equals(userId)
                && user.getPin().equals(pin);
    }

    // Get User Name
    public String getUserName() {

        return user.getName();
    }

    // Deposit Money
    public void deposit(double amount) {

        if (account.deposit(amount)) {

            history.add(
                    new Transaction(
                            "Deposit",
                            amount
                    )
            );

            System.out.println("\n================================");
            System.out.println(" Deposit Successful!");
            System.out.println(" Amount Deposited : ₹" + amount);
            System.out.println("================================");

        } else {

            System.out.println("\nInvalid Deposit Amount!");
        }
    }

    // Withdraw Money
    public void withdraw(double amount) {

        if (account.withdraw(amount)) {

            history.add(
                    new Transaction(
                            "Withdraw",
                            amount
                    )
            );

            System.out.println("\n================================");
            System.out.println(" Withdrawal Successful!");
            System.out.println(" Amount Withdrawn : ₹" + amount);
            System.out.println("================================");

        } else {

            System.out.println("\nInsufficient Balance or Invalid Amount!");
        }
    }

    // Transfer Money
    public void transfer(double amount,
                         String accountNumber) {

        if (amount <= 0) {

            System.out.println("\nInvalid Transfer Amount!");
            return;
        }

        if (account.withdraw(amount)) {

            history.add(
                    new Transaction(
                            "Transfer To " + accountNumber,
                            amount
                    )
            );

            System.out.println("\n================================");
            System.out.println(" Transfer Successful!");
            System.out.println(" To Account : " + accountNumber);
            System.out.println(" Amount : ₹" + amount);
            System.out.println("================================");

        } else {

            System.out.println("\nInsufficient Balance!");
        }
    }

    // Check Balance
    public void showBalance() {

        System.out.println("\n================================");
        System.out.printf(" Current Balance : ₹%.2f%n",
                account.getBalance());
        System.out.println("================================");
    }

    // Full Transaction History
    public void showHistory() {

        System.out.println("\n================================");
        System.out.println("      TRANSACTION HISTORY");
        System.out.println("================================");

        if (history.isEmpty()) {

            System.out.println("No Transactions Found.");
            return;
        }

        for (Transaction transaction : history) {

            System.out.println(transaction);
        }
    }

    // Mini Statement (Last 5 Transactions)
    public void miniStatement() {

        System.out.println("\n================================");
        System.out.println("        MINI STATEMENT");
        System.out.println("================================");

        if (history.isEmpty()) {

            System.out.println("No Transactions Found.");
            return;
        }

        int startIndex =
                Math.max(
                        history.size() - 5,
                        0
                );

        for (int i = startIndex;
             i < history.size();
             i++) {

            System.out.println(
                    history.get(i)
            );
        }
    }

    // Current Balance Getter
    public double getBalance() {

        return account.getBalance();
    }

    // Total Transactions
    public int getTransactionCount() {

        return history.size();
    }
}