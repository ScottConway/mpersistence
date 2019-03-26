package org.conway.multiplative.persistence;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class ValueMap {
    private static final int START_VALUES[] = {2, 3, 4, 6, 7, 8, 9};
    private static final int MAXPOWER = 500;

    private static Map<Integer, List<PersistenceDigitPowerValue>> valueMap;
    private static Map<Integer, List<PersistenceDigitPowerValue>> reducedMap;

    static {
        buildMap();
        reducedMap = Collections.unmodifiableMap(removeDuplicates(valueMap));
    }

    private static void buildMap() {
        Map<Integer, List<PersistenceDigitPowerValue>> temp = new LinkedHashMap<Integer, List<PersistenceDigitPowerValue>>(15);
        for (int digit : START_VALUES) {
            System.out.println("Computing for " + digit);
            temp.put(digit, buildPowerList(digit));
        }
        valueMap = Collections.unmodifiableMap(temp);
    }

    private static List<PersistenceDigitPowerValue> buildPowerList(int digit) {
        List<PersistenceDigitPowerValue> values = new ArrayList<PersistenceDigitPowerValue>(MAXPOWER);
        BigInteger multple = BigInteger.valueOf(digit);
        for (int i = 1; i <= MAXPOWER; i++) {
            BigInteger number = multple.pow(i);
            String digitsMultiplied = PersistenceFinder.multiplyAllDigits(number.toString());
            // System.out.println("\t\t" + digit + "  \t" + i + " " + number + "  " + PersistenceFinder.isGoodPersistencePossibility(digitsMultiplied) + " " + digitsMultiplied);
            if (PersistenceFinder.isGoodPersistencePossibility(digitsMultiplied)) {
                values.add(new PersistenceDigitPowerValue(digit, i, digitsMultiplied, number));
            }
        }
        return values;
    }

    public static void printMapInfo() {
        System.out.println("\nOriginal Values\n");
        printMap(valueMap);
        System.out.println("\nReduced Values\n");
        printMap(reducedMap);
    }

    private static void printMap(Map<Integer, List<PersistenceDigitPowerValue>> map) {
        for (Integer number : map.keySet()) {
            List<PersistenceDigitPowerValue> values = map.get(number);
            System.out.println(number + ":  " + values.size());
            values.forEach(value -> System.out.println("\t\t" + value));
        }
    }

    public static Map<Integer, List<PersistenceDigitPowerValue>> removeDuplicates(Map<Integer, List<PersistenceDigitPowerValue>> initialMap) {
        Map<Integer, List<PersistenceDigitPowerValue>> uniqueMap = new LinkedHashMap<>(15);

        for (int number : initialMap.keySet()) {
            List<PersistenceDigitPowerValue> reducedList = initialMap.get(number).stream()
                    .filter(pdpv -> isUniqueValueInList(pdpv, initialMap))
                    .collect(Collectors.toList());
            if (!reducedList.isEmpty()) {
                uniqueMap.put(number, reducedList);
            }
        }
        return uniqueMap;
    }

    private static boolean isUniqueValueInList(PersistenceDigitPowerValue pdpv, Map<Integer, List<PersistenceDigitPowerValue>> initialMap) {
        return !initialMap.keySet().stream()
                .filter(k -> k > pdpv.getDigit())
                .map(k -> initialMap.get(k))
                .flatMap(Collection::stream)
                .filter(fv -> pdpv.getValue().equals(fv.getValue()))
                .findFirst()
                .isPresent();
    }

    public static void main(String[] args) {
        printMapInfo();
    }
}
