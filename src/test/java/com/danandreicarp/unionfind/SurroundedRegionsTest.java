package com.danandreicarp.unionfind;

import org.junit.jupiter.api.Test;

class SurroundedRegionsTest {
    private final SurroundedRegions app = new SurroundedRegions();

    @Test
    void testSolve() {
        char[][] board = new char[][]{
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}};
        app.solve(board);
    }

    @Test
    void testSolve2() {
        char[][] board = new char[][]{
                {'X','O','X','O','X','O'},
                {'O','X','O','X','O','X'},
                {'X','O','X','O','X','O'},
                {'O','X','O','X','O','X'}};
        app.solve(board);
    }
    
    @Test
    void testSolve3() {
        char[][] board = new char[][]{
                {'X','X','X','X','X'},
                {'X','O','O','O','X'},
                {'X','X','O','O','X'},
                {'X','X','X','O','X'},
                {'X','O','X','X','X'}};
        app.solve(board);
    }
}