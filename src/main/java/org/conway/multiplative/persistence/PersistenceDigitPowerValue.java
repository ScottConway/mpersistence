package org.conway.multiplative.persistence;

import java.math.BigInteger;

public class PersistenceDigitPowerValue {
    private final int digit;
    private final int power;
    private final BigInteger value;

    public PersistenceDigitPowerValue(int digit, int power, BigInteger value) {
        this.digit = digit;
        this.power = power;
        this.value = value;
    }

    public int getDigit() {
        return digit;
    }

    public int getPower() {
        return power;
    }

    public BigInteger getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "PersistenceDigitPowerValue{" +
                "digit=" + digit +
                ", power=" + power +
                ", value=" + value +
                '}';
    }
}
