package com.oasis.reservation.service;

import com.oasis.reservation.dao.BookingDAO;
import com.oasis.reservation.dao.TrainDAO;
import com.oasis.reservation.model.Booking;
import com.oasis.reservation.model.Train;
import com.oasis.reservation.util.PnrGenerator;
import java.time.LocalDate;
import java.util.Optional;

public class ReservationService {
    private final TrainDAO trainDAO = new TrainDAO();
    private final BookingDAO bookingDAO = new BookingDAO();

    public Optional<Train> getTrainByNumber(String trainNumber) {
        return trainDAO.findByTrainNumber(trainNumber);
    }

    public Booking createReservation(String passengerName, int passengerAge, Train train,
                                     String classType, LocalDate journeyDate,
                                     String sourceStation, String destinationStation) {
        String pnrNumber = generateUniquePnr();

        Booking booking = new Booking(
                pnrNumber,
                passengerName,
                passengerAge,
                train.getTrainNumber(),
                train.getTrainName(),
                classType,
                journeyDate,
                sourceStation,
                destinationStation,
                "CONFIRMED"
        );

        boolean saved = bookingDAO.save(booking);

        if (!saved) {
            throw new IllegalStateException("Reservation could not be saved.");
        }

        return booking;
    }

    private String generateUniquePnr() {
        String pnr;

        do {
            pnr = PnrGenerator.generate();
        } while (bookingDAO.existsByPnr(pnr));

        return pnr;
    }
}