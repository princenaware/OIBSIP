package com.oasis.reservation.model;

public class Train {
    private final String trainNumber;
    private final String trainName;
    private final String sourceStation;
    private final String destinationStation;

    public Train(String trainNumber, String trainName, String sourceStation, String destinationStation) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.sourceStation = sourceStation;
        this.destinationStation = destinationStation;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getSourceStation() {
        return sourceStation;
    }

    public String getDestinationStation() {
        return destinationStation;
    }
}