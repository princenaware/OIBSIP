package com.oasis.reservation.dao;

import com.oasis.reservation.db.DatabaseConnection;
import com.oasis.reservation.model.Train;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class TrainDAO {
    public Optional<Train> findByTrainNumber(String trainNumber) {
        String sql = "SELECT train_number, train_name, source_station, destination_station FROM trains WHERE train_number = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, trainNumber);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Train train = new Train(
                            resultSet.getString("train_number"),
                            resultSet.getString("train_name"),
                            resultSet.getString("source_station"),
                            resultSet.getString("destination_station")
                    );
                    return Optional.of(train);
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error while fetching train: " + e.getMessage());
        }

        return Optional.empty();
    }
}