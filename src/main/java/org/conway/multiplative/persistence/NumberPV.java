package org.conway.multiplative.persistence;

public class NumberPV {
    private String number;
    private int mPersistence;

    public NumberPV(String number, int mPersistence) {
        this.number = number;
        this.mPersistence = mPersistence;
    }

    public String getNumber() {
        return number;
    }

    public int getmPersistence() {
        return mPersistence;
    }
}
