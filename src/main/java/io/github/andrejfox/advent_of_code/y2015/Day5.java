package io.github.andrejfox.advent_of_code.y2015;

import io.github.andrejfox.advent_of_code.Day;
import io.github.andrejfox.advent_of_code.Util;

import java.util.List;

public class Day5 implements Day {
    List<String> input = Util.readInput();
    @Override
    public void part1() {
        int count = 0;
        for (String element : input) {
            if (hasDouble(element) && hasVowels(element) && doesNotContain(element)) {
                count++;
            }
        }
        System.out.println(count);
    }

    @Override
    public void part2() {
        int count = 0;
        for (String element : input) {
            if (hasTwoDoubles(element) && repeatsOverLetter(element)) {
                count++;
            }
        }
        System.out.println(count);
    }

    private boolean hasDouble(String input) {
        char target = input.charAt(0);

        for (int i = 1; i < input.length(); i++) {
            if (target == input.charAt(i)) {
                return true;
            }
            target = input.charAt(i);
        }
        return false;
    }

    private boolean hasVowels(String input) {
        int count = 0;

        for (char character: input.toCharArray()) {
            if (character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u') {
                count++;
            }
        }

        return count >= 3;
    }

    private boolean doesNotContain(String input) {
        if (input.contains("ab")) {
            return false;
        }
        if (input.contains("cd")) {
            return false;
        }
        if (input.contains("pq")) {
            return false;
        }
        return !input.contains("xy");
    }

    private boolean hasTwoDoubles(String input) {
        if (input.length() < 4) {
            return false;
        }

        for (int targetIndex = 0; targetIndex < input.length() - 1; targetIndex++) {
            String targetString = String.valueOf(input.charAt(targetIndex)) + input.charAt(targetIndex + 1);
            for (int testIndex = 0; testIndex < input.length() - 1; testIndex++) {
                if (testIndex == targetIndex || testIndex - 1 == targetIndex || testIndex + 1 == targetIndex) {
                    continue;
                }

                String testString = String.valueOf(input.charAt(testIndex)) + input.charAt(testIndex + 1);
                if (targetString.equals(testString)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean repeatsOverLetter(String input) {
        for (int i = 2; i < input.length(); i++) {
            if (input.charAt(i - 2) == input.charAt(i)) {
                return true;
            }
        }
        return false;
    }
}