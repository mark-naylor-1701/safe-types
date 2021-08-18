package org.mark_naylor_1701.safe_types;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.mark_naylor_1701.safe_types.Water.boilingPoint;

class SteamTemperatureTest {
    private final static Double aboveBoiling = boilingPoint + 0.01;
    private final static Double belowBoiling = boilingPoint - 0.01;
    private final SteamTemperature steam  = new SteamTemperature(110.0);
    private final Celsius legalDiff1 = new Celsius(5.0);
    private final Celsius legalDiff2 = new Celsius(10.0);
    private final Celsius illegalDiff = new Celsius(15.0);
    private final Celsius negativeIllegalDiff = new Celsius(-15.0);

    @Test
    void legalSteamTemperature() {
        assertEquals(boilingPoint, new SteamTemperature(boilingPoint).getValue());
        assertEquals(aboveBoiling, new SteamTemperature(aboveBoiling).getValue());
        assertEquals(Celsius.defaultValue, steam.getUnits());
    }

    @Test
    void illegalSteamTemperature() {
        assertThrows(AssertionError.class, () -> new SteamTemperature(belowBoiling));
    }

    @Test
    void addLegal() {
        assertEquals(new SteamTemperature(115.0), steam.add(legalDiff1));
    }

    @Test
    void subtractLegal() {
        assertEquals(new SteamTemperature(105.0), steam.subtract(legalDiff1));
        assertEquals(new SteamTemperature(boilingPoint), steam.subtract(legalDiff2));
    }

    @Test
    void addIllegal() {
        assertThrows(AssertionError.class, () -> steam.add(negativeIllegalDiff));
    }

    @Test
    void subtractIllegal() {
        assertThrows(AssertionError.class, () -> steam.subtract(illegalDiff));
    }
}
