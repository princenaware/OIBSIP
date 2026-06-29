package com.oasis.reservation.dao;

import com.oasis.reservation.db.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public boolean isValidUser(String loginId, String passwordHash) {
        String sql = "SELECT id FROM users WHERE login_id = ? AND password_hash = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, loginId);
            statement.setString(2, passwordHash);

            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            System.out.println("Database error during login: " + e.getMessage());
            return false;
        }
    }
}