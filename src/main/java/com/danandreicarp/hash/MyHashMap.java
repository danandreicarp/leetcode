package com.danandreicarp.hash;

import java.util.Arrays;

public class MyHashMap {
    private static final double DEFAULT_LOAD_FACTOR = 0.75;
    private static final int TOMBSTONE = -2;
    private int[] keys;
    private int[] values;
    private int size;
    private final double loadFactor;

    public MyHashMap(int capacityPowerOfTwo, double loadFactor) {
        this.loadFactor = loadFactor;
        keys = new int[(int) Math.pow(2, capacityPowerOfTwo)];
        Arrays.fill(keys, -1);
        values = new int[(int) Math.pow(2, capacityPowerOfTwo)];
    }

    public MyHashMap() {
        this(3, DEFAULT_LOAD_FACTOR);
    }

    public void put(int key, int value) {
        resize();
        putValue(key, value);
    }

    public int get(int key) {
        int index = getIndex(key);

        if (keys[index] == key) {
            return values[index];
        } else {
            return -1;
        }
    }

    public void remove(int key) {
        int index = getIndex(key);

        if (keys[index] == key) {
            keys[index] = TOMBSTONE;
            values[index] = 0;
            size--;
        }

//        resizeDown();
    }

    public int size() {
        return size;
    }

    public void clear() {
        size = 0;
        keys = new int[keys.length];
        Arrays.fill(keys, -1);
        values = new int[values.length];
    }

    private void resize() {
        if (size < keys.length * loadFactor) {
            return;
        }

        int[] oldKeys = keys;
        int[] oldValues = values;

        keys = new int[keys.length * 2];
        Arrays.fill(keys, -1);
        values = new int[values.length * 2];
        size = 0;

        for (int i = 0; i < oldKeys.length; i++) {
            if (oldKeys[i] != -1 && oldKeys[i] != TOMBSTONE) {
                putValue(oldKeys[i], oldValues[i]);
            }
        }
    }

    /**
     * Not worth the cost.
     */
    private void resizeDown() {
        if (size <= 4 || size * 2 > keys.length * loadFactor) {
            return;
        }

        int[] oldKeys = keys;
        int[] oldValues = values;
        int oldSize = size;

        keys = new int[keys.length / 2];
        Arrays.fill(keys, -1);
        values = new int[values.length / 2];
        size = 0;

        for (int i = 0; i < oldKeys.length; i++) {
            if (oldKeys[i] != -1 && oldKeys[i] != TOMBSTONE) {
                putValue(oldKeys[i], oldValues[i]);
                --oldSize;
            }
            if (oldSize <= 0) {
                break;
            }
        }
    }

    private void putValue(int key, int value) {
        int index = getIndexForPut(key);

        // inserting a new value
        if (keys[index] == -1 || keys[index] == TOMBSTONE) {
            ++size;
        }
        keys[index] = key;
        values[index] = value;
    }

    private int getIndexForPut(int key) {
        int x = 1;
        int hash = Integer.valueOf(key).hashCode();
        int index = normalizeIndex(hash);
        int firstTombstone = -1;
        int start = index;
        int loop = -1;

        while (keys[index] != key && keys[index] != -1 && loop < 1) {
            if (keys[index] == TOMBSTONE && firstTombstone == -1) firstTombstone = index;
            if (index == start) ++loop;
            index = normalizeIndex(hash + probe(x++));
        }

        if (loop == 1) {
            if (firstTombstone == -1) {
                throw new IllegalStateException("couldn't find slot for " + key);
            } else {
                // only tombstone slots free
                index = firstTombstone;
            }
        }

        // found an empty slot, but there's a tombstone closer
        if (keys[index] == -1 && firstTombstone != -1) {
            index = firstTombstone;
        }
        return index;
    }

    private int getIndex(int key) {
        int x = 1;
        int hash = Integer.valueOf(key).hashCode();
        int index = normalizeIndex(hash);
        while (keys[index] != key && keys[index] != -1) {
            index = normalizeIndex(hash + probe(x++));
        }
        return index;
    }

    private int normalizeIndex(int hash) {
        return Math.abs(hash % keys.length);
    }

    private int probe(int x) {
        return (x * x + x) / 2;
    }
}
