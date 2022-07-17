package com.danandreicarp.unionfind;

import java.util.HashMap;
import java.util.Map;

public class SurroundedRegions {
//    int[] id;
//    int[] air;
    char[][] board;
    int m;
    int n;
    Map<Integer, Integer> idMap = new HashMap<>();
    Map<Integer, Integer> airMap = new HashMap<>();

    public void solve(char[][] board) {
        this.board = board;
        this.m = board.length;
        if (m < 2) {
            return;
        }
        this.n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    int index = getLinearIndex(i, j);
                    idMap.put(index, index);
                    airMap.put(index, 4);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    checkNeighbours(i, j);
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : idMap.entrySet()) {
            Integer root = entry.getValue();
            int[] rootIndex = getMatrixIndex(root);
            if (airMap.get(find(rootIndex[0], rootIndex[1])) == 0) {
                int[] matrixIndex = getMatrixIndex(entry.getKey());
                board[matrixIndex[0]][matrixIndex[1]] = 'X';
            }
        }
        System.out.println("done");
    }

    private void checkNeighbour(int i, int j, int k, int l) {
        if (board[k][l] == 'O') {
            union(i, j, k, l);
        }
        airMap.computeIfPresent(find(i, j), (key, value) -> --value);
    }

    private void union(int i, int j, int k, int l) {

        if (connected(i, j, k, l)) {
            return;
        }

        int root1 = find(i, j);
        int root2 = find(k, l);

        if (root1 != root2) {
            if (Math.random() <= 0.5) {
                idMap.put(root1, root2);
                airMap.computeIfPresent(root2, (key, value) -> value += airMap.get(root1));
                airMap.remove(root1);
            } else {
                idMap.put(root2, root1);
                airMap.computeIfPresent(root1, (key, value) -> value += airMap.get(root2));
                airMap.remove(root2);
            }
        }
    }

    private int find(int i, int j) {
        int index = getLinearIndex(i, j);
        int compressIndex = index;
        while (idMap.get(index) != index) {
            index = idMap.get(index);
        }

        // path compression
        while (idMap.get(compressIndex) != index) {
            int next = idMap.get(compressIndex);
            idMap.put(compressIndex, index);
            airMap.remove(compressIndex);
            compressIndex = next;
        }

        return index;
    }
    
    /*
    public void solve(char[][] board) {
        this.board = board;
        this.m = board.length;
        if (m < 2) {
            return;
        }
        this.n = board[0].length;
        
        id = new int[m * n];
        air = new int[m * n];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
            air[i] = 4;
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    checkNeighbours(i, j);
                } else {
                    id[getLinearIndex(i, j)] = -1;
                    air[getLinearIndex(i, j)] = -2;
                }
            }
        }

        for (int i = 0; i < id.length; i++) {
            if (id[i] != -1) {
                int[] mIndex = getMatrixIndex(i);
                int root = find(mIndex[0], mIndex[1]);
                if (air[root] < 1) {
                    board[mIndex[0]][mIndex[1]] = 'X';
                }
            }
        }
        System.out.println("done");
    }
    
    private void checkNeighbour(int i, int j, int k, int l) {
        if (board[k][l] == 'O') {
            union(i, j, k, l);
            --air[find(i, j)];
        } else {
            --air[find(i, j)];
        }
    }
    
    private void union(int i, int j, int k, int l) {

        if (connected(i, j, k, l)) {
            return;
        }

        int root1 = find(i, j);
        int root2 = find(k, l);

        if (root1 != root2) {
            if (Math.random() <= 0.5) {
                id[root1] = root2;
                air[root2] += air[root1];
                air[root1] = -1;
            } else {
                id[root2] = root1;
                air[root1] += air[root2];
                air[root2] = -1;
            }
        }
    }
    
    private int find(int i, int j) {
        int index = getLinearIndex(i, j);
        int compressIndex = index;
        while (id[index] != index) {
            index = id[index];
        }

        // path compression
        while (id[compressIndex] != index) {
            int next = id[compressIndex];
            id[compressIndex] = index;
            air[compressIndex] = -1;
            compressIndex = next;
        }

        return index;
    }
     */

    private void checkNeighbours(int i, int j) {
        if (i > 0) {
            checkNeighbour(i, j, i - 1, j);
        }
        if (i < m - 1) {
            checkNeighbour(i, j, i + 1, j);
        }
        if (j > 0) {
            checkNeighbour(i, j, i, j - 1);
        }
        if (j < n - 1) {
            checkNeighbour(i, j, i, j + 1);
        }
    }

    private boolean connected(int i, int j, int k, int l) {
        return find(i, j) == find(k, l);
    }

    private int getLinearIndex(int i, int j) {
        return i * n + j;
    }

    private int[] getMatrixIndex(int i) {
        int[] res = new int[2];
        res[0] = i / n;
        res[1] = i % n;
        return res;
    }
}
