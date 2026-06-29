package com.oasis.reservation.ui;

import com.oasis.reservation.model.Booking;
import com.oasis.reservation.model.Train;
import com.oasis.reservation.service.AuthService;
import com.oasis.reservation.service.CancellationService;
import com.oasis.reservation.service.ReservationService;
import com.oasis.reservation.util.InputUtil;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

public class ConsoleUI {
    private final Scanner scanner = new Scanner(System.in);
    private final AuthService authService = new AuthService();
    private final ReservationService reservationService = new ReservationService();
    private final CancellationService cancellationService = new CancellationService();

    public void start() {
        printHeader();

        if (!login()) {
            System.out.println("Too many failed login attempts. Application closed.");
            return;
        }

        showMainMenu();
    }

    private void printHeader() {
        System.out.println("=======================================");
        System.out.println("     ONLINE TAIN RESERVATION SYSTEM");
        System.out.println("     Developed by Prince Naware");
        System.out.println("=======================================");
    }

    private boolean login() {
        System.out.println("\nLOGIN FORM");

        for (int attempt = 1; attempt <= 3; attempt++) {
            String loginId = InputUtil.readNonEmptyString(scanner, "Login ID: ");
            String password = InputUtil.readNonEmptyString(scanner, "Password: ");

            if (authService.login(loginId, password)) {
                System.out.println("\nLogin successful. Welcome!");
                return true;
            }

            System.out.println("Invalid login ID or password. Attempts left: " + (3 - attempt));
        }

        return false;
    }

    private void showMainMenu() {
        while (true) {
            System.out.println("\n========== MAIN MENU ==========");
            System.out.println("1. Reservation Form");
            System.out.println("2. Cancellation Form");
            System.out.println("3. Exit");

            int choice = InputUtil.readPositiveInt(scanner, "Enter your choice: ");

            switch (choice) {
                case 1 -> handleReservation();
                case 2 -> handleCancellation();
                case 3 -> {
                    System.out.println("Thank you for using Online Reservation System.");
                    return;
                }
                default -> System.out.println("Invalid choice. Please select 1, 2, or 3.");
            }
        }
    }

    private void handleReservation() {
        System.out.println("\n========== RESERVATION FORM ==========");

        String passengerName = InputUtil.readNonEmptyString(scanner, "Passenger Name: ");
        int passengerAge = InputUtil.readPositiveInt(scanner, "Passenger Age: ");

        Train selectedTrain = null;

        while (selectedTrain == null) {
            String trainNumber = InputUtil.readNonEmptyString(scanner, "Train Number: ");
            Optional<Train> trainOptional = reservationService.getTrainByNumber(trainNumber);

            if (trainOptional.isPresent()) {
                selectedTrain = trainOptional.get();
                System.out.println("Train Name Auto-Fetched: " + selectedTrain.getTrainName());
                System.out.println("Default Route: " + selectedTrain.getSourceStation()
                        + " to " + selectedTrain.getDestinationStation());
            } else {
                System.out.println("Train number not found. Please enter a valid train number.");
            }
        }

        String classType = InputUtil.readNonEmptyString(scanner, "Class Type (Sleeper/AC/General): ");
        LocalDate journeyDate = InputUtil.readFutureOrTodayDate(scanner, "Date of Journey (YYYY-MM-DD): ");
        String source = InputUtil.readNonEmptyString(scanner, "From Source Station: ");
        String destination = InputUtil.readNonEmptyString(scanner, "To Destination Station: ");

        boolean confirm = InputUtil.readConfirmation(scanner, "Press Y to Insert/Submit this reservation");

        if (!confirm) {
            System.out.println("Reservation cancelled before saving.");
            return;
        }

        try {
            Booking booking = reservationService.createReservation(
                    passengerName,
                    passengerAge,
                    selectedTrain,
                    classType,
                    journeyDate,
                    source,
                    destination
            );

            System.out.println("\nReservation successful.");
            System.out.println("Generated PNR Number: " + booking.getPnrNumber());
            printBooking(booking);
        } catch (IllegalStateException e) {
            System.out.println("Reservation failed: " + e.getMessage());
        }
    }

    private void handleCancellation() {
        System.out.println("\n========== CANCELLATION FORM ==========");

        String pnrNumber = InputUtil.readNonEmptyString(scanner, "Enter PNR Number: ");
        Booking booking = cancellationService.findBookingByPnr(pnrNumber);

        if (booking == null) {
            System.out.println("No booking found for PNR: " + pnrNumber);
            return;
        }

        System.out.println("\nTicket details found:");
        printBooking(booking);

        if ("CANCELLED".equalsIgnoreCase(booking.getStatus())) {
            System.out.println("This ticket is already cancelled.");
            return;
        }

        boolean confirm = InputUtil.readConfirmation(scanner, "Confirm cancellation");

        if (!confirm) {
            System.out.println("Cancellation aborted.");
            return;
        }

        boolean cancelled = cancellationService.cancelBooking(pnrNumber);

        if (cancelled) {
            System.out.println("Ticket cancelled successfully.");
        } else {
            System.out.println("Ticket could not be cancelled. It may already be cancelled.");
        }
    }

    private void printBooking(Booking booking) {
        System.out.println("---------------------------------------");
        System.out.println("PNR Number       : " + booking.getPnrNumber());
        System.out.println("Passenger Name   : " + booking.getPassengerName());
        System.out.println("Passenger Age    : " + booking.getPassengerAge());
        System.out.println("Train Number     : " + booking.getTrainNumber());
        System.out.println("Train Name       : " + booking.getTrainName());
        System.out.println("Class Type       : " + booking.getClassType());
        System.out.println("Journey Date     : " + booking.getJourneyDate());
        System.out.println("From             : " + booking.getSourceStation());
        System.out.println("To               : " + booking.getDestinationStation());
        System.out.println("Status           : " + booking.getStatus());
        System.out.println("---------------------------------------");
    }
}