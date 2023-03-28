package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity;

public class testTable {
    int testID;
    String testString;

    public int getTestID() {
        return testID;
    }

    public void setTestID(int testID) {
        this.testID = testID;
    }

    public String getTestString() {
        return testString;
    }

    public void setTestString(String testString) {
        this.testString = testString;
    }

    @Override
    public String toString() {
        return "testTable{" +
                "testID=" + testID +
                ", testString='" + testString + '\'' +
                '}';
    }
}
