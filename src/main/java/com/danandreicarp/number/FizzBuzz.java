package com.danandreicarp.number;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> output = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            output.add(getElement(i));
        }
        return output;
    }

    private String getElement(int i) {
        if (i % 15 == 0) return "FizzBuzz";
        if (i % 5 == 0) return "Buzz";
        if (i % 3 == 0) return "Fizz";
        return String.valueOf(i);
    }
}
