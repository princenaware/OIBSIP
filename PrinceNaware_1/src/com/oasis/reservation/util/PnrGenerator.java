package com.oasis.reservation.util;

import java.security.SecureRandom;

public final class PnrGenerator {
    private static final SecureRandom RANDOM = new SecureRandom();

    private PnrGenerator() {
    }

    public static String generate() {
        int number = 100000000 + RANDOM.nextInt(900000000);
        return "PNR" + number;
    }
}