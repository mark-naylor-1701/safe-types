package org.mark_naylor_1701.safe_types;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.mark_naylor_1701.safe_types.Water.freezingPoint;
import static org.mark_naylor_1701.safe_types.Water.boilingPoint;

class WaterTemperatureTest {
    private final WaterTemperature high  = new WaterTemperature(90.0);
    private final WaterTemperature low = new WaterTemperature(10.0);
    private final Celsius legalDiff1 = new Celsius(5.0);
    private final Celsius legalDiff2 = new Celsius(10.0);
    private final Celsius illegalDiff = new Celsius(15.0);
    private final Celsius negativeIllegalDiff = new Celsius(-15.0);

    @Test
    void legalTemperatures() {
        final Double inRange = 50.0;

        assertEquals(boilingPoint, new WaterTemperature(boilingPoint).getValue());
        assertEquals(freezingPoint, new WaterTemperature(freezingPoint).getValue());
        assertEquals(inRange, new WaterTemperature(inRange).getValue());
        assertEquals(Celsius.defaultValue, high.getUnits());
    }

    @Test
    void illegalTemperatures() {
        final Double belowFreezing = freezingPoint - 0.01;
        final Double aboveBoiling = boilingPoint + 0.01;

        assertThrows(AssertionError.class, () -> new WaterTemperature(belowFreezing));
        assertThrows(AssertionError.class, () -> new WaterTemperature(aboveBoiling));
    }

    @Test
    void addLegal() {
        assertEquals(new WaterTemperature(95.0), high.add(legalDiff1));
        assertEquals(new WaterTemperature(boilingPoint), high.add(legalDiff2));
    }
    @Test
    void addIllegal() {
        assertThrows(AssertionError.class, () -> high.add(illegalDiff));
        assertThrows(AssertionError.class, () -> low.add(negativeIllegalDiff));
    }

    @Test
    void subtractLegal() {
        assertEquals(new WaterTemperature(5.0), low.subtract(legalDiff1));
        assertEquals(new WaterTemperature(freezingPoint), low.subtract(legalDiff2));
    }

    @Test
    void subtractIllegal() {
        assertThrows(AssertionError.class, () -> low.subtract(illegalDiff));
        assertThrows(AssertionError.class, () -> high.subtract(negativeIllegalDiff));
    }
}
