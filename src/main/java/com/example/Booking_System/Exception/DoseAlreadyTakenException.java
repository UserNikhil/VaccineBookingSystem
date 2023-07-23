package com.example.Booking_System.Exception;

public class DoseAlreadyTakenException extends RuntimeException {
    public DoseAlreadyTakenException(String message) {
        super(message);
    }
}
