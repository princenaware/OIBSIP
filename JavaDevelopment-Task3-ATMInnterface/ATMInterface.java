import java.util.InputMismatchException;
import java.util.Scanner;

public class ATMInterface {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        User user = new User(
                "admin",
                "1234",
                "Prince"
        );

        BankAccount account =
                new BankAccount(10000);

        ATM atm =
                new ATM(user, account);

        System.out.println("========================================");
        System.out.println("          ATM INTERFACE SYSTEM");
        System.out.println("========================================");

        boolean loggedIn = false;

        // Login System
        for (int attempt = 1;
             attempt <= 3;
             attempt++) {

            System.out.print("\nEnter User ID: ");
            String userId = sc.nextLine();

            System.out.print("Enter PIN: ");
            String pin = sc.nextLine();

            if (atm.login(userId, pin)) {

                loggedIn = true;

                System.out.println(
                        "\nWelcome, "
                                + atm.getUserName()
                                + "!"
                );

                break;
            }

            System.out.println(
                    "\nInvalid Credentials!"
            );

            System.out.println(
                    "Attempts Remaining: "
                            + (3 - attempt)
            );
        }

        if (!loggedIn) {

            System.out.println(
                    "\nAccount Locked!"
            );

            System.out.println(
                    "Please Contact Your Bank."
            );

            sc.close();
            return;
        }

        int choice = 0;

        do {

            System.out.println(
                    "\n========================================"
            );

            System.out.println(
                    "               MAIN MENU"
            );

            System.out.println(
                    "========================================"
            );

            System.out.println(
                    "1. Transaction History"
            );

            System.out.println(
                    "2. Withdraw"
            );

            System.out.println(
                    "3. Deposit"
            );

            System.out.println(
                    "4. Transfer"
            );

            System.out.println(
                    "5. Check Balance"
            );

            System.out.println(
                    "6. Mini Statement"
            );

            System.out.println(
                    "7. Quit"
            );

            System.out.print(
                    "\nEnter Choice: "
            );

            try {

                choice = sc.nextInt();

                switch (choice) {

                    case 1:

                        atm.showHistory();
                        break;

                    case 2:

                        System.out.print(
                                "\nEnter Amount to Withdraw: Rs."
                        );

                        double withdrawAmount =
                                sc.nextDouble();

                        atm.withdraw(
                                withdrawAmount
                        );

                        break;

                    case 3:

                        System.out.print(
                                "\nEnter Amount to Deposit: Rs."
                        );

                        double depositAmount =
                                sc.nextDouble();

                        atm.deposit(
                                depositAmount
                        );

                        break;

                    case 4:

                        System.out.print(
                                "\nEnter Account Number: "
                        );

                        String accountNumber =
                                sc.next();

                        System.out.print(
                                "Enter Amount to Transfer: Rs."
                        );

                        double transferAmount =
                                sc.nextDouble();

                        atm.transfer(
                                transferAmount,
                                accountNumber
                        );

                        break;

                    case 5:

                        atm.showBalance();
                        break;

                    case 6:

                        atm.miniStatement();
                        break;

                    case 7:

                        System.out.print(
                                "\nAre you sure you want to exit? (Y/N): "
                        );

                        String confirm =
                                sc.next();

                        if (confirm.equalsIgnoreCase("Y")) {

                            System.out.println(
                                    "\nThank You For Using ATM Interface!"
                            );

                            System.out.println(
                                    "Have a Great Day!"
                            );

                        } else {

                            choice = 0;
                        }

                        break;

                    default:

                        System.out.println(
                                "\nInvalid Choice!"
                        );
                }

            } catch (InputMismatchException e) {

                System.out.println(
                        "\nInvalid Input! Please Enter Numbers Only."
                );

                sc.nextLine();
            }

        } while (choice != 7);

        sc.close();
    }
}