package org.mark_naylor_1701.safe_types;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MetricUnitTest {
    public class MetricUnitConcrete extends MetricUnit {
        public MetricUnitConcrete(Number value) {
            super(value);
        }
    }

    private Double testVal = 10.0;

    @Test
    void legalConcrete() {
        MetricUnitConcrete concrete = new MetricUnitConcrete(testVal);

        assertEquals(testVal, concrete.getValue());
        assertEquals(MetricUnit.defaultValue, concrete.getUnits());
    }
}