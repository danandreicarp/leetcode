package com.danandreicarp.strings;

import java.util.*;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        if (s.length() == 1) return 1;

        int maxLength = 0;
        Set<Character> characterSet = new HashSet<>();
        LinkedList<Character> substring = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (char currentChar : chars) {
            if (characterSet.contains(currentChar)) {
                maxLength = updateMaxLength(maxLength, characterSet);
                resetSubstring(characterSet, substring, currentChar);
            } else {
                substring.add(currentChar);
                characterSet.add(currentChar);
            }
        }
        maxLength = updateMaxLength(maxLength, characterSet);
        return maxLength;
    }

    private int updateMaxLength(int maxLength, Set<Character> substring) {
        if (maxLength < substring.size()) {
            maxLength = substring.size();
        }
        return maxLength;
    }

    private void resetSubstring(Set<Character> characterSet,
                                LinkedList<Character> substring,
                                char currentChar) {

        //remove characters before the duplicate
        while (substring.peek() != currentChar) {
            Character ch = substring.poll();
            characterSet.remove(ch);
        }
        Character ch = substring.poll();
        characterSet.remove(ch);

        // add current character to new substring
        substring.addLast(currentChar);
        characterSet.add(currentChar);
    }
}
