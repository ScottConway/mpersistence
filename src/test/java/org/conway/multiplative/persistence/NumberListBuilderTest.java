package org.conway.multiplative.persistence;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberListBuilderTest {

    private static Map<Integer, BigInteger> expectedResult;

    @BeforeAll
    private static void buildExpectedResults() {
        expectedResult = new HashMap<>();

        expectedResult.put(3, new BigInteger("39"));
        expectedResult.put(4, new BigInteger("77"));
        expectedResult.put(5, new BigInteger("679"));
        expectedResult.put(6, new BigInteger("6788"));
        expectedResult.put(7, new BigInteger("68889"));
        expectedResult.put(8, new BigInteger("2677889"));
        expectedResult.put(9, new BigInteger("26888999"));
        expectedResult.put(10, new BigInteger("3778888999"));
        expectedResult.put(11, new BigInteger("277777788888899"));
    }

    @Test
    @DisplayName("Did we find all the known persistence values.")
    public void buildMap() {
        Map<Integer, BigInteger> results = NumberListBuilder.buildMap(3);
        assertEquals(expectedResult, results);
    }
}
