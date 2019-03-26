package org.conway.multiplative.persistence;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersistenceFinderTest {
    @DisplayName("Check Known Values")
    @ParameterizedTest(name = "Multiplative Persistence of \"{0}\" should be {1}")
    @CsvSource({"0, 0",
            "1, 0",
            "25, 2",
            "39, 3",
            "77, 4",
            "679, 5",
            "6788, 6",
            "68889, 7",
            "2677889, 8",
            "26888999, 9",
            "3778888999, 10",
            "277777788888899, 11",
            "10, 1"})
    public void findPersistenceValue(String number, int expectedValue) {
        assertEquals(expectedValue, PersistenceFinder.findPersistenceValue(number));
    }

    @DisplayName("Is a number a good number to have when computing persistence")
    @ParameterizedTest(name = "Possible persistence of \"{0}\" should be {1}")
    @CsvSource({"0, false",
            "1, true",
            "25, false",
            "39, true",
            "7320467, false",
            "7325467, false",
            "7329467, true"
    })
    public void isGoodPersistencePossibility(String number, boolean expectedValue) {
        assertEquals(expectedValue, PersistenceFinder.isGoodPersistencePossibility(number));
    }
}
