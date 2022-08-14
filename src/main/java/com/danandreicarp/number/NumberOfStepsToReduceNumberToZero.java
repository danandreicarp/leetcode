package com.danandreicarp.number;

public class NumberOfStepsToReduceNumberToZero {

    public int numberOfSteps(int num) {
        String binary = Integer.toBinaryString(num);
        int length = binary.length();
        int ones = Integer.bitCount(num);
        return (length - 1) + ones;
    }
}
