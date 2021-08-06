package org.mark_naylor_1701.safe_types;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExtenderTest {
    private Double smallPi = 3.14;
    private String abcdVal = "abcd";

    @Test
    void ConstructerTest() {
        Extender<Double> pi = new Extender<Double>(smallPi);
        Extender<String> abcd = new Extender<String>(abcdVal);

        assertNotNull(pi);
        assertEquals(smallPi, pi.value);

        assertNotNull(abcd);
        assertEquals(abcdVal, abcd.value);
    }
}