package com.danandreicarp.arrays;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            if (nums[i] == val) {
                if (nums[j] == val) --j;
                else nums[i] = nums[j--];
            } else {
                i++;
            }
        }

        return i;
    }
}
