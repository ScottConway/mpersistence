package org.conway.multiplative.persistence;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersistenceDigitPowerValueTest {

    static final PersistenceDigitPowerValue ZEROPOWER = new PersistenceDigitPowerValue(9, 0, new BigInteger("9").pow(0));

    @DisplayName("Print the string that will go into the original number")
    @Test
    public void valueString() {
        assertEquals("444", ValueMapTest.PDPV43.valueString());
        assertEquals("333333", ValueMapTest.PDPV36.valueString());
        assertEquals("", ZEROPOWER.valueString());
    }
}
