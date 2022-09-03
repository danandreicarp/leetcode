package com.danandreicarp.arrays;

public class DuplicateZeros {

    public void duplicateZeros(int[] arr) {
        int zeros = 0;
        boolean duplicateLastZero = false;
        for (int i = 0; i < arr.length - zeros - 1; i++) {
            if (arr[i] == 0) {
                ++zeros;
                if (i == arr.length - zeros - 1) {
                    // we can fit the duplicate of the final 'zero'
                    duplicateLastZero = true;
                }
            }
        }

        for (int j = arr.length - 1; zeros > 0 && j >= zeros; j--) {
            if (arr[j - zeros] == 0) {
                arr[j] = arr[j - zeros];
                if (j == arr.length - 1 && !duplicateLastZero) continue;
                arr[j - 1] = arr[j - zeros];
                --zeros;
                --j;
            } else {
                arr[j] = arr[j - zeros];
            }
        }
    }
}
