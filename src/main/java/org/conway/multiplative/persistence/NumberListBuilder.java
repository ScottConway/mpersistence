package org.conway.multiplative.persistence;

import java.math.BigInteger;
import java.util.*;

public class NumberListBuilder {
    private static final int MIN_LEVEL = 7;

    private static List<NumberPV> buildNumberList() {
        List<NumberPV> npvList = new ArrayList<>(1024);
        Map<Integer, List<PersistenceDigitPowerValue>> resultMap = ValueMap.getReducedMap();

        int count = 1;
        for (PersistenceDigitPowerValue p2 : resultMap.get(2)) {
            System.out.println(count++ + " of " + resultMap.get(2).size());
            for (PersistenceDigitPowerValue p3 : resultMap.get(3)) {
                for (PersistenceDigitPowerValue p4 : resultMap.get(4)) {
                    for (PersistenceDigitPowerValue p6 : resultMap.get(6)) {
                        for (PersistenceDigitPowerValue p7 : resultMap.get(7)) {
                            for (PersistenceDigitPowerValue p8 : resultMap.get(8)) {
                                for (PersistenceDigitPowerValue p9 : resultMap.get(9)) {
                                    String number = p2.valueString() + p3.valueString() + p4.valueString() +
                                            p6.valueString() + p7.valueString() + p8.valueString() + p9.valueString();
                                    int pValue = PersistenceFinder.findPersistenceValue(number);
                                    if (pValue >= MIN_LEVEL) {
                                        npvList.add(new NumberPV(number, pValue));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return npvList;
    }

    public static void printNumberPVs() {
        List<NumberPV> npvList = buildNumberList();
        Collections.sort(npvList, new Comparator<NumberPV>() {
            @Override
            public int compare(NumberPV o1, NumberPV o2) {
                int pc = o1.getmPersistence() - o2.getmPersistence();
                if (pc == 0) {
                    pc = o1.getNumber().length() - o2.getNumber().length();
                }
                return pc != 0 ? pc : o1.getNumber().compareTo(o2.getNumber());
            }
        });
        npvList.forEach(npv -> System.out.println(npv.getmPersistence() + "  \t\t" + npv.getNumber()));
    }

    public static Map<Integer, BigInteger> buildMap(int minLevel) {
        Map<Integer, BigInteger> valueMap = new HashMap<>();
        Map<Integer, List<PersistenceDigitPowerValue>> resultMap = ValueMap.getReducedMap();

        int count = 1;
        for (PersistenceDigitPowerValue p2 : resultMap.get(2)) {
            System.out.println(count++ + " of " + resultMap.get(2).size());
            for (PersistenceDigitPowerValue p3 : resultMap.get(3)) {
                for (PersistenceDigitPowerValue p4 : resultMap.get(4)) {
                    for (PersistenceDigitPowerValue p6 : resultMap.get(6)) {
                        for (PersistenceDigitPowerValue p7 : resultMap.get(7)) {
                            for (PersistenceDigitPowerValue p8 : resultMap.get(8)) {
                                for (PersistenceDigitPowerValue p9 : resultMap.get(9)) {
                                    String number = p2.valueString() + p3.valueString() + p4.valueString() +
                                            p6.valueString() + p7.valueString() + p8.valueString() + p9.valueString();
                                    int pValue = PersistenceFinder.findPersistenceValue(number);
                                    if (pValue >= minLevel) {
                                        BigInteger bigInteger = new BigInteger(number);
                                        if (!valueMap.containsKey(pValue) || (bigInteger.compareTo(valueMap.get(pValue)) < 0)) {
                                            valueMap.put(pValue, bigInteger);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return valueMap;
    }
}
