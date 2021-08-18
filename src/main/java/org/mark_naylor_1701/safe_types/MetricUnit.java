package org.mark_naylor_1701.safe_types;

abstract public class MetricUnit extends Extender<Number> implements Comparable<Number> {
    protected final static String defaultValue = ":none";
    protected final String units;


    public MetricUnit(Number value, String units) {
        super(value);
        this.units = units;
    }


    public MetricUnit(Number value) {
        super(value.doubleValue());
        units = defaultValue;
    }

    @Override
    public int compareTo(Number o) {
        Double thisValue = getValue().doubleValue();
        return thisValue.compareTo(o.doubleValue());
    }

    public String getUnits() {
        return units;
    }
}
