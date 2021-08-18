package org.mark_naylor_1701.safe_types;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mark_naylor_1701.safe_types.Water.freezingPoint;

class IceTemperatureTest {
    private final static Double aboveFreezing = freezingPoint + 0.01;
    private final static Double belowFreezing = freezingPoint - 0.01;
    private final IceTemperature ice = new IceTemperature(-10.0);
    private final Celsius legalDiff1 = new Celsius(5.0);
    private final Celsius legalDiff2 = new Celsius(10.0);
    private final Celsius illegalDiff = new Celsius(15.0);
    private final Celsius negativeIllegalDiff = new Celsius(-15.0);

    @Test
    void legal() {
        assertEquals(belowFreezing, new IceTemperature(belowFreezing).getValue());
        assertEquals(freezingPoint, new IceTemperature(freezingPoint).getValue());
    }

    @Test
    void illegal() {
        assertThrows(AssertionError.class, () -> new IceTemperature(aboveFreezing));
    }

    @Test
    void addLegal() {
        assertEquals(new IceTemperature(-5.0), ice.add(legalDiff1));
        assertEquals(new IceTemperature(freezingPoint), ice.add(legalDiff2));
        assertEquals(Celsius.defaultValue, ice.getUnits());
    }

    @Test
    void addIllegal() {
        assertThrows(AssertionError.class, () -> ice.add(illegalDiff));
    }

    @Test
    void subtractLegal() {
        assertEquals(new IceTemperature(-15.0), ice.subtract(legalDiff1));
    }

    @Test
    void subtractIllegal() {
        assertThrows(AssertionError.class, () -> ice.subtract(negativeIllegalDiff));
    }
}