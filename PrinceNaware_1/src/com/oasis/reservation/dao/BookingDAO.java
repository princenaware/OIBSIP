package com.oasis.reservation.dao;

import com.oasis.reservation.db.DatabaseConnection;
import com.oasis.reservation.model.Booking;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class BookingDAO {
    public boolean existsByPnr(String pnrNumber) {
        String sql = "SELECT id FROM bookings WHERE pnr_number = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, pnrNumber);

            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            System.out.println("Database error while checking PNR: " + e.getMessage());
            return true;
        }
    }

    public boolean save(Booking booking) {
        String sql = """
                INSERT INTO bookings
                (pnr_number, passenger_name, passenger_age, train_number, train_name, class_type,
                 journey_date, source_station, destination_station, status)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, booking.getPnrNumber());
            statement.setString(2, booking.getPassengerName());
            statement.setInt(3, booking.getPassengerAge());
            statement.setString(4, booking.getTrainNumber());
            statement.setString(5, booking.getTrainName());
            statement.setString(6, booking.getClassType());
            statement.setDate(7, Date.valueOf(booking.getJourneyDate()));
            statement.setString(8, booking.getSourceStation());
            statement.setString(9, booking.getDestinationStation());
            statement.setString(10, booking.getStatus());

            return statement.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println("Database error while saving booking: " + e.getMessage());
            return false;
        }
    }

    public Booking findByPnr(String pnrNumber) {
        String sql = """
                SELECT pnr_number, passenger_name, passenger_age, train_number, train_name,
                       class_type, journey_date, source_station, destination_station, status
                FROM bookings
                WHERE pnr_number = ?
                """;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, pnrNumber);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    LocalDate journeyDate = resultSet.getDate("journey_date").toLocalDate();

                    return new Booking(
                            resultSet.getString("pnr_number"),
                            resultSet.getString("passenger_name"),
                            resultSet.getInt("passenger_age"),
                            resultSet.getString("train_number"),
                            resultSet.getString("train_name"),
                            resultSet.getString("class_type"),
                            journeyDate,
                            resultSet.getString("source_station"),
                            resultSet.getString("destination_station"),
                            resultSet.getString("status")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error while fetching booking: " + e.getMessage());
        }

        return null;
    }

    public boolean cancelByPnr(String pnrNumber) {
        String sql = """
                UPDATE bookings
                SET status = 'CANCELLED', cancelled_at = CURRENT_TIMESTAMP
                WHERE pnr_number = ? AND status = 'CONFIRMED'
                """;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, pnrNumber);
            return statement.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println("Database error while cancelling booking: " + e.getMessage());
            return false;
        }
    }
}