package com.danandreicarp.arrays;

public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] output = new int[nums.length];

        int i = 0;
        int j;
        while (i < nums.length) {
            int vi = Math.abs(nums[i]);
            int index = 0;
            int shift = 0;
            int count = 0;
            if (nums[i] < 0) {
                // count the numbers less than this, going forward
                for (j = i + 1; j < nums.length; j++) {
                    if (vi > Math.abs(nums[j])) ++count;
                    // not using 'abs' here to avoid hitting the same index in a [-3, 1, 3] scenario
                    else if (nums[i] == nums[j]) ++shift;
                    // no other values will be less than this going forward
                    else if (vi < nums[j]) break;
                }
                index = count + shift;
            } else {
                // count the numbers less than this, going backward
                for (j = i - 1; j >= 0; j--) {
                    int vj = Math.abs(nums[j]);
                    if (vi > vj) ++count;
                    // using 'abs' here to count all the matching numbers
                    else if (vi == vj) ++shift;
                    // no other values will be less than this going backward
                    else break;
                }
                index = count + shift;
            }
            output[index] = vi * vi;
            ++i;
        }

        return output;
    }
}
