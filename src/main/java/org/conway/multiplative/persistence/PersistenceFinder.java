package org.conway.multiplative.persistence;

import java.math.BigInteger;

public class PersistenceFinder {
    public static int findPersistenceValue(String number) {
        if (number.length() == 1)
            return 0;
        if (number.contains("0")) {
            return 1;
        }
        return 1 + findPersistenceValue(multiplyAllDigits(number));
    }

    public static String multiplyAllDigits(String number) {
        BigInteger bigNum = new BigInteger("1");
        for (Character digit : number.toCharArray()) {
            bigNum = bigNum.multiply(new BigInteger(digit.toString()));
        }
        return bigNum.toString();
    }

    public static boolean isGoodPersistencePossibility(String number) {
        return !number.contains("0") && !number.contains("5");
    }
}
