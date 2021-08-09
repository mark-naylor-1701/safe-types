package org.mark_naylor_1701.safe_types;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.mark_naylor_1701.safe_types.Water.freezingPoint;
import static org.mark_naylor_1701.safe_types.Water.boilingPoint;

class WaterTemperatureTest {
    @Test
    void legalTemperatures() {
        final Double inrange = 50.0;

        assertEquals(boilingPoint, new WaterTemperature(boilingPoint).getValue());
        assertEquals(freezingPoint, new WaterTemperature(freezingPoint).getValue());
        assertEquals(inrange, new WaterTemperature(inrange).getValue());
    }

    @Test
    void illegalTemperatures() {
        final Double belowFreezing = freezingPoint - 0.01;
        final Double aboveBoiling = boilingPoint + 0.01;

        assertThrows(AssertionError.class, () -> {new WaterTemperature(belowFreezing);});
        assertThrows(AssertionError.class, () -> {new WaterTemperature(aboveBoiling);});

    }
}
