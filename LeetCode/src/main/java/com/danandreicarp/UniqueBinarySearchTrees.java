package com.danandreicarp;

import java.util.HashMap;
import java.util.Map;

public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        if (n == 0 || n == 1) return 1;

        Map<Integer, Integer> previousResults = new HashMap<>();

        int count = 0;
        for (int i = 1; i <= n; i++) {
            int leftSideTrees = previousResults.computeIfAbsent(i - 1, this::numTrees);
            int rightSideTrees = previousResults.computeIfAbsent(n - i, this::numTrees);
            count += leftSideTrees * rightSideTrees;
        }
        return count;
    }

    public int numTreesArray(int n) {
        int[] counts = new int[n + 1];
        counts[0] = 1;
        counts[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                counts[i] += counts[j - 1] * counts[i - j];
            }
        }
        return counts[n];
    }

    public int numTreesCatalan(int n) {
        long catalan = 1;
        for (int i = 1; i <= n; i++) {
            catalan = catalan * 2 * (2 * (i - 1) + 1) / (i + 1);
        }
        return (int) catalan;
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees app = new UniqueBinarySearchTrees();
        int n = 19;
        int result = app.numTrees(n);
        System.out.println(result);
        int arrResult = app.numTreesArray(n);
        System.out.println(arrResult);
        int catResult = app.numTreesCatalan(n);
        System.out.println(catResult);
    }
}
