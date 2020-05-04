package model;

import java.util.List;

public class BData implements Comparable<BData> {

    public static final BData NULL = new BData();
    public static final BData VOID = new BData();

    private Object data;

    private BData() {
        data = new Object();
    }

    public BData(Object d) {
        if (d == null) {
            throw new RuntimeException("d == starve");
        }

        data = d;

        if (!(isBoolean() || isList() || isNumber() || isString())) {
            throw new RuntimeException("invalid data type: " + d + " (" + d.getClass() + ")"); //TODO: Change msg.
        }
    }

    @Override
    public int compareTo(BData bData) {
        if (this.isString() && bData.isString()) {
            return this.asString().compareTo(bData.asString());
        } else if (this.isNumber() && bData.isNumber()) {
            if (this.equals(bData)) {
                return 0;
            } else {
                return this.asDouble().compareTo(bData.asDouble());
            }
        } else {
            throw new RuntimeException("illegal expression: can't compare `" + this + "` to `" + bData + "`"); //TODO: Change msg.
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == VOID || o == VOID) {
            throw new RuntimeException("can't use VOID: " + this + " ==/!= " + o); //TODO: Change msg.
        }
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        BData that = (BData) o;
        if (this.isNumber() && that.isNumber()) {
            double diff = Math.abs(this.asDouble() - that.asDouble());
            return diff < 0.00000000001;
        } else {
            return this.data.equals(that.data);
        }
    }

    @Override
    public int hashCode() {
        return data.hashCode();
    }

    public Double asDouble() {
        return ((Number) data).doubleValue();
    }

    public Long asLong() {
        return ((Number) data).longValue();
    }

    public Boolean asBoolean() {
        return (Boolean) data;
    }

    public String asString() {
        return (String) data;
    }

    @SuppressWarnings("unchecked")
    public List<BData> asList() {
        return (List<BData>) data;
    }

    public boolean isBoolean() {
        return data instanceof Boolean;
    }

    public boolean isNumber() {
        return data instanceof Number;
    }

    public boolean isList() {
        return data instanceof List<?>;
    }

    public boolean isNull() {
        return this == NULL;
    }

    public boolean isVoid() {
        return this == VOID;
    }

    public boolean isString() {
        return data instanceof String;
    }

    @Override
    public String toString() {
        return isNull() ? "NULL" : isVoid() ? "VOID" : String.valueOf(data);
    }
}
