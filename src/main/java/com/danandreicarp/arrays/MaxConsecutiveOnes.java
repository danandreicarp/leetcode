package com.danandreicarp.arrays;

public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int current = 0;
        for (int num : nums) {
            if (num == 0) {
                if (max < current) {
                    max = current;
                }
                current = 0;
            }
            else current++;
        }
        if (max < current) max = current;
        return max;
    }
}
