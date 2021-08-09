package org.mark_naylor_1701.safe_types;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CelsiusTest {
    private final Double zero = 0.0;
    private final Double illegal = -273.16;
    private final Celsius startingTemp = new Celsius(-200.0);

    @Test
    void legalCelsiusTest() {
        assertEquals(zero, new Celsius(zero).getValue());
    }

    @Test
    void illegalCelsiusTest() {
        assertThrows(AssertionError.class, () -> {new Celsius(illegal);});
    }
}
