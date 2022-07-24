package com.danandreicarp.strings;

import java.util.*;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        if (s.length() == 1) return 1;

        int maxLength = 0;
        Set<Character> characterSet = new HashSet<>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            char currentChar = s.charAt(j);

            while (characterSet.contains(currentChar)) {
                characterSet.remove(s.charAt(i++));
            }
            characterSet.add(currentChar);
            maxLength = Math.max(maxLength, characterSet.size());
        }
        return maxLength;
    }
}
