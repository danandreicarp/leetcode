package com.danandreicarp.arrays;

import java.util.Arrays;

public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        boolean needsSort = nums[0] < 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        if (needsSort) Arrays.sort(nums);
        return nums;
    }
}
