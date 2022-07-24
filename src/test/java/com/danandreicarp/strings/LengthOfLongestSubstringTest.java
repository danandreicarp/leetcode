package com.danandreicarp.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthOfLongestSubstringTest {

    private LengthOfLongestSubstring app = new LengthOfLongestSubstring();

    @Test
    void testCase1() {
        assertEquals(3, app.lengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    void testCase2() {
        assertEquals(1, app.lengthOfLongestSubstring("bbbb"));
    }

    @Test
    void testCase3() {
        assertEquals(3, app.lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    void testCase4() {
        assertEquals(5, app.lengthOfLongestSubstring("abcbcaddaecb"));
    }

    @Test
    void testCase5() {
        assertEquals(4, app.lengthOfLongestSubstring("gaaqfeqlqky"));
    }
}