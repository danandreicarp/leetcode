package com.danandreicarp.number;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> output = new ArrayList<>(n);

        for (int i = 1; i <= n; i++) {
            StringBuilder result = new StringBuilder();
            if (i % 3 == 0) {
                result.append("Fizz");
            }
            if (i % 5 == 0) {
                result.append("Buzz");
            }
            if (result.length() == 0) {
                result.append(i);
            }
            output.add(result.toString());
        }
        return output;
    }
}

