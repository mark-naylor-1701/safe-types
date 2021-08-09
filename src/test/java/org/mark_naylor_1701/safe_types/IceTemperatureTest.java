package org.mark_naylor_1701.safe_types;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mark_naylor_1701.safe_types.Water.freezingPoint;

class IceTemperatureTest {
    private final static Double aboveFreezing = freezingPoint + 0.01;
    private final static Double belowFreezing = freezingPoint - 0.01;

    @Test
    void legalIceTemparture() {
        assertEquals(belowFreezing, new IceTemperature(belowFreezing).getValue());
        assertEquals(freezingPoint, new IceTemperature(freezingPoint).getValue());
    }

    @Test
    void illegalIceTemperature() {
        assertThrows(AssertionError.class, () -> {new IceTemperature(aboveFreezing);});
    }
}