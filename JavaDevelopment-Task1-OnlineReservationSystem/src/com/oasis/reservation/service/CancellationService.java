package com.oasis.reservation.service;

import com.oasis.reservation.dao.BookingDAO;
import com.oasis.reservation.model.Booking;

public class CancellationService {
    private final BookingDAO bookingDAO = new BookingDAO();

    public Booking findBookingByPnr(String pnrNumber) {
        return bookingDAO.findByPnr(pnrNumber);
    }

    public boolean cancelBooking(String pnrNumber) {
        return bookingDAO.cancelByPnr(pnrNumber);
    }
}