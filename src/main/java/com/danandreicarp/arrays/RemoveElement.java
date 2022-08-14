package com.danandreicarp.arrays;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            while (nums[i] == val) {
                while (nums[j] == val && j > i) {
                    --j;
                }
                if (j > i) nums[i++] = nums[j--];
                else return i;
            }
            if (j >= i) i++;
        }

        return i;
    }
}
