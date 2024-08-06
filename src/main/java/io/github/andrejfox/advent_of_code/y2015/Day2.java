package io.github.andrejfox.advent_of_code.y2015;

import io.github.andrejfox.advent_of_code.Day;
import io.github.andrejfox.advent_of_code.Util;
import java.util.Arrays;
import java.util.List;

public class Day2 implements Day {
    List<String> list = Util.readInput();
    int sum = 0;

    @Override
    public void part1() {
        for (String input : list) {
            int[] inputArr = Arrays.stream(input.split("x"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int side1 = inputArr[0] * inputArr[1];
            int side2 = inputArr[1] * inputArr[2];
            int side3 = inputArr[0] * inputArr[2];

            sum += 2 * side1 + 2 * side2 + 2 * side3 + Math.min(side1, Math.min(side2, side3));
        }
        System.out.println(sum);
    }

    @Override
    public void part2() {
        for (String input : list) {
            int[] inputArr = Arrays.stream(input.split("x"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            Arrays.sort(inputArr);

            int wrap = 2 * inputArr[0] + 2 * inputArr[1];
            int ribbon = inputArr[0] * inputArr[1] * inputArr[2];

            sum += wrap + ribbon;
        }
        System.out.println(sum);
    }
}