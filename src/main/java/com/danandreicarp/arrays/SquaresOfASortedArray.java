package com.danandreicarp.arrays;

public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] output = new int[nums.length];

        int i = 0;
        int j = nums.length - 1;
        int k = j;
        while (i <= j) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                output[k--] = nums[i] * nums[i];
                i++;
            } else {
                output[k--] = nums[j] * nums[j];
                j--;
            }
        }

        return output;
    }
}
