package org.conway.multiplative.persistence;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValueMapTest {

    static final PersistenceDigitPowerValue PDPV21 = new PersistenceDigitPowerValue(2, 1, new BigInteger("2").pow(1));
    static final PersistenceDigitPowerValue PDPV22 = new PersistenceDigitPowerValue(2, 2, new BigInteger("2").pow(2));
    static final PersistenceDigitPowerValue PDPV23 = new PersistenceDigitPowerValue(2, 3, new BigInteger("2").pow(3));
    static final PersistenceDigitPowerValue PDPV24 = new PersistenceDigitPowerValue(2, 4, new BigInteger("2").pow(4));
    static final PersistenceDigitPowerValue PDPV25 = new PersistenceDigitPowerValue(2, 5, new BigInteger("2").pow(5));
    static final PersistenceDigitPowerValue PDPV26 = new PersistenceDigitPowerValue(2, 6, new BigInteger("2").pow(6));

    static final PersistenceDigitPowerValue PDPV31 = new PersistenceDigitPowerValue(3, 1, new BigInteger("3").pow(1));
    static final PersistenceDigitPowerValue PDPV32 = new PersistenceDigitPowerValue(3, 2, new BigInteger("3").pow(2));
    static final PersistenceDigitPowerValue PDPV33 = new PersistenceDigitPowerValue(3, 3, new BigInteger("3").pow(3));
    static final PersistenceDigitPowerValue PDPV34 = new PersistenceDigitPowerValue(3, 4, new BigInteger("3").pow(4));
    static final PersistenceDigitPowerValue PDPV35 = new PersistenceDigitPowerValue(3, 5, new BigInteger("3").pow(5));
    static final PersistenceDigitPowerValue PDPV36 = new PersistenceDigitPowerValue(3, 6, new BigInteger("3").pow(6));

    static final PersistenceDigitPowerValue PDPV41 = new PersistenceDigitPowerValue(4, 1, new BigInteger("4").pow(1));
    static final PersistenceDigitPowerValue PDPV42 = new PersistenceDigitPowerValue(4, 2, new BigInteger("4").pow(2));
    static final PersistenceDigitPowerValue PDPV43 = new PersistenceDigitPowerValue(4, 3, new BigInteger("4").pow(3));
    static final PersistenceDigitPowerValue PDPV44 = new PersistenceDigitPowerValue(4, 9, new BigInteger("4").pow(9));

    static final PersistenceDigitPowerValue PDPV61 = new PersistenceDigitPowerValue(6, 1, new BigInteger("6").pow(1));
    static final PersistenceDigitPowerValue PDPV62 = new PersistenceDigitPowerValue(6, 2, new BigInteger("6").pow(2));
    static final PersistenceDigitPowerValue PDPV63 = new PersistenceDigitPowerValue(6, 3, new BigInteger("6").pow(3));

    static final PersistenceDigitPowerValue PDPV71 = new PersistenceDigitPowerValue(7, 1, new BigInteger("7").pow(1));
    static final PersistenceDigitPowerValue PDPV72 = new PersistenceDigitPowerValue(7, 2, new BigInteger("7").pow(2));
    static final PersistenceDigitPowerValue PDPV73 = new PersistenceDigitPowerValue(7, 3, new BigInteger("7").pow(3));

    static final PersistenceDigitPowerValue PDPV81 = new PersistenceDigitPowerValue(8, 1, new BigInteger("8").pow(1));
    static final PersistenceDigitPowerValue PDPV82 = new PersistenceDigitPowerValue(8, 2, new BigInteger("8").pow(2));
    static final PersistenceDigitPowerValue PDPV83 = new PersistenceDigitPowerValue(8, 3, new BigInteger("8").pow(3));

    static final PersistenceDigitPowerValue PDPV91 = new PersistenceDigitPowerValue(9, 1, new BigInteger("9").pow(1));
    static final PersistenceDigitPowerValue PDPV92 = new PersistenceDigitPowerValue(9, 2, new BigInteger("9").pow(2));
    static final PersistenceDigitPowerValue PDPV93 = new PersistenceDigitPowerValue(9, 3, new BigInteger("9").pow(3));

    private static final List<PersistenceDigitPowerValue> LIST2 = new ArrayList<>();
    private static final List<PersistenceDigitPowerValue> LIST3 = new ArrayList<>();
    private static final List<PersistenceDigitPowerValue> LIST4 = new ArrayList<>();
    private static final List<PersistenceDigitPowerValue> LIST6 = new ArrayList<>();
    private static final List<PersistenceDigitPowerValue> LIST7 = new ArrayList<>();
    private static final List<PersistenceDigitPowerValue> LIST8 = new ArrayList<>();
    private static final List<PersistenceDigitPowerValue> LIST9 = new ArrayList<>();

    private static final List<PersistenceDigitPowerValue> ELIST2 = new ArrayList<>();
    private static final List<PersistenceDigitPowerValue> ELIST3 = new ArrayList<>();
    private static final List<PersistenceDigitPowerValue> ELIST4 = new ArrayList<>();
    private static final List<PersistenceDigitPowerValue> ELIST6 = new ArrayList<>();
    private static final List<PersistenceDigitPowerValue> ELIST7 = new ArrayList<>();
    private static final List<PersistenceDigitPowerValue> ELIST8 = new ArrayList<>();
    private static final List<PersistenceDigitPowerValue> ELIST9 = new ArrayList<>();

    private static final Map<Integer, List<PersistenceDigitPowerValue>> initialMap = new LinkedHashMap<Integer, List<PersistenceDigitPowerValue>>(15);
    private static final Map<Integer, List<PersistenceDigitPowerValue>> expectedMap = new LinkedHashMap<Integer, List<PersistenceDigitPowerValue>>(15);

    @BeforeAll
    public static void setup() {
        LIST2.add(PDPV21);
        LIST2.add(PDPV22);
        LIST2.add(PDPV23);
        LIST2.add(PDPV24);
        LIST2.add(PDPV25);
        LIST2.add(PDPV26);

        LIST3.add(PDPV31);
        LIST3.add(PDPV32);
        LIST3.add(PDPV33);
        LIST3.add(PDPV34);
        LIST3.add(PDPV35);
        LIST3.add(PDPV36);

        LIST4.add(PDPV41);
        LIST4.add(PDPV42);
        LIST4.add(PDPV43);
        LIST4.add(PDPV44);

        LIST6.add(PDPV61);
        LIST6.add(PDPV62);
        LIST6.add(PDPV63);

        LIST7.add(PDPV71);
        LIST7.add(PDPV72);
        LIST7.add(PDPV73);

        LIST8.add(PDPV81);
        LIST8.add(PDPV82);
        LIST8.add(PDPV83);

        LIST9.add(PDPV91);
        LIST9.add(PDPV92);
        LIST9.add(PDPV93);

        initialMap.put(2, LIST2);
        initialMap.put(3, LIST3);
        initialMap.put(4, LIST4);
        initialMap.put(6, LIST6);
        initialMap.put(7, LIST7);
        initialMap.put(8, LIST8);
        initialMap.put(9, LIST9);

        ELIST2.add(PDPV21);
        ELIST2.add(PDPV25);

        ELIST3.add(PDPV31);
        ELIST3.add(PDPV33);
        ELIST3.add(PDPV35);

        ELIST4.add(PDPV41);
        ELIST4.add(PDPV42);
        ELIST4.add(PDPV44);

        ELIST6.add(PDPV61);
        ELIST6.add(PDPV62);
        ELIST6.add(PDPV63);

        ELIST7.add(PDPV71);
        ELIST7.add(PDPV72);
        ELIST7.add(PDPV73);

        ELIST8.add(PDPV81);
        ELIST8.add(PDPV82);
        ELIST8.add(PDPV83);

        ELIST9.add(PDPV91);
        ELIST9.add(PDPV92);
        ELIST9.add(PDPV93);

        expectedMap.put(2, ELIST2);
        expectedMap.put(3, ELIST3);
        expectedMap.put(4, ELIST4);
        expectedMap.put(6, ELIST6);
        expectedMap.put(7, ELIST7);
        expectedMap.put(8, ELIST8);
        expectedMap.put(9, ELIST9);
    }

    @Test
    public void printMap() {
        ValueMap.printMapInfo();
    }

    @DisplayName("Remove duplicates from map")
    @Test
    public void removeDuplicates() {
        Map<Integer, List<PersistenceDigitPowerValue>> uniqueMap = ValueMap.removeDuplicates(initialMap);
        assertEquals(expectedMap, uniqueMap);
    }
}
