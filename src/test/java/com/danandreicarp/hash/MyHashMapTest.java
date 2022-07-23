package com.danandreicarp.hash;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MyHashMapTest {

    private static final MyHashMap map = new MyHashMap(1, 0.75);

    @Test
    @Order(1)
    void testPut() {
        map.put(1, 1);
        assertEquals(1, map.size());
        map.put(2, 2);
        assertEquals(2, map.size());
        map.put(3, 3);
        assertEquals(3, map.size());
        map.put(3, 4);
        assertEquals(3, map.size());
    }

    @Test
    @Order(2)
    void testGet() {
        assertEquals(4, map.get(3));
        assertEquals(2, map.get(2));
        assertEquals(1, map.get(1));
        assertEquals(-1, map.get(4));
    }

    @Test
    @Order(3)
    void testRemove() {
        map.remove(1);
        assertEquals(2, map.size());
        map.remove(3);
        assertEquals(1, map.size());
        map.remove(2);
        assertEquals(0, map.size());
        map.remove(4);
        assertEquals(0, map.size());
    }

    @Test
    void testCase1() {
        map.remove(2);
        assertEquals(0, map.size());
        map.put(3, 11);
        assertEquals(1, map.size());
        map.put(4, 13);
        assertEquals(2, map.size());
        map.put(15, 6);
        assertEquals(3, map.size());
        map.put(6, 15);
        assertEquals(4, map.size());
        map.put(8, 8);
        assertEquals(5, map.size());
        map.put(11, 0);
        assertEquals(6, map.size());
        assertEquals(0, map.get(11));
        map.put(1, 10);
        assertEquals(7, map.size());
        map.put(12, 14);
        assertEquals(8, map.size());
    }

    @Test
    void testCase2FindNullInsteadOfTombstone() {
        MyHashMap localMap = new MyHashMap(2, 0.75);
        localMap.put(2, 2);
        localMap.put(6, 6);
        localMap.remove(2);
        assertEquals(6, localMap.get(6));
    }

    @Test
    void testCase3PutOnlyTombstonesFree() {
        MyHashMap localMap = new MyHashMap(2, 0.75);
        localMap.put(2, 2);
        localMap.put(6, 6);
        localMap.put(10, 10);
        localMap.remove(6);
        localMap.put(4, 4);
        localMap.remove(10);
        localMap.put(6, 1);
        assertEquals(2, localMap.get(2));
    }

    @Test
    void testCase4TombstoneBeforeExistingKey() {
        MyHashMap localMap = new MyHashMap(2, 0.75);
        localMap.put(2, 2);
        localMap.put(6, 6);
        localMap.remove(2);
        localMap.put(6, 1);
        localMap.remove(6);
        assertEquals(-1, localMap.get(6));
    }

    private MyHashMap executeTestCase(String[] calls, int[][] values) {
        MyHashMap localMap = new MyHashMap();
        for (int i = 0; i < calls.length; i++) {
            switch (calls[i]) {
                case "put": localMap.put(values[i][0], values[i][1]); break;
                case "get": localMap.get(values[i][0]); break;
                case "remove": localMap.remove(values[i][0]); break;
                case "MyHashMap": localMap = new MyHashMap(); break;
            }
        }
        return localMap;
    }

    @Test
    void testManyAdds() {
        map.clear();
        int ITERATIONS = 32;
        for (int i = 0; i <= ITERATIONS; i++) {
            map.put(i, i);
            assertEquals(i + 1, map.size());
        }

        for (int i = ITERATIONS; i >= 0; i--) {
            map.remove(i);
            assertEquals(i, map.size());
        }
    }
}