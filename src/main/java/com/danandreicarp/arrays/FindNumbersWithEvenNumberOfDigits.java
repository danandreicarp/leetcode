package com.danandreicarp.arrays;

public class FindNumbersWithEvenNumberOfDigits {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num < 10) continue;
            if (num < 100) { ++count; continue; }
            if (num < 1000) continue;
            if (num < 10_000) { ++count; continue; }
            if (num < 100_000) continue;
            if (num < 1_000_000) ++count;
        }
        return count;
//        return findNumbersString(nums);
    }

    private int findNumbersString(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (String.valueOf(num).length() % 2 == 0) {
                ++count;
            }
        }
        return count;
    }
}
