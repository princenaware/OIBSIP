CREATE DATABASE IF NOT EXISTS online_reservation_db;
USE online_reservation_db;

DROP TABLE IF EXISTS bookings;
DROP TABLE IF EXISTS trains;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    login_id VARCHAR(50) NOT NULL UNIQUE,
    password_hash VARCHAR(64) NOT NULL,
    full_name VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE trains (
    train_number VARCHAR(20) PRIMARY KEY,
    train_name VARCHAR(100) NOT NULL,
    source_station VARCHAR(100) NOT NULL,
    destination_station VARCHAR(100) NOT NULL
);

CREATE TABLE bookings (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pnr_number VARCHAR(20) NOT NULL UNIQUE,
    passenger_name VARCHAR(100) NOT NULL,
    passenger_age INT NOT NULL,
    train_number VARCHAR(20) NOT NULL,
    train_name VARCHAR(100) NOT NULL,
    class_type VARCHAR(30) NOT NULL,
    journey_date DATE NOT NULL,
    source_station VARCHAR(100) NOT NULL,
    destination_station VARCHAR(100) NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'CONFIRMED',
    booked_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    cancelled_at TIMESTAMP NULL,
    CONSTRAINT fk_booking_train FOREIGN KEY (train_number)
        REFERENCES trains(train_number)
);

-- Password is: admin123
-- SHA-256 hash of admin123
INSERT INTO users (login_id, password_hash, full_name) VALUES
('admin', '240be518fabd2724ddb6f04eeb1da5967448d7e831c08c8fa822809f74c720a9', 'System Administrator');

INSERT INTO trains (train_number, train_name, source_station, destination_station) VALUES
('12001', 'Shatabdi Express', 'New Delhi', 'Bhopal'),
('12951', 'Mumbai Rajdhani Express', 'Mumbai Central', 'New Delhi'),
('12627', 'Karnataka Express', 'Bangalore', 'New Delhi'),
('12295', 'Sanghamitra Express', 'Bangalore', 'Danapur'),
('22119', 'Tejas Express', 'Mumbai CSMT', 'Karmali'),
('12860', 'Gitanjali Express', 'Howrah', 'Mumbai CSMT');