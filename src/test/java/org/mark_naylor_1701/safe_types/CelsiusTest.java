package org.mark_naylor_1701.safe_types;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CelsiusTest {
    private final Double zero = 0.0;
    private final Double illegal = -273.16;
    private final Celsius ten = new Celsius(10.0);
    private final Celsius fifteen = new Celsius(15.0);
    private final Celsius twentyfive = new Celsius(25.0);

    @Test
    void legalCelsiusTest() {
        assertEquals(zero, new Celsius(zero).getValue());
        assertEquals(Celsius.defaultValue, ten.getUnits());
    }

    @Test
    void illegalCelsiusTest() {
        assertThrows(AssertionError.class, () -> new Celsius(illegal));
    }

    @Test
    void addTest() {
        assertEquals(twentyfive, ten.add(fifteen));
    }

    @Test
    void subtract() {
        assertEquals(ten, twentyfive.subtract(fifteen));
    }
}
