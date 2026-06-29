package PrinceNaware_2;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int bestScore = 0;
        boolean playAgain = true;

        System.out.println("====================================");
        System.out.println("      NUMBER GUESSING GAME");
        System.out.println("====================================");

        while (playAgain) {

            int secretNumber = random.nextInt(100) + 1;
            int maxAttempts = 10;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts) {

                System.out.print("\nEnter your guess: ");

                if (!sc.hasNextInt()) {
                    System.out.println("Invalid input! Please enter a valid number.");
                    sc.next();
                    continue;
                }

                int guess = sc.nextInt();
                attempts++;

                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                    continue;
                }

                if (guess == secretNumber) {

                    guessedCorrectly = true;

                    int score = (maxAttempts - attempts + 1) * 10;

                    if (score > bestScore) {
                        bestScore = score;
                    }

                    System.out.println("\nCongratulations!");
                    System.out.println("You guessed the number correctly.");

                    System.out.println("Attempts Used : " + attempts);
                    System.out.println("Your Score    : " + score);
                    System.out.println("Best Score    : " + bestScore);

                    break;

                } else if (guess < secretNumber) {
                    System.out.println("Too Low! Try Again.");
                } else {
                    System.out.println("Too High! Try Again.");
                }

                System.out.println("Attempts Left: " + (maxAttempts - attempts));
            }

            if (!guessedCorrectly) {
                System.out.println("\nGame Over!");
                System.out.println("The correct number was: " + secretNumber);
            }

            System.out.print("\nDo you want to play again? (Y/N): ");
            char choice = sc.next().toUpperCase().charAt(0);

            playAgain = (choice == 'Y');
        }

        System.out.println("\n====================================");
        System.out.println("Thank you for playing!");
        System.out.println("Final Best Score: " + bestScore);
        System.out.println("====================================");

        sc.close();
    }
}
