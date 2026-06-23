package com.oasis.reservation.util;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public final class InputUtil {
    private InputUtil() {
    }

    public static String readNonEmptyString(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println("Input cannot be empty. Please try again.");
        }
    }

    public static int readPositiveInt(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            try {
                int value = Integer.parseInt(input);
                if (value > 0) {
                    return value;
                }
                System.out.println("Value must be greater than 0.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public static LocalDate readFutureOrTodayDate(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            try {
                LocalDate date = LocalDate.parse(input);
                if (!date.isBefore(LocalDate.now())) {
                    return date;
                }
                System.out.println("Journey date cannot be in the past.");
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Use YYYY-MM-DD, for example 2026-06-25.");
            }
        }
    }

    public static boolean readConfirmation(Scanner scanner, String message) {
        while (true) {
            System.out.print(message + " (Y/N): ");
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.equals("Y")) {
                return true;
            }

            if (input.equals("N")) {
                return false;
            }

            System.out.println("Please enter Y or N.");
        }
    }
}