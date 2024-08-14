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

}