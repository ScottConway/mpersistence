package org.conway.multiplative.persistence;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class ValueMap {
    private static final int[] START_VALUES = {2, 3, 4, 6, 7, 8, 9};
    private static final int MAXPOWER = 10000;

    private static Map<Integer, List<PersistenceDigitPowerValue>> pdpvMap;
    private static Map<Integer, List<PersistenceDigitPowerValue>> reducedMap;

    static {
        buildMap();
        reducedMap = Collections.unmodifiableMap(removeDuplicates(pdpvMap));
    }

    private static void buildMap() {
        Map<Integer, List<PersistenceDigitPowerValue>> temp = new LinkedHashMap<>(15);
        for (int digit : START_VALUES) {
            System.out.println("Computing for " + digit);
            temp.put(digit, buildPowerList(digit));
        }
        pdpvMap = Collections.unmodifiableMap(temp);
    }

    private static List<PersistenceDigitPowerValue> buildPowerList(int digit) {
        List<PersistenceDigitPowerValue> values = new ArrayList<>(MAXPOWER);
        BigInteger multple = BigInteger.valueOf(digit);
        for (int i = 1; i <= MAXPOWER; i++) {
            BigInteger number = multple.pow(i);
            // System.out.println("\t\t" + digit + "  \t" + i + " " + number + "  " + PersistenceFinder.isGoodPersistencePossibility(digitsMultiplied) + " " + digitsMultiplied);
            if (PersistenceFinder.isGoodPersistencePossibility(number.toString())) {
                values.add(new PersistenceDigitPowerValue(digit, i, number));
            }
        }
        return values;
    }

    public static void printMapInfo() {
        System.out.println("\nOriginal Values\n");
        printMap(pdpvMap);
        System.out.println("\nReduced Values\n");
        printMap(reducedMap);
    }

    private static void printMap(Map<Integer, List<PersistenceDigitPowerValue>> map) {
        for (Map.Entry<Integer, List<PersistenceDigitPowerValue>> entry : map.entrySet()) {
            List<PersistenceDigitPowerValue> values = entry.getValue();
            System.out.println(entry.getKey() + ":  " + values.size());
            values.forEach(value -> System.out.println("\t\t" + value));
        }
    }

    public static Map<Integer, List<PersistenceDigitPowerValue>> removeDuplicates(Map<Integer, List<PersistenceDigitPowerValue>> initialMap) {
        Map<Integer, List<PersistenceDigitPowerValue>> uniqueMap = new LinkedHashMap<>(15);

        for (Map.Entry<Integer, List<PersistenceDigitPowerValue>> entry : initialMap.entrySet()) {
            List<PersistenceDigitPowerValue> reducedList = entry.getValue().stream()
                    .filter(pdpv -> isUniqueValueInList(pdpv, initialMap))
                    .collect(Collectors.toList());
            if (!reducedList.isEmpty()) {
                uniqueMap.put(entry.getKey(), reducedList);
            }
        }
        return uniqueMap;
    }

    private static boolean isUniqueValueInList(PersistenceDigitPowerValue pdpv, Map<Integer, List<PersistenceDigitPowerValue>> initialMap) {
        return initialMap.keySet().stream()
                .filter(k -> k > pdpv.getDigit())
                .map(k -> initialMap.get(k))
                .flatMap(Collection::stream)
                .noneMatch(fv -> pdpv.getValue().equals(fv.getValue()));
    }

    public static void main(String[] args) {
        printMapInfo();
    }
}
