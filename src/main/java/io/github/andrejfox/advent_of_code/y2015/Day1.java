package io.github.andrejfox.advent_of_code.y2015;

import io.github.andrejfox.advent_of_code.Day;
import io.github.andrejfox.advent_of_code.Util;

public class Day1 implements Day {
    final String INPUT = Util.readInput().getFirst();
    int floor = 0;

    @Override
    public void part1() {
        for (char bracket : INPUT.toCharArray()) {
            if (bracket == '(') {
                floor++;
            } else {
                floor--;
            }
        }
        System.out.println(floor);
    }

    @Override
    public void part2() {
        for (int i = 0; i < INPUT.toCharArray().length; i++) {
            if (INPUT.toCharArray()[i] == '(') {
                floor++;
            } else {
                floor--;
            }

            if (floor == -1) {
                System.out.println(i + 1);
                return;
            }
        }
        System.out.println("Santa didn't go to the basement.");
    }
}