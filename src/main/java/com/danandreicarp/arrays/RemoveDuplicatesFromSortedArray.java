package com.danandreicarp.arrays;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 1;
        while (j < nums.length) {
            while (nums[i] == nums[j]) {
                ++j;
                if (j == nums.length) break;
            }
            if (j == nums.length) break;
            nums[++i] = nums[j];
        }
        return i + 1;
    }
}
