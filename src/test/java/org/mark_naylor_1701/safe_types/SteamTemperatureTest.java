package org.mark_naylor_1701.safe_types;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.mark_naylor_1701.safe_types.Water.boilingPoint;

class SteamTemperatureTest {
    private final static Double aboveBoiling = boilingPoint + 0.01;
    private final static Double belowBoiling = boilingPoint - 0.01;

    @Test
    void legalSteamTemperature() {
        assertEquals(boilingPoint, new SteamTemperature(boilingPoint).getValue());
        assertEquals(aboveBoiling, new SteamTemperature(aboveBoiling).getValue());
    }

    @Test
    void illegalSteamTemperature() {
        assertThrows(AssertionError.class, () -> {new SteamTemperature(belowBoiling);});
    }
}