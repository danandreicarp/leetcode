package com.danandreicarp.strings;

import java.util.*;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        if (s.length() == 1) return 1;

        int maxLength = 0;
        Map<Character, Integer> substringCharIndices = new HashMap<>();
        List<Character> substringChars = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (char currentChar : chars) {
            if (substringCharIndices.containsKey(currentChar)) {
                maxLength = updateMaxLength(maxLength, substringCharIndices);
                substringChars = resetSubstring(substringCharIndices, substringChars, currentChar);
            } else {
                substringChars.add(currentChar);
                substringCharIndices.put(currentChar, substringChars.size() - 1);
            }
        }
        maxLength = updateMaxLength(maxLength, substringCharIndices);
        return maxLength;
    }

    private int updateMaxLength(int maxLength, Map<Character, Integer> substring) {
        if (maxLength < substring.size()) {
            maxLength = substring.size();
        }
        return maxLength;
    }

    private ArrayList<Character> resetSubstring(Map<Character, Integer> substringCharIndices,
                                                List<Character> substringChars,
                                                char currentChar) {
        int index = substringCharIndices.get(currentChar);
        // skip current character
        index++;
        for (int i = 0; i < index; i++) {
            substringCharIndices.remove(substringChars.get(i));
        }
        // add current character to new substring
        substringChars.add(currentChar);
        for (int i = index; i < substringChars.size(); i++) {
            char ch = substringChars.get(i);
            substringCharIndices.put(ch, i - index);
        }
        return new ArrayList<>(substringChars.subList(index, substringChars.size()));
    }
}
