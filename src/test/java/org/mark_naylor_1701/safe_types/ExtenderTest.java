package org.mark_naylor_1701.safe_types;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExtenderTest {
    private static final Double smallPi = 3.14;
    private static final String abcdVal = "abcd";

    @Test
    void constructorTest() {
        final Extender<Double> pi = new Extender<>(smallPi);
        final Extender<String> abcd = new Extender<>(abcdVal);

        assertNotNull(pi);
        assertEquals(smallPi, pi.getValue());

        assertNotNull(abcd);
        assertEquals(abcdVal, abcd.getValue());
    }
}
